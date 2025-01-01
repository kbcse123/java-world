package com.javaworld.A1_Core_Java.z_helperbeans;

import java.lang.annotation.Repeatable;

/**
 * @author Shaik Khader
 
1.Question: What is wrong with the following interface:

	interface House {
	    @Deprecated
	    public void open();
	    public void openFrontDoor();
	    public void openBackDoor();
	}

2.Question: Consider this implementation of the House interface, shown in Question 1.
		public class MyHouse implements House {
		    public void open() {}
		    public void openFrontDoor() {}
		    public void openBackDoor() {}
		}
	If you compile this program, the compiler produces a warning because open was deprecated (in the interface). What can you do to 
	get rid of that warning?

3.Question: Will the following code compile without error? Why or why not?

		public @interface Meal { ... }
		
		@Meal("breakfast", mainDish="cereal")
		@Meal("lunch", mainDish="pizza")
		@Meal("dinner", mainDish="salad")
		public void evaluateDiet() { ... }
		


 */


//1. Answer: The documentation should reflect why open is deprecated and what to use instead. For example:

	interface House { 
	    /**
	     * @deprecated use of open 
	     * is discouraged, use
	     * openFrontDoor or 
	     * openBackDoor instead.
	     */
	    @Deprecated
	    public void open(); 
	    public void openFrontDoor();
	    public void openBackDoor();
	}

//2. Answer: You can deprecate the implementation of open:

	class MyHouse1 implements House { 
	    // The documentation is inherited from the interface.
	    @Deprecated
	    public void open() {} 
	    
	    public void openFrontDoor() {}
	    
	    public void openBackDoor() {}
	}
	//Alternatively, you can suppress the warning:
	
	class MyHouse2 implements House { 
	    public void open() {} 
	    
	    public void openFrontDoor() {}
	    
	    public void openBackDoor() {}
	}

//3. Answer: The code fails to compile because the Meal annotation type was not defined to be repeatable. It can be fixed by adding
	//the @Repeatable meta-annotation and defining a container annotation type: 

	@Repeatable(MealContainer.class)
	@interface Meal { 
		String mealType();
		String mainDish();
	}

	@interface MealContainer {
	    Meal[] value();
	}
	
	class MealClass {
		
		@Meal(mealType="breakfast", mainDish="cereal")
		@Meal(mealType="lunch", mainDish="pizza")
		@Meal(mealType="dinner", mainDish="salad")
		public void evaluateDiet() { }
	}

	
//Main Class	
public class Exercises_Annotations {
	public static void main(String... args) {

	}

}


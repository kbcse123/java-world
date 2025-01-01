package com.javaworld.A1_Core_Java.A4_Interfaces_And_Inheritance;

/**
 * @author Shaik Khader
 
 Instance Methods (Override):

	. An instance method in a subclass with the same signature (name, plus the number and the type of its parameters)
    and return type as an instance method in the superclass overrides the superclass's method.
	
	. An overriding method can also return a subtype of the type returned by the overridden method. This subtype is
    called a "covariant return type".
	
	. When overriding a method, you might want to use the @Override annotation that instructs the compiler that you
    intend to override a method in the superclass. If, for some reason, the compiler detects that the method does not
    exist in one of the superclasses, then it will generate an error.
 
 Static Methods (Hide):

	. If a subclass defines a static method with the same signature as a static method in the superclass, then the
    method in the subclass hides the one in the superclass.
 
 	. In the below example The Cat class overrides the instance method in Animal and hides the static method in Animal.
    The main method in this class creates an instance of Cat and invokes testClassMethod() on the class and
    testInstanceMethod() on the instance.
 
 Interface Methods:

	. Default methods and abstract methods in interfaces are inherited like instance methods. However, when the super
    types of a class or interface provide multiple default methods with the same signature, the Java compiler follows
    inheritance rules to resolve the name conflict. These rules are driven by the following two principles:
	
		1. Instance methods are preferred over interface default methods.
		2. Methods that are already overridden by other candidates are ignored. This circumstance can arise when super
        types share a common ancestor.
			
	. If two or more independently defined default methods conflict, or a default method conflicts with an abstract
    method, then the Java compiler produces a compiler error. You must explicitly override the super type methods. see
    the FlyCar example. A class that implements both LandCar and FlyCar must override the method startEngine. You
    could invoke any (or both) of the default implementations with the super keyword.

	. Inherited instance methods from classes can override abstract interface methods. Consider the example of Mammal.
    The method Mustang.identifyMyself returns the string "I am a horse". The class Mustang inherits the method identify
    Myself from the class Horse, which overrides the abstract method of the same name in the interface Mammal.

 Note: Static methods in interfaces are never inherited.
 
The following table summarizes what happens when you define a method with the same signature as a method in a superclass.
 
	--------------------------------------------------------------------------------------------------------------
				 	                     Superclass Instance Method	       				Superclass Static Method
	--------------------------------------------------------------------------------------------------------------
		Subclass Instance Method  |	          Overrides							|	Generates a compile-time error
	--------------------------------------------------------------------------------------------------------------
		Subclass Static Method	  |	   Generates a compile-time error			|			Hides
	--------------------------------------------------------------------------------------------------------------
		
				
				
 */

//Instance and static Methods.
class AnimalClass {
    public static void testClassMethod() {
        System.out.println("The static method in Animal");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Animal");
    }
}
class Cat extends AnimalClass {
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }
}
//end

// Interface Methods. Rule 1
class Horse {
    public String identifyMyself() {
        return "I am a horse.";
    }
}
interface Flyer {
    default String identifyMyself() {
        return "I am able to fly.";
    }
}
interface Mythical {
    default String identifyMyself() {
        return "I am a mythical creature.";
    }
}
class Pegasus extends Horse implements Flyer, Mythical {
}
//end

//Interface Methods. Rule 2
interface Animal {
	
    default public String identifyMyself() {
        return "I am an animal.";
    }
}
interface WildAnimal extends Animal {
    default public String identifyMyself() {
        return "I am Wild Animal.";
    }
}
interface DomesticAnimal extends Animal { 
}

class Lion implements WildAnimal, DomesticAnimal {}

//end

//Explicitly override the super type methods
interface LandCar {
    default public void startEngine() {
    	 System.out.println("in LandCar startEngine()");
    }
}
interface FlyCar {
    default public void startEngine() {
    	 System.out.println("in FlyCar startEngine()");
    }
}

class FlyingCar implements LandCar, FlyCar {

	@Override
	public void startEngine() {
		LandCar.super.startEngine();
		//FlyCar.super.startEngine();
	}
	
}
//end

// Inherited instance methods from classes can override abstract interface methods
interface Mammal {
    String identifyMyself();
}
class Mustang extends Horse implements Mammal {}
//end




public class B3_Overriding_and_Hiding_Methods {
	public static void main(String... args) {
		System.out.println("**** Instance and static Methods ****");
		Cat myCat = new Cat();
        AnimalClass myAnimal = myCat;
        AnimalClass.testClassMethod();
        myAnimal.testInstanceMethod();
        
        System.out.println("\n**** Interface Methods - Rule 1 ****");
		Pegasus pegasus = new Pegasus();
        System.out.println(pegasus.identifyMyself());
        
        System.out.println("\n**** Interface Methods - Rule 2 ****");
		Lion lion = new Lion();
        System.out.println(lion.identifyMyself());
        
        System.out.println("\n**** Inherited instance methods from classes can override abstract interface methods ****");
		
        Mustang mustang = new Mustang();
        System.out.println(mustang.identifyMyself());
	}

}

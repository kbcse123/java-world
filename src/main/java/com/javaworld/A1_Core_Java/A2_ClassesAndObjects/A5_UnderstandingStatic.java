package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;

/**
 * Class(static) Variables:
 *
 *  . When objects are created from the same class blueprint, they each have their own distinct copies of instance 
 *    variables. In the case of Bicycle class (below example), the instance variables are cadence, gear, and speed. 
 *    Each Bicycle object has its own values for these variables, stored in different memory locations.
 *  . Sometimes, you want to have variables that are common to all objects. This is accomplished with the static 
 *    modifier. Fields that have the static modifier in their declaration are called static fields or class variables.
 *    They are associated with the class, rather than with any object. 
 *  . Every instance of the class shares a class variable, which is in one fixed location in memory. 
 *  . Any object can change the value of a class variable, and class variables can also be manipulated without creating
 *    an instance of the class(unless variable is not final).
 * 
 * Class(static) Methods:
 *
 *  . The Java programming language supports static methods as well as static variables. Static methods, which have the
 *    static modifier in their declarations, should be invoked with the class name, without the need for creating an 
 *    instance of the class , as in "ClassName.methodName(args)".
 *  . A common use for static methods is to access static fields.
 *  . Not all combinations of instance, class variables and methods are allowed:
 *	  - Instance methods can access instance variables and instance methods directly.
 *	  - Instance methods can access class variables and class methods directly.
 *	  - static methods can access other static variables and static methods directly.
 *	  - static methods cannot access instance variables or instance methods directly,they must use an object reference.
 *	    Also, static methods cannot use 'this' keyword as there is no instance for this to refer to.
 *
 * Note: You can also refer to static methods or static variable with an object reference but this is discouraged because
 *       it does not make it clear that they are class methods or class variables.
 *
 * Constants:
 *
 *  . The static modifier, in combination with the final modifier, is also used to define constants. The final modifier
 *    indicates that the value of this field cannot change. For example, the following variable declaration defines a 
 *    constant named PI, whose value is an approximation of pi (the ratio of the circumference of a circle to its 
 *    diameter):    static final double PI_VAL = 3.141592653589793;
 *  . Constants defined in this way cannot be reassigned, and it is a compile-time error if your program tries to do so.
 *    By convention, the names of constant values are spelled in uppercase letters. If the name is composed of more than
 *    one word, the words are separated by an underscore ' _ '.
 * 
 * Note: If a primitive type or a String is defined as a constant and the value is known at compile time, the compiler 
 *       replaces the constant name everywhere in the code with its value. This is called a compile-time constant.
 */

public class A5_UnderstandingStatic {
	public static void main(String[] args) {
		Bicycle cityBike = new Bicycle(2, 5, 30);
		Bicycle mountainBike = new Bicycle(12, 3, 20);
		// discouraged
		System.out.println("Using instance variable - Total Bicycles Created so far = " 
		+ cityBike.getNumberOfBicycles());
		// Recommended way
		System.out.println("Using Class variable - Total Bicycles Created so far = " 
		+ Bicycle.getNumberOfBicycles());
	}
}

class Bicycle {
    private int cadence;
    private int gear;
    private int speed;
    private int id;
    private static int numberOfBicycles = 0;

    public Bicycle(int startCadence,
                   int startSpeed,
                   int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
        id = ++numberOfBicycles;
    }

    public int getID() {
        return id;
    }

    public static int getNumberOfBicycles() {
        return numberOfBicycles;
    }

    public int getCadence() {
        return cadence;
    }
        
    public void setCadence(int newValue) {
        cadence = newValue;
    }
        
    public int getGear(){
        return gear;
    }
        
    public void setGear(int newValue) {
        gear = newValue;
    }
        
    public int getSpeed() {
        return speed;
    }
        
    public void applyBrake(int decrement) {
        speed -= decrement;
    }
        
    public void speedUp(int increment) {
        speed += increment;
    }
}
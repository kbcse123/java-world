package com.javaworld.A1_Core_Java.A4_Interfaces_And_Inheritance;
/**
 *
 */

import com.javaworld.A1_Core_Java.z_helperbeans.OperateCar;

/**
 * @author Shaik Khader

Default Methods:

. As of the Java SE 8 release, You can define new methods in existing interface as default methods. Default methods
  enable you to add new functionality to the interfaces of your libraries and ensure binary compatibility with code
  written for older versions of those interfaces. Note that you must provide an implementation for default methods.

. In particular, default methods enable you to add methods that accept lambda expressions as parameters to existing interfaces.

Static Methods:

. You could also define new static methods to existing interfaces. Since static method is associated with the class in
  which it is defined rather than with any object, Every instance of the class shares its static methods. This makes it
  easier for you to organize helper methods in your libraries; you can keep static methods specific to an interface
  in the same interface rather than in a separate class.

. Users who have classes that implement interfaces enhanced with new default or static methods do not have to modify or
  recompile them to accommodate the additional methods. See OperateCar interface.

 */


public class A3_Default_and_Static_Methods implements OperateCar {

    @Override
    public int turn(Direction direction, double radius, double startSpeed, double endSpeed) {
        return 0;
    }

    @Override
    public int changeLanes(Direction direction, double startSpeed, double endSpeed) {
        return 0;
    }

    @Override
    public int signalTurn(Direction direction, boolean signalOn) {
        return 0;
    }

    @Override
    public int getRadarFront(double distanceToCar, double speedOfCar) {
        return 0;
    }

    @Override
    public int getRadarRear(double distanceToCar, double speedOfCar) {
        return 0;
    }

    //uncomment this method to override.
	@Override
	public void defaultMethod() {
		System.out.println("in A3_Default_And_Static_Methods defaultMethod()");
	}

    public static void main(String... args) {
        A3_Default_and_Static_Methods defaultAndStaticMethodsDemo = new A3_Default_and_Static_Methods();
        defaultAndStaticMethodsDemo.startEngine();
        OperateCar.staticMethod();
        defaultAndStaticMethodsDemo.defaultMethod();
    }

}

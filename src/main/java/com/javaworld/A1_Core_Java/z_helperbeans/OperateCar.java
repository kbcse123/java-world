package com.javaworld.A1_Core_Java.z_helperbeans;

/**
 * @author Shaik Khader
 
 */
public interface OperateCar {

	 // constant declarations, if any
	
	   // An enum with values RIGHT, LEFT
	   enum Direction{
		   RIGHT, LEFT
	   }
	   int constantVal = 123;
	   // method signatures. Note that the method signatures have no braces and are terminated with a semicolon.
	   int turn(Direction direction,double radius,double startSpeed,double endSpeed);
	   int changeLanes(Direction direction,double startSpeed,double endSpeed);
	   int signalTurn(Direction direction, boolean signalOn);
	   int getRadarFront(double distanceToCar,double speedOfCar);
	   int getRadarRear(double distanceToCar, double speedOfCar);
	         
	   // more method signatures
	   
	   default void startEngine() {
		   System.out.println("in OperateCar startEngine()");
		   //method body
	   }
	   static void staticMethod() {
		   System.out.println("in OperateCar staticMethod()");
		 //method body
	   }
		default void defaultMethod() {
			System.out.println("in OperateCar defaultMethod()");
		}
}


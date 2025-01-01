package com.javaworld.A1_Core_Java.A4_Interfaces_And_Inheritance;

import com.javaworld.A1_Core_Java.z_helperbeans.OperateCar;

/**
 * @author Shaik Khader
 
 	. Suppose that, at a later time, you want to add a new method to OperateCar interface. If you make
      this change, then all classes that implemented the OperateCar interface will break because they
      no longer implement the old interface.
 	  
 	. As of Java 7, If you want to add additional methods to an interface, you have one option.
      You could create a OperateCarPlus interface that extends OperateCar: See below code.
 	  Now users of your code can choose to continue to use the old interface or to upgrade to the new
      interface.

 */


interface OperateCarPlus extends OperateCar {

	   boolean didItWork(int i, double x, String s);
	   
}

public class A2_EvolvingInterfaces implements OperateCarPlus{

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

	@Override
	public boolean didItWork(int i, double x, String s) {
		
		return false;
	}
	
	
	
}

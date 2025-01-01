package com.javaworld.A1_Core_Java.z_helperbeans;

/**
 * @author Shaik khader
 *
 */
public class Bicycle {
	int cadence = 0;
	int speed = 0;
	int gear = 1;

	void changeCadence(int newValue) {
		cadence = newValue;
	}

	void changeGear(int newValue) {
		gear = newValue;
	}

	void speedUp(int increment) {
		speed = speed + increment;
	}

	void applyBrakes(int decrement) {
		speed = speed - decrement;
	}

	
	/**
	 * 
	 */
	public Bicycle() {
	}

	public Bicycle(int startCadence, int startSpeed, int startGear) {
		cadence = startCadence;
		speed = startSpeed;
		gear = startGear;

	}
	void printStates() {
		System.out.println("cadence:" + cadence + " speed:" + speed + " gear:"
				+ gear);
	}

	public void printDescription() {
		System.out.print("\nBike is " + "in gear " + this.gear
				+ " with a cadence of " + this.cadence
				+ " and travelling at a speed of " + this.speed +" km/hr");
	}

}

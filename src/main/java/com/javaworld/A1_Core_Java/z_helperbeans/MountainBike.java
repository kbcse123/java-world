package com.javaworld.A1_Core_Java.z_helperbeans;

/**
 * @author Shaik Khader
 *
 */
public class MountainBike extends Bicycle {
	private String suspension;

	public MountainBike(int startCadence, int startSpeed, int startGear,
			String suspensionType) {
		super(startCadence, startSpeed, startGear);
		this.setSuspension(suspensionType);
	}

	public String getSuspension() {
		return this.suspension;
	}

	public void setSuspension(String suspensionType) {
		this.suspension = suspensionType;
	}
	
	//this overrides the parent method
	public void printDescription() {
		super.printDescription();
		System.out.println(" The MountainBike has a " +
	            getSuspension() + " suspension.");
	}

	/**
	 * 
	 */
	public MountainBike() {
		// TODO Auto-generated constructor stub
	}

}

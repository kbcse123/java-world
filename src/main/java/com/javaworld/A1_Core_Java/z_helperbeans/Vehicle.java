package com.javaworld.A1_Core_Java.z_helperbeans;

/**
 * @author Shaik khader
 *
 */
public class Vehicle {
	
	protected String type;
	
	protected String name;
	
	protected String color;
	
	protected int maxSpeed; 
	
	
	/**
	 * 
	 */
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}


	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}


	/**
	 * @return the maxSpeed
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}


	/**
	 * @param maxSpeed the maxSpeed to set
	 */
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public void showSpecs() {
		System.out.println("Name: "+name+"\nType: "+type+"\ncolor: "+color+"\nmaxSpeed: "+maxSpeed);
	}
	
	
}

package com.javaworld.A1_Core_Java.z_helperbeans;

/**
 * @author Shaik khader
 *
 */
public class Engine {
	
	private int horsePower;
	private int cylinders;
	
	public int getHorsePower() {
		return horsePower;
	}
	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
	public int getCylinders() {
		return cylinders;
	}
	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}
	public Engine() {
		// TODO Auto-generated constructor stub
	}
	public void showSpecs() {
		
		System.out.println("Horse Power: "+horsePower+"\ncylinders: "+cylinders);
	}
	public void start(){  
        System.out.println("Engine Started...");  
    }  
    public void stop(){  
        System.out.println("Engine Stopped!!!");  
    } 

}

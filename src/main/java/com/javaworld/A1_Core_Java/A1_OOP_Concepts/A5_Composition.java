package com.javaworld.A1_Core_Java.A1_OOP_Concepts;

/**
 * Composition simply means referencing the class or interface as an instance variables(fields) instead of 
 * inheriting it.
 * 
 * Use Composition when a "HAS-A" relationship exists between two classes or between a class and interface.
 * 
 * Example:
 * 	 Inheritance: Car is a vehicle.
 * 	 Composition: Car has an Engine.
 * 
 * Using inheritance we can achieve both polymorphism and code reuse where as composition provides only code reuse.
 */

public class A5_Composition {
	public static void main(String[] args) {
		Car car = new Car();
		car.setName("Rolls Royce");
		car.setType("Four wheeler");
		car.setColor("Metallic Black");
		car.setMaxSpeed(300);
		Engine carEngine = new Engine();
		carEngine.setHorsePower(500);
		carEngine.setCylinders(5);
		car.setEngine(carEngine);
		car.showSpecs();
		car.getEngine().start();
		car.getEngine().stop();
	}
}

class Engine {
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

//Car IS-A Vehicle
class Car extends Vehicle { 
	 // Car HAS-A Engine
	private Engine engine;
	public Car() {

	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void showSpecs() {
		// calls Vehicle's showSpecs().
		super.showSpecs(); 
		engine.showSpecs();
	}
}

class Vehicle {
	protected String type;
	protected String name;
	protected String color;
	protected int maxSpeed;
	public Vehicle() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public void showSpecs() {
		System.out.println("Name: "+name+"\nType: "+type+"\ncolor: "+color+"\nmaxSpeed: "+maxSpeed);
	}
}
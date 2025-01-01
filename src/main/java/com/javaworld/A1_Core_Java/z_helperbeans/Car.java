package com.javaworld.A1_Core_Java.z_helperbeans;

/**
 * @author Shaik khader
 *
 */
public class Car extends Vehicle{  //Car IS-A Vehicle
	
private Engine engine;  ////Car HAS-A Engine


public Car(){
	
}
 
/**
 * @return the engine
 */
public Engine getEngine() {
	return engine;
}

/**
 * @param engine the engine to set
 */
public void setEngine(Engine engine) {
	this.engine = engine;
}

public void showSpecs() {
	super.showSpecs(); // calls Vehicle's showSpecs().
	engine.showSpecs();
}

}

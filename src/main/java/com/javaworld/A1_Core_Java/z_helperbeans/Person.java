package com.javaworld.A1_Core_Java.z_helperbeans;

/**
 * @author Shaik khader
 *
 */
public abstract class Person {
    
    private String name;

    public Person(String name) { 
    	this.name = name;
    }

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract void showPerson();
}
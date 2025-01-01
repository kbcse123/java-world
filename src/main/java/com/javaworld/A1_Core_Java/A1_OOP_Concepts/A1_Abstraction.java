package com.javaworld.A1_Core_Java.A1_OOP_Concepts;

/**
 * - The process of hiding the implementation details and showing only the functionality. 
 * - Is Achieved by using interface and abstract class.
 * - Use abstraction if you know something needs to be in class/interface but implementation of that varies.
 * 
 * ADVANTAGES:
 * - We can separate the things that can be grouped to another type.
 * - Frequently changing properties and methods can be grouped to a separate type so that the main type need not undergo
 *   changes. This adds strength to the OOAD principle.
 */

abstract class Person {
    
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

//Example 1
class EmployeeAbstractionDemo extends Person {
	private String empCode;
	
	public EmployeeAbstractionDemo(String name, String eCode) {
		super(name);
		empCode = eCode;
	}
	
	public String getEmpCode() {
		return empCode;
	}
	
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	
	@Override
	public void showPerson() {
		System.out.println("Name: " + getName() + ", Emp Code: " + empCode);
	}
}

//Example 2
interface TwoWheeler {
	public void runVehicle();
}

class Honda implements TwoWheeler {
	@Override
	public void runVehicle() {
		System.out.println("Running Honda..");
	}
}

class Bajaj implements TwoWheeler {

	@Override
	public void runVehicle() {
		System.out.println("Running Bajaj..");
	}
}

public class A1_Abstraction {

	public static void main(String[] args) {
		// INSTIATING AN ABSTRACT CLASS GIVES COMPILE TIME ERROR
		// Person p = new Person("Khader") ;

		// Example 1 - can access only overridden methods
		System.out.println("Example 1");
		Person person = new EmployeeAbstractionDemo("Shaik", "16945");
		// person.getEmpCode(); //Error
		person.showPerson();

		// Example 2
		System.out.println("\nExample 2");
		TwoWheeler test = new Honda();
		test.runVehicle();
		test = new Bajaj();
		test.runVehicle();
	}
}
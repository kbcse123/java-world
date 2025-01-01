package com.javaworld.A1_Core_Java.A1_OOP_Concepts;

import com.javaworld.A1_Core_Java.z_helperbeans.Animal;

/**
 * The capability of a class to use the (non private) properties and methods of another class while adding its own 
 * functionality. 
 * 
 * Use Inheritance when a "Is-A"relationship(classification) exists between two classes.
 * 
 * A Real time example of where this could be useful is with an employee records system.
 * 
 * .You could create a generic employee(Parent/super/base) class with fields and methods that are common to all employees.
 * 
 * .Then more specific (children/sub/derived) classes could be defined for salaried, commissioned and hourly employees.
 * 
 * .A subclass inherits all instance variables and methods from its super class and also has its own variables and methods,
 *  One can inherit the class using keyword 'extends'.
 * 
 * .The concept of inheritance greatly enhances the ability to reuse code as well as making design a much simpler and
 *  cleaner process.
 * 
 * Note: Don't use inheritance just to get code reuse, If all you really want is to reuse code and if there is no is-a 
 *       relationship in sight then use composition.
 */

class Mammal extends Animal {}

class Reptile extends Animal {
}

class Dog extends Mammal {
}

public class A3_Inheritance {
	public static void main(String[] args) {
		Mammal m = new Mammal();
		Reptile r = new Reptile();
		Dog d = new Dog();
		System.out.println(" Mammal IS-A Animal: " + (m instanceof Animal));
		System.out.println(" Reptile IS-A Animal: " + (r instanceof Animal));
		System.out.println(" Dog IS-A Mammal: " + (d instanceof Mammal));
		System.out.println(" Hence Dog IS-A Animal as well: " + (d instanceof Animal));
	}
}


package com.javaworld.A1_Core_Java.A1_OOP_Concepts;

/**
 * Polymorphism is the ability of an object to take on many forms, That is to treat objects of different types in a 
 * similar manner. 
 * 
 * Generally it can be classified into,
 * 	 Compile time polymorphism (Method Overloading): A class having multiple methods(can be constructors too) by same 
 *   name but different arguments. Method overloading is not possible with changing return type of methods.
 *   
 * 	 Runtime polymorphism (Method Overriding): Subclasses of a class can define their own unique behaviors and yet share
 *   some of the same functionality of the parent class.
 * 
 * JVM calls the appropriate method for the object that is referred to in each variable. It does not call the method that
 * is defined by the variable's type. This behavior is referred to as virtual method invocation
 * 
 * Note: In Java, Operator overloading is only supported for String related operations where the '+' operator performs 
 *       concatenation instead of addition. Eg: System.out.println("total = "+10+12); will display 1012 instead of 22.
 */


class A {
	public void m() {
		System.out.println("Class A.m()");
	}

	//Method overloading is not possible with changing return type of methods
	/** 
	*public String m() {
	*	System.out.println("Class A.m()");
	*	return null; 
	*}	
	*/
	public void a() {
		System.out.println("Class A referring to child Object");
	}

	public void sum(int a, int b, int c) {
		System.out.println("Overloaded Method. Sum(a+b+c) = " + (a + b + c));
	}

	public void display() {
		System.out.println("Class A: display()");
	}
}

class B extends A {
	// overriden method
	@Override
	public void m() {
		System.out.println("Class B.m() overrides Class A.m()");
	}

	// overloaded methods
	public void sum(int a, int b) {
		System.out.println("Overloaded Method. Sum(a+b) = " + (a + b));
	}

	@Override
	public void display() {
		System.out.println("Class B: display()");
	}
}

class C extends A {

	@Override
	public void display() {
		System.out.println("Class C: display()");
	}
}

public class A4_Polymorphism {
	static void main(String[] args) {

		// Method Overloading
		B b = new B();
		b.sum(2, 5);
		b.sum(2, 5, 10);

		//Method Overriding.
		A a = new B();
		a.m();

		display(new A());
		display(new B());
		display(new C());
	}

	// polymorphic method
	public static void display(A a) {
		a.display();
	}
}

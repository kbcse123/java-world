package com.javaworld.A1_Core_Java.A6_Generics;

/**
 * . A generic type is a generic class or interface that is parameterized over types, for better understanding see the 
 *   below 2 classes, NormalBox and GenericBox. 
 * . As you can see, all occurrences of Object are replaced by T, A type variable can be any non-primitive type like any
 *   class type, any interface type, any array type, or even another type variable. This same technique can be applied
 *   to create generic interfaces.
 * 
 * . Type Parameter Naming Conventions: 
 *   By convention, type parameter names are single, uppercase letters. This stands in sharp contrast to the variable
 *   naming conventions that you already know about, and with good reason: Without this convention, it would be difficult
 *   to tell the difference between a type variable and an ordinary class or interface name. 
 *   
 * . The most commonly used type parameter names are:
 *    T - Type 
 *    N - Number 
 *    E - Element (used extensively by the Java Collections Framework) 
 *    K - Key 
 *    V - Value 
 *    S,U etc. - 2nd, 3rd types
 */

class NormalBox {
	private Object object;

	public void set(Object object) {
	 this.object = object;
	}

	public Object get() {
	 return object;
	}
}

/**
 * Generic version of the NormalBox class.
 * T stands for "Type" , <> - angle brackets or diamond or Type Parameter section.
 */
class GenericBox<T> {
	private T val;

	public GenericBox() {

	}

	public GenericBox(T val) {
	 this.val = val;
	}

	public void set(T val) {
	 this.val = val;
	}

	public T get() {
	 return val;
	}
}

public class A2_Generic_Types_Single_Type_Parameter {
	public static void main(String... args) {
		NormalBox nb = new NormalBox();
	  	//No type safety
	  	nb.set(123);
	  	int intVal =(int) nb.get();
	  	System.out.println("NormalBox Integer Value = " + intVal);
	  	nb.set("Hi");
	  	String strVal =(String) nb.get();
	  	System.out.println("NormalBox String Value = " + strVal);
		GenericBox<Integer> integerBox = new GenericBox<Integer>();
		integerBox.set(123);
		// integerBox.set("Shaik"); // invalid
		GenericBox<String> stringBox = new GenericBox<String>("Shaik");
		System.out.println("GenericBox Integer Value = " + integerBox.get());
		System.out.println("GenericBox String Value = " + stringBox.get());
	}
}
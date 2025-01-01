package com.javaworld.A1_Core_Java.A6_Generics;

/**
 * . Generic methods are methods that introduce their own type parameters. 
 * 
 * . This is similar to declaring a generic type, but the type parameter's scope is limited to the method where it is 
 *   declared. 
 *   
 * . Static and non-static generic methods, as well as generic class constructors are allowed.
 * 
 * . The syntax for a generic method includes a type parameter, inside angle brackets, and appears before the method's 
 *   return type, eg. below compare method.
 */

class Util {
	public static <K, V> boolean compare(Pairs<K, V> p1, Pairs<K, V> p2) {
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
	}
}

class Pairs<K, V> {

	private K key;
	private V value;

	public Pairs(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}

public class A5_GenericMethods {
	public static void main(String[] args) {
		Pairs<Integer, String> p1 = new Pairs<>(1, "apple");
		Pairs<Integer, String> p2 = new Pairs<>(1, "apple");
		
		boolean same1 = Util.<Integer, String> compare(p1, p2);
		// Java compiler automatically infers(from the method's arguments) that the type parameter
		boolean same2 = Util.compare(p1, p2);
		System.out.println("Using Type Witness = " + same1);
		System.out.println("Using Type Inference = " + same2);
	}
}
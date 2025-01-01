package com.javaworld.A1_Core_Java.A6_Generics;

/**
 * . A generic class can have multiple type parameters defined with the format: class name<T1, T2, ..., Tn> { }.
 * 
 * . Diamond notation: In Java SE 7 and later, you can replace the type arguments required to invoke the constructor of a 
 *   generic class with an empty set of type arguments (<>). This pair of angle brackets, <>, is informally called the
 *   'diamond' and this ability of Java compiler to conclude the type is called 'Type Inference'. 
 *   For example, you can create an instance of GenericBox<String> with the following statement: 
 *     GenericBox<String> box = new GenericBox<>().
 *     
 * . Parameterized Types: You can also substitute a type parameter (i.e., K or V) with a parameterized type i.e.,
 *    List<String> or GenericBox <Integer>.
 */

class GenericPair<T> {
	private T val;

	public GenericPair() {

	}

	public GenericPair(T val) {
	 this.val = val;
	}

	public void set(T val) {
	 this.val = val;
	}

	public T get() {
	 return val;
	}
}

interface Pair<K, V> {
	public K getKey();

	public V getValue();
}

class OrderedPair<K, V> implements Pair<K, V> {

	private K key;
	private V value;

	public OrderedPair(K key, V value) {
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

public class A3_Generic_Types_Multiple_Type_Parameters {
	public static void main(String[] args) {
		Pair<String, Integer> p1 = new OrderedPair<>("Even", 8);
		Pair<String, String> p2 = new OrderedPair<>("Shaik", "Khader");
		// Parameterized Types
		OrderedPair<String, GenericPair<Integer>> p3 = new OrderedPair<>("prime",new GenericPair<Integer>(3));
		System.out.println("p1 ---> key = " + p1.getKey() + ", Value = " + p1.getValue());
		System.out.println("p2 ---> key = " + p2.getKey() + ", Value = " + p2.getValue());
		System.out.println("Parameterized Types - p3 ---> key = "+p3.getKey() + ", Value = "+p3.getValue().get());
	}
}
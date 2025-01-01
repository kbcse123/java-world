package com.javaworld.A5_Design_Patterns.A1_Creational_Design_Patterns;
/**
 * 
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * 
 * Singleton pattern restricts the instantiation of a class and ensures that
 * only one instance of the class exists in the JVM. It seems to be a very
 * simple design pattern but when it comes to implementation, it comes with a
 * lot of implementation concerns. It is used for logging, drivers objects,
 * caching and thread pool. It is also used in other design patterns like
 * Abstract Factory, Builder, Prototype, Facade etc.
 * 
 * 
 * To implement Singleton pattern, we have different approaches but all of them
 * have following common concepts.
 * .Private constructor to restrict instantiation of the class from other classes.
 * .Private static variable of the same class that is the only instance of the class.
 * .Public static method that returns the instance of the class, this is the global access point for
 * outer world to get the instance of the singleton class.
 * 
 * Different approaches of Singleton pattern implementation and design concerns
 * with the implementation.
 * 
 * .Eager initialization - initialization is done at declaration time itself.
 * 
 * .Static block initialization - initialization is done in static block.
 * 
 * .Lazy Initialization - initialization is done based on null condition check.
 * 
 * .Thread Safe Singleton - initialization is done inside a Synchronized block.
 * 
 * .Bill Pugh Singleton Implementation - initialization is done inside a private
 * static nested class.
 * 
 * .Enum Singleton - Using Enum.
 * 
 * .Using Reflection to destroy Singleton
 *
 * .Serialization and Singleton
 * 
 * Examples in JDK: It is used in core java API classes like, java.lang.Runtime,
 * java.awt.Desktop.
 * 
 * @author Shaik Khader
 * 
 */

class BillPughSingleton implements Serializable {

	private static final long serialVersionUID = 1L;

	private BillPughSingleton() {
		// to overcome Reflection problem.
		if (instance() != null) {
			throw new UnsupportedOperationException("Cannot create a new object for Singleton class");
		}
	}

	// to overcome synchronization problem
	private static class SingletonHelper {
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}

	// to overcome serialization problem
	protected Object readResolve() {
		return instance();
	}

	public static BillPughSingleton instance() {
		return SingletonHelper.INSTANCE;
	}
}

public class _1_Singleton_Pattern {
	public static void main(String... args) {
		System.out.println("Bill Pugh Singleton Pattern...");
		BillPughSingleton object1 = BillPughSingleton.instance();
		BillPughSingleton object2 = BillPughSingleton.instance();

		System.out.println("Both objects are same = " + (object1 == object2));
		System.out.println("object1.hashCode() = " + object1.hashCode());
		System.out.println("object2.hashCode() = " + object2.hashCode());
		try {
			testSingletonUsingReflection();
			testSingletonUsingSerialization();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	private static void testSingletonUsingReflection() {
		System.out.println("Testing Bill Pugh Singleton Pattern using Reflection ...");
		BillPughSingleton instanceOne = BillPughSingleton.instance();
		BillPughSingleton instanceTwo = null;
		try {
			Constructor[] constructors = BillPughSingleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				Object obj = constructor.newInstance();
				if (obj != null)
					instanceTwo = (BillPughSingleton) obj;
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("instanceOne.hashCode()" + instanceOne.hashCode());
		if (instanceTwo != null)
			System.out.println("instanceTwo.hashCode()" + instanceTwo.hashCode());
	}

	public static void testSingletonUsingSerialization()
			throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("Testing Bill Pugh Singleton Pattern using Serialization ...");
		String fileName = "src\\main\\java\\z_resources\\sample.txt";

		BillPughSingleton instanceOne = BillPughSingleton.instance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream(fileName));
		out.writeObject(instanceOne);
		out.close();

		// deserailize from file to object
		ObjectInput in = new ObjectInputStream(new FileInputStream(fileName));
		BillPughSingleton instanceTwo = (BillPughSingleton) in.readObject();
		in.close();

		System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
		System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());

	}
}

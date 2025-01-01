package com.javaworld.A1_Core_Java.A4_Interfaces_And_Inheritance;

/**
 * @author Shaik Khader
 
 Inheritance:
 	
 	. A class that is derived from another class is called a subclass (also a derived class, extended class, or child class). The class from which the subclass is derived is
 	  called a superclass (also a base class or a parent class).

	. Except Object, which has no superclass, every class has one and only one direct superclass (single inheritance). In the absence of any other explicit superclass, every
	  class is implicitly a subclass of Object.

	. Classes can be derived from classes that are derived from classes that are derived from classes, and so on, and ultimately derived from the topmost class, Object. Such
	  a class is said to be descended from all the classes in the inheritance chain stretching back to Object.
 
 	. The idea of inheritance is simple but powerful: When you want to create a new class and there is already a class that includes some of the code that you want, you can
 	  derive your new class from the existing class. In doing this, you can reuse the fields and methods of the existing class without having to write (and debug!) them 
 	  yourself.

	. A subclass inherits all the members (fields, methods, and nested classes) from its superclass. Constructors are not members, so they are not inherited by subclasses, 
	  but the constructor of the superclass can be invoked from the subclass.
 
 	. The Object class, defined in the java.lang package, defines and implements behavior common to all classes,including the ones that you write. In the Java platform, many
 	  classes derive directly from Object, other classes derive from some of those classes, and so on, forming a hierarchy of classes.

 What You Can Do in a Subclass:

	. A subclass inherits all of the public and protected members of its parent, no matter what package the subclass is in. If the subclass is in the same package as its 
	  parent, it also inherits the package-private members of the parent. You can use the inherited members as is, replace them, hide them, or supplement them with new 
	  members:
	
		- The inherited fields can be used directly, just like any other fields.
		- You can declare a field in the subclass with the same name as the one in the superclass, thus hiding it (not recommended).
		- You can declare new fields in the subclass that are not in the superclass.
		- The inherited methods can be used directly as they are.
		- You can write a new instance method in the subclass that has the same signature as the one in the superclass, thus overriding it.
		- You can write a new static method in the subclass that has the same signature as the one in the superclass, thus hiding it.
		- You can declare new methods in the subclass that are not in the superclass.
		- You can write a subclass constructor that invokes the constructor of the superclass, either implicitly or by using the keyword super.
		 
 Private Members in a Superclass:

	. A subclass does not inherit the private members of its parent class. However, if the superclass has public or protected methods for accessing its private fields, these
	  can also be used by the subclass.
	
	. A nested class has access to all the private members of its enclosing class,both fields and methods. Therefore, a public or protected nested class inherited by a 
	  subclass has indirect access to all of the private members of the superclass.

 Casting Objects:

	. We have seen that an object is of the data type of the class from which it was instantiated. For example, 
	  		if we write:  MountainBike myBike = new MountainBike();  then myBike is of type MountainBike. 
	  		if we write:  Object obj = new MountainBike();  then obj is both an Object and a MountainBike. This is called 'implicit casting'.
	 		If we write:  MountainBike myBike = obj;  we would get a compile-time error because obj is not known to the compiler to be a MountainBike. However, we can tell 
	 					  the compiler that we promise to assign a MountainBike to obj. MountainBike myBike = (MountainBike)obj;  This is called 'explicit casting'.
 						  This cast inserts a runtime check that obj is assigned a MountainBike so that the compiler can safely assume that obj is a MountainBike.
 
 
 	. We can make use of 'instanceof' operator to get rid of improper casting. 
	 			
	 			if (obj instanceof MountainBike) {
						    MountainBike myBike = (MountainBike)obj;
				}
 	  Here the instanceof operator verifies that obj refers to a MountainBike so that we can make the cast with knowledge that there will be no runtime exception thrown.
 
 
 
 
 
 
 
 
 */ 



//Subclass


public class B1_Inheritance {
	public static void main(String... args) {

	}

}

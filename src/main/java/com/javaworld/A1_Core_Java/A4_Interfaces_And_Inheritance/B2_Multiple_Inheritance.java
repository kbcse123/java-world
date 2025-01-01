package com.javaworld.A1_Core_Java.A4_Interfaces_And_Inheritance;

/**
 * @author Shaik Khader
 
 Multiple Inheritance of State:
 	. One significant difference between classes and interfaces is that classes can have fields whereas interfaces cannot.
 	  In addition, you can instantiate a class to create an object, which you cannot do with interfaces.
 	  
 	. One reason why the Java programming language does not permit you to extend more than one class is to avoid the
      issues of multiple inheritance of state, which is the ability to inherit fields from multiple classes. For example,
      suppose that you are able to define a new class that extends multiple classes. When you create an object
 	  by instantiating that class, that object will inherit fields from all of the class's super classes. What if methods
      or constructors from different super classes instantiate the same field? Which method or constructor will take
      precedence? Because interfaces do not contain fields, you do not have to worry about problems that result from
 	  multiple inheritance of state.

 Multiple inheritance of implementation:
  	. This is the ability to inherit method definitions from multiple classes. Problems arise with this type of multiple
      inheritance, such as name conflicts and ambiguity. When compilers of programming languages that support this type
      of multiple inheritance encounter super classes that contain methods with the same name, they sometimes cannot
  	  determine which member or method to access or invoke.
  	  
  	. In addition, a programmer can unwittingly introduce a name conflict by adding a new method to a superclass.
      Default methods introduce one form of multiple inheritance of implementation. A class can implement more than one
      interface, which can contain default methods that have the same name. In this case, the compiler or the user must
  	  decide which one to use.
  	  
 Multiple inheritance of type:
 	. The Java programming language supports multiple inheritance of type, which is the ability of a class to implement
      more than one interface. An object can have multiple types: the type of its own class and the types of all the
      interfaces that the class implements. This means that if a variable is declared to be the type of interface,
 	  then its value can reference any object that is instantiated from any class that implements the interface.
 */


public class B2_Multiple_Inheritance {
	public static void main(String... args) {

	}

}

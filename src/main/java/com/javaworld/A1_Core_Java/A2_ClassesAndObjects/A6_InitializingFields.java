package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;

/**
 * . You can often provide an initial value for a field in its declaration itself.
 * . This works well when the initialization value is available and the initialization can be put on one line. However,
 *   this form of initialization has limitations because of its simplicity. 
 * . If initialization requires some logic (for example, error handling or a for loop to fill a complex array), simple
 *   assignment is inadequate. Instance variables can be initialized in constructors, where error handling or other logic
 *   can be used. 
 * . To provide the same capability for class variables, the Java programming language includes static initialization 
 *   blocks.
 * 
 * Static Initialization Blocks:
 * 
 * . A static initialization block is a normal block of code enclosed in braces { }, and preceded by the static keyword.
 * . A class can have any number of static initialization blocks, and they can appear anywhere in the class body. 
 * . The runtime system guarantees that static initialization blocks are called in the order that they appear in the 
 *   source code.
 * . There is an alternative to static blocks , you can write a private static method:
 * . The advantage of private static methods is that they can be reused later if you need to reinitialize the class 
 *   variable.
 * 
 * Initializing Instance variables:
 * 
 * . Normally, you would put code to initialize an instance variable in a constructor. 
 * . There are two alternatives to using a constructor to initialize instance variables: initializer blocks and final 
 *   methods.
 *   - Initializer blocks for instance variables look just like static initializer blocks, but without the static keyword 
 *     The Java compiler copies initializer blocks into every constructor. Therefore, this approach can be used to share 
 *     a block of code between multiple constructors.
 *   - A final method cannot be overridden in a subclass. This is discussed in the lesson on interfaces and inheritance. 
 *     This is especially useful if subclasses might want to reuse the initialization method. The method is final because
 * 	   calling non-final methods during instance initialization can cause problems.
 */

public class A6_InitializingFields {
	// initialization while declaration itself
	public static int capacity = 10;
	
	public static String usingStaticBlock;

	// Static Initialization Block
	static
	{
		usingStaticBlock = "Initialized Using Static Block";
	}

	// Static Initialization Method
	public static String usingStaticMethod = initializeUsingStaticMethod();

	private static String initializeUsingStaticMethod() {
		return "Initialized Using Static Method";
	}
	
	private String insVar1;

	//Initializing Instance variable using initializer block
	{
		insVar1 = "Initialized Using initializer block";
	}
	
	//Initializing Instance variable using final method
	private String insVar2 = initializeInstanceVariable();
	protected final String initializeInstanceVariable() {
		return "Initialized Using final Method";
	}

	
	public A6_InitializingFields(){
		System.out.println("In Constructor. insVar1 = "+insVar1+", insVar2 = "+insVar2);
	}
	
	public static void main(String[] args) {
		System.out.println(usingStaticBlock);
		System.out.println(usingStaticMethod);
	}
}

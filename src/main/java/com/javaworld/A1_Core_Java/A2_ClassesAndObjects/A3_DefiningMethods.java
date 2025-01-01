package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;

/**
 * The required elements of a method declaration are the method's return type, name, a pair of parentheses, (), and a body 
 * between braces, {}.
 * 
 * More generally, method declarations have six components, in order: 
 * . Modifiers - such as public, private, and others you will learn about later. 
 * . The return type - the data type of the value returned by the method, or void if the method does not return a value. 
 * . The method name - the rules for field names apply to method names as well, but the convention is a little different. 
 * . The parameter list in parenthesis - a comma-delimited list of input parameters, preceded by their data types. 
 * . An exception list - list of exceptions the method will throw. 
 * . The method body - enclosed between braces the method's code, including the declaration of local variables, goes here.
 * 
 * Naming a Method:
 *  Although a method name can be any legal identifier(cannot be a reserved keyword), code conventions restrict method 
 *  names. By convention, method names should be a verb in lowercase or a multi-word name that begins with a verb in  
 *  lowercase, followed by adjectives,nouns, etc. In multi-word names, the first letter of each of the second and 
 *  following words should be capitalized. Below are some examples: 
 *     run(), runFast(), getBackground(), getFinalData(), compareTo(), setX(), isEmpty().
 * 
 * Overloading Methods:
 *  The Java programming language supports overloading methods, and Java can distinguish between methods with different 
 *  method signatures. This means that methods within a class can have the same name if they have different parameter  
 *  lists. Overloaded methods are differentiated by the number and the type of the arguments passed into the method.
 *  You cannot declare more than one method with the same name and the same number and type of arguments, because the 
 *  compiler cannot tell them apart. The compiler does not consider return type when differentiating methods, so you 
 *  cannot declare two methods with the same signature even if they have a different return type.
 */

public class A3_DefiningMethods {
	// overloaded methods
	public int addValues(int a, int b) {
		// local variable
		int returnval = a + b; 
		return returnval;
	}

	public int addValues(int a, int b, int c) {
		return (a + b + c);
	}

	/*
	 * this will not run even though its return type is different. 
	 * public double addValues(int a,int b,int c){
	 * 		return (a+b+c); 
	 * }
	 */
}
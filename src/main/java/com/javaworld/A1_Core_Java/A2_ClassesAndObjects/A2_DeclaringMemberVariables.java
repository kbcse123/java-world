package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;

/**
 * There are several kinds of variables: 
 *  . Member variables in a class - these are called fields. 
 *  . Variables in a method or block of code - these are called local variables. 
 *  . Variables in method declarations - these are called parameters.
 * 
 * Field declarations are composed of three components, in order: 
 *  . Zero or more access modifiers, such as public or private. 
 *  . The field's type. 
 *  . The field's name. 
 *  
 *  eg: private String val;
 *  
 * In the spirit of encapsulation, it is common to make fields private. This means that they can only be directly accessed
 * by their class. By adding public methods(getters and setters) we can provide access to the field values from other 
 * classes, Also we can write additional rules like validation in the setters before setting the values.
 * 
 * Controlling Access to Members of a Class: 
 *  . Access level modifiers determine whether other classes can use a particular field or invoke a particular method.
 * 
 *  The following table shows the access to members permitted by each modifier.
 *		---------------------------------------------------------
 *		Modifier		Class	Package	 Subclass  World
 *		---------------------------------------------------------
 *		public			  Y	   Y	    Y	      Y
 *		protected		  Y	   Y	    Y         N
 *		no modifier		  Y	   Y	    N         N
 *		private			  Y	   N	    N         N 
 */

public class A2_DeclaringMemberVariables {
	//any class can access
	public String field1; 
	
	//only current class can access
	private String field2; 
	
	//any class in the same package can access
	String field3; 
	
	//any class in the same package or any child class can access
	protected String field4; 
	
}

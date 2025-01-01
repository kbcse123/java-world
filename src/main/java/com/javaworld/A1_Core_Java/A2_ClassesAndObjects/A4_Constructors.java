package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;


/**
 * A class contains constructors, that are invoked to create objects from the class blueprint.
 *  . Constructor declarations look like method declarations, except that they use the name of the class and have no
 *    return type. 
 *  . As with methods, the Java platform differentiates constructors on the basis of the number of arguments in the list
 *    and their types. 
 *  . You cannot write two constructors that have the same number and type of arguments for the same class. 
 *  . The compiler automatically provides a no-argument, default constructor for any class without constructors.
 *    This default constructor will call the no-argument constructor of the superclass. In this situation, the
 *    compiler will complain if the superclass doesn't have a no-argument constructor so you must verify that it does. 
 *    If your class has no explicit superclass, then it has an implicit superclass of 'Object', which does have a 
 *    no-argument constructor. 
 *  . You can use access modifiers in a constructor's declaration to control which other classes can call the constructor.
 * 
 * Passing Information to a Method or a Constructor: 
 *  . The declaration for a method or a constructor declares the number and the type of the arguments for that method or
 *    constructor. 
 *  . 'Parameters' refers to the list of variables in a method declaration, 'Arguments' are the actual values that are 
 *    passed in when the method is invoked. When you invoke a method, the arguments used must match the declaration's
 *    parameters in type and order.
 * 
 * Parameter Types: 
 *  . You can use any data type for a parameter of a method or a constructor. This includes primitive data types, such as
 *    doubles, floats, and integers and reference data types, such as objects and arrays. 
 *  . If you want to pass a method into a method, then use a 'lambda expression' or a 'method reference'.
 * 
 * Arbitrary Number of Arguments: 
 *  . You can use a construct called 'varargs' to pass an arbitrary number of values to a method. 
 *  . You use varargs when you don't know how many of a particular type of argument will be passed to the method, 
 *    It's a shortcut to creating an array manually. 
 *  . To use varargs, you follow the type of the last parameter by an ellipsis (three dots, ...), then a space, and the
 *    parameter name. eg. public method(String... values){} 
 *  . The method can then be called with any number of that parameter, including none.
 * 
 * Parameter Names: 
 *  . The name of a parameter must be unique in its scope and cannot be the same as the name of another parameter for
 *    the same method or constructor, and it cannot be the name of a local variable within the method or constructor. 
 *  . A parameter can have the same name as one of the class's fields. In this case, the parameter is said to shadow 
 *    the field. 
 *  . Shadowing fields can make your code difficult to read and is conventionally used only within constructors and 
 *    methods that set a particular field.
 * 
 * Passing Primitive Data Type Arguments: 
 *  . Primitive arguments, such as an int or a double, are passed into methods by value. This means that any changes to 
 *    the values of the parameters exist only within the scope of the method. When the method returns, the parameters
 *    are gone and any changes to them are lost.
 * 
 * Passing Reference Data Type Arguments: 
 *  . Reference data type parameters, such as objects, are also passed into methods by value. This means that when the 
 *    method returns, the passed-in reference still references the same object as before. However, the values of the 
 *    object's fields can be changed in the method, if they have the proper access level.
 * 
 * The Garbage Collector: 
 *  . Some object-oriented languages(like C++) require that you keep track of all the objects you create and you
 *    explicitly destroy them when they are no longer needed. Managing memory explicitly is tedious and error-prone.
 *  . The Java platform allows you to create as many objects as you want (limited, of course, by what your system can 
 *    handle), and you don't have to worry about destroying them. 
 *  . The Java runtime environment deletes objects when it determines that they are no longer being used. This process is
 *    called garbage collection. 
 *  . An object is eligible for garbage collection when there are no more references to that object. References that are
 *    held in a variable are usually dropped when the variable goes out of scope. Or, you can explicitly drop an object 
 *    reference by setting the variable to the special value null. 
 *  . Remember that a program can have multiple references to the same object; all references to an object must be dropped 
 *    before the object is eligible for garbage collection. 
 *  . The Java runtime environment has a garbage collector that periodically frees the memory used by objects that are no
 *    longer referenced. The garbage collector does its job automatically when it determines that the time is right.
 */

class ConstructorsParent {
	protected String one;
	protected String two;

	// comment this constructor and see the magic
	ConstructorsParent() {
	}

	ConstructorsParent(String o) {
		one = o;
	}

	ConstructorsParent(String o, String t) {
		this(o);
		two = t;
	}

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two;
	}
}

class ConstructorsDemo extends ConstructorsParent {
	private String three;
	private String four;

	public String getThree() {
		return three;
	}

	public void setThree(String three) {
		this.three = three;
	}

	public String getFour() {
		return four;
	}

	public void setFour(String four) {
		this.four = four;
	}

	public ConstructorsDemo(String one) {
		super(one);
	}

	public ConstructorsDemo(String one, String two) {
		super(one, two);
	}

	// 'this' is a reference to the current object i.e. 'ConstructorsDemo'
	public ConstructorsDemo(String one, String two, String three) {
		this(one, two);
		this.three = three;
	}

	// Arbitrary Number of Arguments
	public ConstructorsDemo(String... values) {
		this(values[0], values[1]);
		this.three = values[2];
		this.four = values[3];
	}

	@Override
	public String toString() {
		return String.format("one = " + one + ",  two = " + two 
				+ ",  three = " + three + ",  four = " + four);
	}
}

//Main class
public class A4_Constructors { 
	// This method is called by JVM.
	public static void main(String[] args) {
		// Since this class is not having any constructors, compiler
		// automatically provides a no-argument, default constructor for it.
		A4_Constructors defaultConstructor = new A4_Constructors();

		main();

		// Passing Primitive Data Type Arguments
		int x = 3;
		System.out.println("\n Before invoking passPrimitiveData, x = " + x);
		passPrimitiveData(x);
		System.out.println("\n After invoking passPrimitiveData, x = " + x);

		// Passing Reference Data Type Arguments
		ConstructorsDemo constructorsDemo = new ConstructorsDemo("Hi", "Shaik", "Khader", "Basha");
		System.out.println("\n Before invoking passReferenceData, constructorsDemo : " + constructorsDemo);
		passReferenceData(constructorsDemo);
		System.out.println("\n After invoking passReferenceData, constructorsDemo : " + constructorsDemo);

	}
	
	public static void passPrimitiveData(int p) {
		// modifying the value will not reflect any change
		p = 10;
	}

	public static void passReferenceData(ConstructorsDemo constructorsDemo) {
		// this will reflect
		constructorsDemo.setOne("Bye");

		// This will not reflect since Java is pass by value.
		constructorsDemo = new ConstructorsDemo("New", "World");
	}

	// it's like any other method.
	public static void main() {
		// this will call the arbitrary Args Constructor since there is no
		// default constructor defined, resulting in NullPointerException.
		/*
		 * ConstructorsDemo emptyConstructor = new ConstructorsDemo();
		 * System.out.println(" emptyConstructor: "+emptyConstructor);
		 */
		ConstructorsDemo oneArgConstructor = new ConstructorsDemo("Shaik");
		System.out.println("\n oneArgConstructor: " + oneArgConstructor);

		ConstructorsDemo twoArgsConstructor = new ConstructorsDemo("Shaik", "Khader");
		System.out.println("\n twoArgsConstructor: " + twoArgsConstructor);

		ConstructorsDemo threeArgsConstructor = new ConstructorsDemo("Shaik", "Khader", "Basha");
		System.out.println("\n threeArgsConstructor: " + threeArgsConstructor);
		ConstructorsDemo arbitraryArgsConstructor = new ConstructorsDemo("Shaik", "Khader", "Basha", "Bhai");
		System.out.println("\n arbitraryArgsConstructor: " + arbitraryArgsConstructor);
	}
}

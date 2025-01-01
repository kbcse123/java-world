package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;

/**
 * 1.From below class declaration, The class body (the area between the braces) contains all the code that provides
 *  for the life cycle of the objects created from the class: 
 * 	 a)constructors for initializing new objects, 
 * 	 b)declarations for the fields that provide the state of the class, and
 * 	 c)methods to implement the behavior of the class.
 * 
 * 2.The "DeclaringClasses" class is a simple one. It contains only those components of a class declaration that
 *  are required. You can provide more information about the class, such as the name of its superclass, whether it
 *  implements any interfaces, and so on, at the start of the class declaration.
 * 
 * For example, class MyClass extends MySuperClass implements MyInterface{ } This means that MyClass is a subclass
 *  of MySuperClass and it implements the MyInterface interface.
 * 
 * In general, class declarations can include these components, in order:
 * 
 *  .Modifiers such as private,protected,public and a number of others that you will encounter later.
 * 
 *  .The class name, with the initial letter capitalized by convention.
 * 
 *  .The name of the class's parent (superclass), if any, preceded by the keyword 'extends'. A class can only extend
 *   (subclass) one parent.
 * 
 *  .A comma-separated list of interfaces implemented by the class, if any, preceded by the keyword 'implements'. 
 *   A class can implement more than one interface.
 * 
 *  .The class body, surrounded by braces, {}.
 */

public class A1_DeclaringClasses {
	public static void main(String[] args) {
		MyClass myClass = new MyClass("Hello");
		myClass.sayHello();
		myClass.sayHello(" World!");
	}

}

interface MyInterface {
	public void sayHello();
}

class MySuperClass {
	public MySuperClass() {

	}
	public static void main(String[] args) {

	}
}

class MyClass extends MySuperClass implements MyInterface {
	// field(s)
	String wish;
	// constructor(s)
	public MyClass(String wish) {
		this.wish = wish;
	}
	// overridden method of MyInterface.
	@Override
	public void sayHello() {
		System.out.print(wish);
	}
	// overloaded method declarations
	public void sayHello(String arg) {
		System.out.print(arg);
	}
}



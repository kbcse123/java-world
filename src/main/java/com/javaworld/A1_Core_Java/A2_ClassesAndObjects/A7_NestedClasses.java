package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;

/**
 * . The Java programming language allows you to define a class within another class. Such a class is called a nested 
 *   class and is a member of its enclosing class.
 * . Nested classes are divided into two categories: static and non-static.
 *      - Nested classes that are declared static are called static nested classes.
 *      - Non-static nested classes are called inner classes.
 * . Non-static nested classes (inner classes) have access to other members of the enclosing class, even if they are 
 *   declared private. Static nested classes do not have access to other members of the enclosing class. As a member of
 *   the OuterClass, a nested class can be declared private, public, protected, or package private.
 * 
 * Why Use Nested Classes?
 * 
 * . It is a way of logically grouping classes that are only used in one place: If a class is useful to only one other
 *   class, then it is logical to embed it in that class and keep the two together. Nesting such "helper classes" makes
 *   their package more streamlined.
 * . It increases encapsulation: Consider two top-level classes, A and B, where B needs access to members of A that would
 *   otherwise be declared private. By hiding class B within class A, A's members can be declared private and B can
 *   access them. In addition, B itself can be hidden from the outside world.
 * . It can lead to more readable and maintainable code: Nesting small classes within top-level classes places the code 
 *   closer to where it is used.
 * 
 * Static Nested Classes:
 * 
 * . As with class methods and variables, a static nested class is associated with its outer class. And like static class
 *   methods, a static nested class cannot refer directly to instance variables or methods defined in its enclosing
 *   class: it can use them only through an object reference.
 * . In effect, a static nested class is behaviorally a top-level class that has been nested in another top-level class
 *   for packaging convenience.
 * . Static nested classes are accessed using the enclosing class name: OuterClass.StaticNestedClass For example, to 
 *   create an object for the static nested class, use the below syntax: 
 *   OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
 * 
 * Inner Classes:
 * 
 * . As with instance methods and variables, an inner class is associated with an instance of its enclosing class and 
 *   has direct access to that object's methods and fields.
 * . Also, because an inner class is associated with an instance, it cannot define any static members itself.
 * . Objects that are instances of an inner class exist within an instance of the outer class
 * . To instantiate an inner class, you must first instantiate the outer class. Then, create the inner object within
 *   the outer object with this syntax:
 *   	OuterClass outerObject = new OuterClass(); 
 *   	OuterClass.InnerClass innerObject = outerObject.new InnerClass(); 
 * . There are two special kinds of inner classes: local classes and anonymous classes, which are explained in further
 *   sections.
 * 
 * Shadowing:
 * 
 * . If a declaration of a type (such as a member variable or a parameter name) in a particular scope (such as an inner
 *   class or a method definition) has the same name as another declaration in the enclosing scope, then the declaration
 *   shadows the declaration of the enclosing scope. You cannot refer to a shadowed declaration by its name alone, use
 *   the keyword 'this'.
 * 
 * Serialization:
 * 
 * . Serialization of inner classes, including local and anonymous classes, is strongly discouraged. When the Java 
 *   compiler compiles certain constructs, such as inner classes, it creates synthetic constructs; these are classes,
 *   methods, fields, and other constructs that do not have a corresponding construct in the source code.
 * . Synthetic constructs enable Java compilers to implement new Java language features without changes to the JVM. 
 *   However, synthetic constructs can vary among different Java compiler implementations, which means that .class files
 *   can vary among different implementations as well. Consequently, you may have compatibility issues if you serialize
 *   an inner class and then deserialize it with a different JRE implementation.
 */

class OuterClass {
	private String value="OuterClass value";
	private String value2="OuterClass value2";
	
	static class StaticNestedClass {
		private static String value="StaticNestedClass value";
	}

	class InnerClass {
		private String value="InnerClass value";
		public void shadowTest(){
		  System.out.println("inside InnerClass shadowTest()");
			System.out.println(value);
			System.out.println(value2);
			System.out.println(StaticNestedClass.value);
			System.out.println(OuterClass.this.value);
	  }
	}
	
	public void shadowTest(){
			System.out.println("inside OuterClass shadowTest()");
			System.out.println(value);
			System.out.println(value2);
			System.out.println(StaticNestedClass.value);
			//cannot access inner class variables directly or using 'this' reference.
			System.out.println(new InnerClass().value);
	}
}

public class A7_NestedClasses {
	public static void main(String... args) {
		OuterClass oc = new OuterClass();
		oc.shadowTest();
		OuterClass.InnerClass ic = oc.new InnerClass();
		ic.shadowTest();
	}
}
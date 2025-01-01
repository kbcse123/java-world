package com.javaworld.A1_Core_Java.A3_Annotations;

/**
 * @author Shaik Khader
 * 
 * .Annotations are a form of metadata that provides data about a program that is not part of the program itself.
 *  Annotations have no direct effect on the operation of the code they annotate.
 * 
 * .Annotations have a number of uses, among them:
 * 
 * - Information for the compiler : Annotations can be used by the compiler to detect errors or suppress warnings.
 * 
 * - Compile time and deployment time processing : Software tools can process annotation information to generate code,
 *   XML files, and so forth. 
 * 
 * - Runtime processing : Some annotations are available to be examined at runtime.
 * 
 * The Format of an Annotation:
 * 
 * . In its simplest form, an annotation looks like the following:
 * 
 * 			 @Entity The at sign character (@) indicates to the compiler that what follows is an annotation. In the 
 * 			 following example, the annotation's name is
 * 
 * 		Override: @Override void mySuperMethod() { ... }
 * 
 *   The annotation can include elements, which can be named or unnamed, and there are values for those elements: 
 *   @Author( name = "Benjamin Franklin", date = "3/27/2003" ) class MyClass() { ... }
 * 
 *   If there is just one element named value, then the name can be omitted, as in:
 * 			 @SuppressWarnings(value = "unchecked") void myMethod() { ... } can be written as
 *           @SuppressWarnings("unchecked") void myMethod() { ... }
 * 
 *   If the annotation has no elements, then the parentheses can be omitted, as shown in the previous @Override example.
 * 
 *   It is also possible to use multiple annotations on the same declaration:
 * 			 @Author(name = "Jane Doe")
 * 			 @EBook class MyClass { ... }
 * 
 *   If the annotations have the same type, then this is called a repeating annotation:
 * 			 @Author(name = "Jane Doe")
 * 			 @Author(name = "John Smith") 
 * 			 class MyClass { ... } 
 * 
 * 			 Repeating annotations are supported as of the Java SE 8 release. For more information, see RepeatingAnnotations.
 * 
 * . The annotation type can be one of the types that are defined in the java.lang or java.lang.annotation packages
 *   of the Java SE API. In the previous examples, Override and SuppressWarnings are predefined Java annotations. 
 *   It is also possible to define your own annotation type. The Author and Ebook annotations in the previous
 *   example are custom annotation types.
 * 
 * Where Annotations Can Be Used:
 * 
 * . Annotations can be applied to declarations: declarations of classes, fields, methods, and other program elements.
 *   When used on a declaration, each annotation often appears, by convention, on its own line.
 * 
 * . As of the Java SE 8 release, annotations can also be applied to the use of types, This means that annotations
 *  can be used anywhere you use a type. This form of annotation is called a 'type annotation'. Type annotations were
 *  created to support improved analysis of Java programs way of ensuring stronger type checking. The Java SE 8 
 *  release does not provide a type checking framework, but it allows you to write (or download) a type checking 
 *  framework that is implemented as one or more pluggable modules that are used in conjunction with the Java compiler.
 *  You can use multiple type-checking modules where each module checks for a different kind of error. In this way,
 *  you can build on top of the Java type system, adding specific checks when and where you want them.
 * 
 *  Here are some examples:
 * 
 *      - Class instance creation expression:     new @Interned MyObject();
 *      - The variable declaration:		@NonNull String str;
 *  	- Type cast:	 myString = (@NonNull String) str;
 *  	- implements clause:	 class UnmodifiableList<T> implements @Readonly List<@Readonly T> { ... }
 *   	- Thrown exception declaration:		void monitorTemperature() throws @Critical TemperatureException { ... }
 * 
 * . With the judicious use of type annotations and the presence of pluggable type checkers, you can write code that
 *   is stronger and less prone to error.
 * 
 * . In many cases, you do not have to write your own type checking modules. There are third parties who have done
 *   the work for you. For example, you might want to take advantage of the Checker Framework created by the 
 *   University of Washington. This framework includes a NonNull module, as well as a regular expression module,
 *   and a mutex lock module.
 * 
 */

	public class _1_Annotations_Basics {
		public static void main(String... args) {

		}

	}

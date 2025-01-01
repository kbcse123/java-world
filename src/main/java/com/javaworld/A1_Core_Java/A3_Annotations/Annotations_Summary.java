package com.javaworld.A1_Core_Java.A3_Annotations;

/**
 * Annotations:
 *  . Annotations are a form of metadata that provides data about a program that is not part of the program itself.
 *    Annotations have no direct effect on the operation of the code they annotate.
 *  . Annotations have a number of uses, among them:
 *    - Information for the compiler : Annotations can be used by the compiler to detect errors or suppress warnings.
 *    - Compile time and deployment time processing : Software tools can process annotation information to generate code,
 *      XML files, and so forth.
 *    - Runtime processing : Some annotations are available to be examined at runtime.
 *  . As of the Java SE 8 release, annotations can also be applied to the use of types, This means that annotations
 *    can be used anywhere you use a type. This form of annotation is called a 'type annotation'. Type annotations were
 *    created to support improved analysis of Java programs way of ensuring stronger type checking.
 *  . Here are some examples:
 *      - Class instance creation expression:     new @Interned MyObject();
 *      - The variable declaration:		@NonNull String str;
 *  	- Type cast:	 myString = (@NonNull String) str;
 *  	- implements clause:	 class UnmodifiableList<T> implements @Readonly List<@Readonly T> { ... }
 *   	- Thrown exception declaration:		void monitorTemperature() throws @Critical TemperatureException { ... }
 *  . With the judicious use of type annotations and the presence of pluggable type checkers, you can write code that
 *    is stronger and less prone to error.
 *  . Annotations that apply to other annotations are called meta-annotations. There are several meta-annotation types
 *     defined in java.lang.annotation.
 * 		- @Retention annotation specifies how the marked annotation is stored:
 * 			. RetentionPolicy.SOURCE: Won't appear in the decompiled class.
 * 			. RetentionPolicy.CLASS: Appear in the decompiled class, but can't be inspected at run-time with reflection
 * 			   with getAnnotations().
 * 			. RetentionPolicy.RUNTIME: Appear in the decompiled class, and can be inspected at run-time with reflection
 * 			   with getAnnotations().
 * 		- @Documented annotation indicates that whenever the specified annotation is used those elements should be
 * 		  documented using the Javadoc tool. (By default, annotations are not included in Javadoc.) For more information,
 * 		  see the Javadoc tools page.
 * 		- @Target annotation marks another annotation to restrict what kind of Java elements the annotation can be
 * 		  applied to. A target annotation specifies one of the following element types as its value:
 * 			ElementType.ANNOTATION_TYPE can be applied to an annotation type.
 * 			ElementType.CONSTRUCTOR can be applied to a constructor.
 * 			ElementType.FIELD can be applied to a field or property.
 * 			ElementType.LOCAL_VARIABLE can be applied to a local variable.
 * 			ElementType.METHOD can be applied to a method-level annotation.
 * 			ElementType.PACKAGE can be applied to a package declaration.
 * 			ElementType.PARAMETER can be applied to the parameters of a method.
 * 			ElementType.TYPE can be applied to any element of a class.
 * 		- @Inherited annotation indicates that the annotation type can be inherited from the super class. (This is not
 * 		  true by default.) When the user queries the annotation type and the class has no annotation for this type, the
 * 		  class' superclass is queried for the annotation type. This annotation applies only to class declarations.
 * 		- @Repeatable annotation, introduced in Java SE 8, indicates that the marked annotation can be applied more than
 * 		  once to the same declaration or type use.
 * 	. There are several methods available in the Reflection API that can be used to retrieve annotations. For example
 * 		 - AnnotatedElement.getAnnotation(Class<T>): If one annotation of the requested type is present.
 * 		 - AnnotatedElement.getAnnotationsByType(Class<T>): If more than one annotation of the requested type is present
 *
 */


public class Annotations_Summary {

}

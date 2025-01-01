package com.javaworld.A1_Core_Java.A6_Generics; /**
 * . In Generics, the question mark (?), called the wildcard, represents an unknown type. The wildcard can be used in a 
 *   variety of situations: as the type of a parameter, field, or local variable; sometimes as a return type
 *   (though it is better programming practice to be more specific).
 * 
 * . 1) Upper Bounded Wildcards <? extends T> : An upper bounded wildcard restricts the unknown type to be a specific type T
 *   or a sub-type of T. For example, say you want to write a method that works on List<Integer>, List<Double>, and
 *   List<Number>; you can achieve this by using an upper bounded wildcard. To write the method that works on list of 
 *   Number and the sub-types of Number, such as Integer, Double, and Float, you would specify List<? extends Number>. The
 *   term List<Number> is more restrictive than List<? extends Number> because the former matches a list of type Number
 *   only, whereas the latter matches a list of type Number or any of its subclasses.
 * 
 * . 2) Lower Bounded Wildcards <? super T> : A lower bounded wildcard restricts the unknown type to be a specific type T or
 *   a super-type of T. Say you want to write a method that puts Integer objects into a list. To maximize flexibility, you
 *   would like the method to work on List<Integer>,List<Number>, and List<Object>, anything that can hold Integer values.
 *   To write the method that works on lists of Integer and the super-types of Integer, such as Integer, Number, and 
 *   Object, you would specify List<? super Integer>. The term List<Integer> is more restrictive than List<? super Integer>
 *   because the former matches a list of type Integer only, whereas the latter matches a list of any type that is a 
 *   super-type of Integer.
 * 
 * . 3) Unbounded wildcard <?>: An Unbounded wildcard can represent any type, similar to Object in Java. It provides highest
 *   level of flexibility on passing method argument. For example List<?> (list of unknown type) can represent any List 
 *   i.e, List<String> or List<Integer>. Consider the following below method, printList(): The goal of printList is to print
 *   a list of any type, but it fails to achieve that goal if we use as printList(List <Object> list) { }, it prints only
 *   a list of Object instances; it cannot print List<Integer>, List<String>, List<Double>, and so on, because they are not
 *   sub-types of List<Object>. To write a generic printList method, use List <?>.
 * 
 * . 4) Wildcard Capture and Helper Methods: In some cases, the compiler infers the type of a wildcard. For example, a 
 *   list may be defined as List<?> but, when evaluating an expression, the compiler infers a particular type from the
 *   code. This scenario is known as wildcard capture. For the most part, you don't need to worry about wildcard capture,
 *   except when you see an error message that contains the phrase "capture of".
 * 
 * . Guidelines for Wildcard Use: 
 *   For purposes of this discussion, it is helpful to think of variables as providing one of two functions:
 *   An "In" Variable - provides data to the code.
 *   An "Out" Variable - holds data for use elsewhere.
 *   Imagine a copy method with two arguments: copy(src, dest). The src argument provides the data to be copied, so it 
 *   is the "in" parameter, the dest argument accepts data, so it is the "out" parameter.
 *   You can use the "in" and "out" principle when deciding whether to use a wildcard and what type of wildcard is 
 *   appropriate.
 *     - An "in" variable is defined with an upper bounded wildcard, using the extends keyword.
 *     - An "out" variable is defined with a lower bounded wildcard, using the super keyword.
 *     - In the case where the "in" variable can be accessed using methods defined in the Object class, use an unbounded
 *       wildcard.
 *     - In the case where the code needs to access the variable as both an "in" and an "out" variable, do not use a 
 *       wildcard.
 *     
 * . Do's and Dont's:
 *   -> The wildcard is never used as a type argument for a generic method invocation, a generic class instance creation,
 *      or a super-type. 
 *   -> You can specify an upper bound for a wildcard, or you can specify a lower bound, but you cannot specify both. 
 *   -> It's important to note that List<Object> and List <?> are not the same. You can insert an Object, or any 
 *      sub-type of Object, into a List<Object>, But you can only insert null into a List<?>.
 *   -> Using a wildcard as a return type should be avoided because it forces programmers using the code to deal with 
 *      wildcards.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DummyObject {
}

public class A9_WildcardOrUnknownType {
	public static void main(String[] args) {
		List<Number> numberList = new ArrayList<>(Arrays.asList(25L, 50, 7.5));
		List<Long> longList = Arrays.asList(61l, 18l, 43l, 11l, 22l, 33l, 65l, 89l);
		List<Integer> intList = Arrays.asList(12, 34, 22, 98, 55, 78);
		List<Object> objectList = Arrays.asList(new DummyObject(), new DummyObject());
		specificTypeOrSubType(numberList);
		specificTypeOrSubType(longList);
		// compile time error, accepts only List<Integer>, List<Number> and
		// List<Object> as arguments
		// specificTypeOrSuperType(longList);
		specificTypeOrSuperType(numberList);
		specificTypeOrSuperType(intList);
		specificTypeOrSuperType(objectList);
		unboundedType(numberList);
		unboundedType(longList);
		unboundedType(intList);
		unboundedType(objectList);
		System.out.println();
		wildcardCaptureUsingHelperMethod(numberList);
		wildcardCaptureUsingHelperMethod(intList);
		wildcardCaptureUsingHelperMethod(objectList);
	}

	private static void specificTypeOrSubType(List<? extends Number> list) {
		System.out.println("\n\nUpper Bounded wild card - specificTypeOrSubType(List<? extends Number> list:");
		for (int index = 0; index < list.size(); index++) {
			System.out.print(list.get(index) + ", ");
		}
	}

	private static void specificTypeOrSuperType(List<? super Integer> list) {
		System.out.println("\n\nLower Bounded wild card - specificTypeOrSuperType(List<? super Integer> list:");

		for (int index = 0; index < list.size(); index++) {
			System.out.print(list.get(index) + ", ");
		}
	}

	private static void unboundedType(List<?> list) {
		System.out.println("\n\nunbounded wild card - unknownType(List<?> list):");
		for (int index = 0; index < list.size(); index++) {
			System.out.print(list.get(index) + ", ");
		}
	}

	private static void wildcardCaptureUsingHelperMethod(List<?> list) {
		System.out.println("\nwildcardCaptureUsingHelperMethod(List<?> i): ");
		//for (int i = 0; i < list.size(); i++) {
		 // compile time error
		//  list.set(i, list.get(i));
		//}
		helperMethod(list);
	}
	// Helper method created so that the wildcard can be captured through type inference.
	private static <T> void helperMethod(List<T> l) {
		System.out.println("<T> void helperMethod(List<T> i): ");
		for (int i = 0; i < l.size(); i++) {
			l.set(i, l.get(i));
		}
		System.out.println(l);
	}
}
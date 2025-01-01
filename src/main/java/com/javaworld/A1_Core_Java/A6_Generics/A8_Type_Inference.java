package com.javaworld.A1_Core_Java.A6_Generics; /**
 * . Type inference is a Java compiler's ability to look at each method invocation and corresponding declaration to 
 *   determine the type argument (or arguments). 
 * 
 * . The inference algorithm determines the types of the arguments and, if available, the type that the result is being
 *   assigned, or returned. Finally, the inference algorithm tries to find the most specific type that works with all of
 *   the arguments.
 * 
 * . This feature allows you to invoke a generic method as an ordinary method, without specifying a "type witness" 
 *   between angle brackets. For example: 
 *    1) Util.<Integer, String>compare(p1, p2) can be written as Util.compare(p1, p2); - Generic method. 
 *    2) GenericBox<String> box = new GenericBox<String>() can be written as 
 *       GenericBox<String> box = new GenericBox<>(); - Generic class constructor.
 * 
 * . Target Types: The Java compiler takes advantage of target typing to infer the type parameters of a generic method
 *   invocation. The target type of an expression is the data type that the Java compiler expects depending on where
 *   the expression appears.
 * 
 * . Scenario 1: Consider the following assignment statement: List <String> listOne = Collections.emptyList(); 
 *   This statement is expecting an instance of List<String>; this data type is the target type. Because the method
 *   emptyList returns a value of type List<T>, the compiler infers that the type argument T must be the value String.
 *   This works in both Java SE 7 and 8.
 * 
 * . Scenario 2: Consider the following method:  void processStringList(List<String> stringList) { } 
 *   Suppose you want to invoke the method processStringList with an empty list, In Java SE 7, the following statement
 *   does not compile: processStringList(Collections.emptyList()); The Java SE 7 compiler generates an error message 
 *   similar to the following: 'List <Object> cannot be converted to List<String>'; Thus, in Java SE 7, you must
 *   specify the value of the type argument as follows: processStringList(Collections.<String>emptyList()); This is no
 *   longer necessary in Java SE 8.
 * 
 * . Note: It is important to note that the inference algorithm uses only invocation arguments, target types, and 
 *   possibly an obvious expected return type to infer types. It does not use results from later in the program.
 */

import java.util.ArrayList;
import java.util.List;



class BoxDemo {
	public static <U> void addBox(U u, List<GenericBox<U>> boxes) {
		GenericBox<U> box = new GenericBox<>();
		box.set(u);
		boxes.add(box);
	}
	public static <U> void outputBoxes(List<GenericBox<U>> boxes) {
		int counter = 0;
		for (GenericBox<U> box : boxes) {
			U boxContents = box.get();
			System.out.println("Box #" + counter + " contains [" + boxContents.toString() + "]");
			counter++;
		}
	}
}

public class A8_Type_Inference {
	public static void main(String[] args) {
		ArrayList<GenericBox<Integer>> listOfIntegerBoxes = new ArrayList<>();
		// as per java7
		BoxDemo.<Integer> addBox(10, listOfIntegerBoxes); 
		// valid in Java8 and above
		BoxDemo.addBox(20, listOfIntegerBoxes);
		BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
		System.out.println("list Of Integer Boxes");
		BoxDemo.outputBoxes(listOfIntegerBoxes);
		ArrayList<GenericBox<String>> listOfStringBoxes = new ArrayList<>();
		// as per java7
		BoxDemo.<String> addBox("Ten", listOfStringBoxes); 
		// valid in Java8 and above
		BoxDemo.addBox("Twenty", listOfStringBoxes);
		BoxDemo.addBox("Thirty", listOfStringBoxes);
		System.out.println("\nlist Of String Boxes");
		BoxDemo.outputBoxes(listOfStringBoxes);
   }
}
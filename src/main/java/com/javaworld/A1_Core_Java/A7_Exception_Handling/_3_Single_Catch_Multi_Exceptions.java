/**
 * 
 */
package com.javaworld.A1_Core_Java.A7_Exception_Handling;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shaik Khader
 
In Java SE 7 and later, a single catch block can handle more than one type of exception. This feature can reduce code duplication and lessen the temptation to catch an 
overly broad exception. For example using Exception class as a handler we can catch all type of exceptions except Error, but it is discouraged because exception handlers can
do more than just print error messages or halt the program. They can do error recovery, roll back, prompt the user to make a decision, or propagate the error up to a 
higher-level handler using chained exceptions(throwing the error).

In the catch clause, specify the types of exceptions that block can handle, and separate each exception type with a vertical bar (|).

Note: 
	If a catch block handles more than one exception type, then the catch parameter (In this example 'e') is implicitly final and therefore you cannot assign any values to 
	it within the catch block. All the child handlers must be declared before the parent handler. 
	for example:  catch(IndexOutOfBoundsException | RuntimeException | Exception | Throwable  e){ }
 	for example try to replace IOException with Exception, you will get a compile time error.
 */


class ListOfNumbers3 {

	private List<Integer> list;
	private static final int SIZE = 10;

	public ListOfNumbers3() {
		list = new ArrayList<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++) {
			list.add(new Integer(i*3));
		}
	}

	public void writeList() {
		
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("src\\resources\\OutFile.txt")); // Change path to cause IO exception
			
			for (int i = 0; i <= SIZE; i++) {  // it must be  i < SIZE to avoid exception
				out.println("Value at: " + i + " = " + list.get(i)); //this will cause IndexOutOfBoundsException exception
				System.out.println("Value at: " + i + " = " + list.get(i));
			}
			out.close();
			System.out.println("Exiting writeList()...."); //this will not be printed.
			
		}catch ( IOException | IndexOutOfBoundsException  e) { 
			e.printStackTrace();
		}
	}
	
}

public class _3_Single_Catch_Multi_Exceptions {

	/**
	 * 
	 */
	public _3_Single_Catch_Multi_Exceptions() {

	}

	public static void main(String[] args) {
		System.out.println("****** Java 'Single Catch MultiExceptions' Example ********\n");
		
		ListOfNumbers3 listOfNumbers = new ListOfNumbers3();
		listOfNumbers.writeList();
		
		System.out.println("\n****************************************");   //this will be printed as exception is handled.
	}

}

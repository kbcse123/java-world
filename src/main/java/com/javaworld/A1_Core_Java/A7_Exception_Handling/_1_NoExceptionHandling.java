/**
 * 
 */
package com.javaworld.A1_Core_Java.A7_Exception_Handling;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shaik Khader
 
 An exception is an event, which occurs during the execution of a program that interrupts its normal flow.
 Exception handling is one of the powerful features in java that provides a mechanism to handle exceptions and
 maintaining normal flow of program.
 
 Exceptions can be classified as:
 
 	- Checked Exceptions:	Checked Exceptions are exceptional scenarios that we can anticipate in a program and try to
							recover from it, for example IOException, SQLException, DataFormatException,
							IllegalCharException. The Class 'Exception' and its sub classes (except RuntimeException
							and it's subclasses) are checked exceptions, We should catch this type of exception and
							provide useful message to the user.
 			
 	- UnChecked Exceptions:	
 			
 			a) Runtime Exceptions: Runtime exception occurs due to bad programming, for example NullPointerException,
 								   ArithmeticException,ClassCastException, IndexOutOfBoundsException. It can be avoided
								   by following better coding standards.
 			
 			b) Error: 	Error are exceptional scenarios that are out of scope for application, and that the application
						usually cannot anticipate or recover from (Hardware Failure, Network failure). For example
						StackOverflowError,OutOfMemoryError,IOError,AssertionError.
 			

 */


class ListOfNumbers1 {

	private List<Integer> list;
	private static final int SIZE = 10;

	public ListOfNumbers1() {
		list = new ArrayList<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++) {
			list.add(new Integer(i));
		}
	}

	public void writeList() {
		
		//PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt")); // The FileWriter constructor throws IOException,which must be caught.
		PrintWriter out = null;  // comment this line and uncomment the above line, u will know.
		
		for (int i = 0; i < SIZE; i++) {
			// The get(int) method throws IndexOutOfBoundsException, which must be caught.
			out.println("Value at: " + i + " = " + list.get(i));
		}
		out.close();
		System.out.println("Exiting writeList()...."); //this will not be printed.
	}
}

public class _1_NoExceptionHandling {

	/**
	 * 
	 */
	public _1_NoExceptionHandling() {

	}

	public static void main(String[] args) {
		System.out.println("****** Java Exception Handling Example ********\n");
		ListOfNumbers1 listOfNumbers = new ListOfNumbers1();
		listOfNumbers.writeList();
		System.out.println("\n****************************************");   //this will not be printed due to exception
	}

}

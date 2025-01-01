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
 
The try block:  The first step in constructing an exception handler is to enclose the code that might throw an exception within a 'try{}' block.
				If an exception occurs within the try block, that exception is handled by an exception handler associated with it.
 
The catch blocks:   You associate exception handlers with a try block by providing one or more catch blocks directly after the try block. 
				    No code can be in between the end of the try block and the beginning of the first catch block. 
 					Each catch block is an exception handler that handles the type of exception indicated by its argument and 
 					The handler must be the name of a class that inherits from the Throwable class.

Note: 	A try statement does not have to have a catch block if it has a finally block. If the code in the try statement has multiple exit points and no associated catch clauses, 
		the code in the finally block is executed no matter how the try block is exited. So the below code legal,  
		try{
		
		}finally{
		
		}		
 
 */


class ListOfNumbers2 {

	private List<Integer> list;
	private static final int SIZE = 10;

	public ListOfNumbers2() {
		list = new ArrayList<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++) {
			list.add(new Integer(i*2));
		}
	}

	public void writeList() {
		
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("src\\resources\\OutFile.txt"));
			
			for (int i = 0; i <= SIZE; i++) {  // it must be  i < SIZE to avoid exception
				out.println("Value at: " + i + " = " + list.get(i)); //this will cause IndexOutOfBoundsException exception
				System.out.println("Value at: " + i + " = " + list.get(i));
			}
			out.close();
			System.out.println("Exiting writeList()...."); //this will not be printed.
			
		}catch (IOException e) {
			e.printStackTrace();
		}catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		
		
	}
}

public class _2_Try_Catch {

	/**
	 * 
	 */
	public _2_Try_Catch() {

	}

	public static void main(String[] args) {
		System.out.println("****** Java 'try - catch' Example ********\n");
		
		ListOfNumbers2 listOfNumbers = new ListOfNumbers2();
		listOfNumbers.writeList();
		
		System.out.println("\n****************************************");   //this will be printed as exception is handled.
	}

}

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
 
The try-with-resources statement was introduced in Java SE 7 which is a try statement that declares one or more resources. A resource is an object that must be closed after the program is finished with it. 
This statement ensures that each resource is closed at the end of the statement.
Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, can be used as a resource.

Note: A try-with-resources statement can have catch and finally blocks just like an ordinary try statement. In a try-with-resources statement, 
any catch or finally block is run after the resources declared have been closed.

 */


class ListOfNumbers5 {

	private List<Integer> list;
	private static final int SIZE = 10;

	public ListOfNumbers5() {
		list = new ArrayList<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++) {
			list.add(new Integer(i*5));
		}
	}

	public void writeList() {
		
		try(PrintWriter out = new PrintWriter(new FileWriter("src\\resources\\OutFile.txt"))) {
			
			for (int i = 0; i <= SIZE; i++) {  // it must be  i < SIZE to avoid exception
				out.println("Value at: " + i + " = " + list.get(i)); //this will cause IndexOutOfBoundsException exception
				System.out.println("Value at: " + i + " = " + list.get(i));
			}
			
		}catch ( IOException | IndexOutOfBoundsException  e) {  
			e.printStackTrace();
		}
		
		System.out.println("Exiting writeList()...."); 
	}
}

public class _5_Try_With_Resources {

	/**
	 * 
	 */
	public _5_Try_With_Resources() {

	}

	public static void main(String[] args) {
		System.out.println("****** Java 'try-with-resources' Example ********\n");
		
		ListOfNumbers5 listOfNumbers = new ListOfNumbers5();
		listOfNumbers.writeList();
		
		System.out.println("\n****************************************");   //this will be printed as exception is handled.
	}

}

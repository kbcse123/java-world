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
 
The finally Block:  
	
	The finally block always executes when the try block exits. This ensures that the finally block is executed even if an unexpected exception occurs. 
But finally is useful for more than just exception handling  it allows the programmer to avoid having cleanup code accidentally bypassed by a return, 
continue, or break. Putting cleanup code in a finally block is always a good practice, even when no exceptions are anticipated. for example uncomment the code 
"return;" in the below program and notice that finally block will be executed at any cost. 

Finally block will not be executed in below scenarios: 
	.If the JVM exits (unexpectedly) while the try or catch code is being executed. 
	.If the thread is interrupted or killed while its executing the try or catch code. 
	.for example uncomment the code "System.exit(1)" in the below program and notice that finally block will not be executed. 

 */


class ListOfNumbers4 {

	private List<Integer> list;
	private static final int SIZE = 10;

	public ListOfNumbers4() {
		list = new ArrayList<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++) {
			list.add(new Integer(i*4));
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
			
		}catch ( IOException | IndexOutOfBoundsException  e) {  
			e.printStackTrace();
			//System.exit(1);   
			//return;
		}finally{
			if(out != null){
				out.close();
				System.out.println("\nfinally: PrintWriter object released."); 
			}else{
				System.out.println("\nfinally: PrintWriter object is null.");
			}
		}
		//this will not be printed if the above exit or return statement is uncommented.
		System.out.println("Exiting writeList()....");
	}
}

public class _4_Finally {

	/**
	 * 
	 */
	public _4_Finally() {

	}

	public static void main(String[] args) {
		System.out.println("****** Java 'finally' Example ********\n");
		
		ListOfNumbers4 listOfNumbers = new ListOfNumbers4();
		listOfNumbers.writeList();
		
		System.out.println("\n****************************************");   //this will be printed as exception is handled.
	}

}

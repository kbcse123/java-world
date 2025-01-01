package com.javaworld.A1_Core_Java.A8_Basic_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Shaik Khader
 
A byte stream access the file byte by byte. All byte stream classes are descended from InputStream and OutputStream.
There are many byte stream classes. To demonstrate how byte streams work, we'll focus on the file I/O byte streams,
FileInputStream and FileOutputStream. Other kinds of byte streams are used in much the same way; they differ mainly in
the way they are constructed.
 
Note: 
	1.Why we should always Close Streams:
			Closing a stream when it's no longer needed is very important. File handles are scarce, finite resources. 
			You can run out of them if you don't clean them up properly, just like database connections. 
			The below example uses the new try-with-resources statement to achieve it. The same behavior can also be
			achieved simply by using
			try and finally blocks (in this case there is no need for 'catch' block as the method uses 'throws').   
 	
 	2.When Not to Use Byte Streams:
 			A byte stream is suitable for any kind of file, however not quite appropriate for the text files. For example, if the file is using a unicode encoding and a character is represented with two bytes, 
 			the byte stream will treat these separately and you will need to do the conversion yourself. The below used 'inputFile.txt' contains character
 			data, the best approach is to use character streams.
 	
 	
 	"First we make our habits, then they make us." we must try to apply best practices even when they aren't necessary.
 	
 */
public class A2_ByteStreams {

	/**
	 * 
	 */
	public A2_ByteStreams() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		String from = "src\\main\\java\\resources\\inputFile.txt";
		String to = "src\\main\\java\\resources\\outputFile.txt";
		
		copyBytes(from,to);
	}

	private static void copyBytes(String source, String dest) throws IOException {
		
		try(FileInputStream  inputStream = new FileInputStream(source);
	        FileOutputStream outputStream = new FileOutputStream(dest)) {
	            int c;
	            while ((c = inputStream.read()) != -1) {
					outputStream.write(c);
	            }
	    }
		System.out.println("Copy Task Completed....."); 
	}

}

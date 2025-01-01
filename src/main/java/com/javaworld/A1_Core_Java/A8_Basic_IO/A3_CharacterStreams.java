package com.javaworld.A1_Core_Java.A8_Basic_IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Shaik Khader
 * 
 *         The Java platform stores character values using Unicode conventions.
 *         Character stream I/O automatically translates this internal format to
 *         and from the local character set.
 * 
 *         A program that uses character streams in place of byte streams
 *         automatically adapts to the local character set and is ready for
 *         internationalization. If internationalization isn't a priority, you
 *         can simply use the character stream classes without paying much
 *         attention to character set issues, Later if internationalization
 *         becomes a priority, your program can be adapted without extensive
 *         recoding.
 * 
 *         In the below example 'copyChars' is very similar to 'copyBytes'. The
 *         most important difference is that copyChars method uses FileReader
 *         and FileWriter for input and output in place of FileInputStream and
 *         FileOutputStream. Notice that both 'copyBytes' and 'copyChars' use an
 *         int variable to read to and write from. However, in 'copyChars', the
 *         int variable holds a character value in its last 16 bits; in
 *         'copyBytes', the int variable holds a byte value in its last 8 bits.
 * 
 *         Character streams are often "wrappers" for byte streams. The
 *         character stream uses the byte stream to perform the physical I/O,
 *         while the character stream handles translation between characters and
 *         bytes. FileReader, for example, uses FileInputStream, while
 *         FileWriter uses FileOutputStream.
 */
public class A3_CharacterStreams {

	/**
	 * 
	 */
	public A3_CharacterStreams() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		String from = "src\\main\\java\\resources\\inputFile.txt";
		String to = "src\\main\\java\\resources\\outputFile.txt";

		copyChars(from, to);
	}

	private static void copyChars(String source, String dest) throws IOException {

		try(FileReader reader = new FileReader(source);
			FileWriter writer = new FileWriter(dest);) {
			int c;
			while ((c = reader.read()) != -1) {
				writer.write(c);
			}
		}
		System.out.println("Copy Task Completed.....");
	}

}

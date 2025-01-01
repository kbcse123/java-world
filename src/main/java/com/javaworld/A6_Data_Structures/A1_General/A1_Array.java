package com.javaworld.A6_Data_Structures.A1_General;
/**
 * 
 */

/**
 * @author Shaik Khader
 * 
 *         Array is a data structure used to store homogeneous elements at
 *         contiguous locations. Size of an array must be provided before
 *         storing data. Array can contains primitive data types as well as
 *         objects of a class depending on the definition of array. In case of
 *         primitives data types, the actual values are stored in contiguous
 *         memory locations. In case of objects of a class, the actual objects
 *         are stored in heap segment.
 * 
 *         There are 2 behavioral differences between an array in Java and a
 *         similar array in C++:
 * 
 *         .A Java array is aware of its size while a C++ array is not. Arrays
 *         in Java are implemented as objects so it have an instance field to
 *         store the size of the array. eg: arr.length, here length is an
 *         instance field. While C++ arrays are a primitive data type - not an
 *         instance of a class so C++ arrays do NOT support the .length
 *         attribute. .A Java array prevents a programmer from indexing the
 *         array out of bounds while a C++ does not. Like C++, arrays in Java
 *         are zero indexed; so legal index values in both languages range from
 *         0 to size - 1. But unlike C++, if you address a Java array out of
 *         those legal bounds, the error is caught and the program aborts with
 *         an IndexOutOfBoundsException. If you index out of bounds in a C++
 *         program, the program can behave in a number of different ways.
 * 
 *         Time Complexities:
 * 
 *         Accessing Time: O(1) - This is possible because elements are stored
 *         at contiguous locations. Search Time: O(n) - for Sequential Search.
 *         O(log n) - for Binary Search [If Array is sorted] Insertion Time:
 *         O(n) - The worst case occurs when insertion happens at the Beginning
 *         of an array and requires shifting all of the elements. Deletion Time:
 *         O(n) - The worst case occurs when deletion happens at the Beginning
 *         of an array and requires shifting all of the elements.
 * 
 * 
 */

public class A1_Array {
	public static void main(String args[]) {
		multiDimensionalArrays();
	}

	private static void multiDimensionalArrays() {
		// declaring and initializing 2D array
		int arr[][][] = { { { 1, 2, 3 }, { 2, 3, 4 } }, { { 4, 5, 6, 9 }, { 1 }, { 2, 3 } } };
		int totalElements = 0;
		int sumOfElements = 0;
		int rows = 0;
		int columns = 0;
		for (int[][] arr1 : arr) {
			for (int[] arr2 : arr1) {
				for (int arrayItem : arr2) {
					System.out.print(arrayItem + " ");
					sumOfElements += arrayItem;
				}
				totalElements += arr2.length;
				columns = (columns < arr2.length) ? arr2.length : columns;
				rows++;
				System.out.println();
			}
		}
		System.out.println("\nTotal rows = " + rows);
		System.out.println("Total columns = " + columns);
		System.out.println("Total Elements = " + totalElements);
		System.out.println("Sum Of Elements = " + sumOfElements);
		System.out.println("Array Capacity = " + (rows * columns));

	}
}

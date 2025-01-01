package com.javaworld.A9_Algorithms.E_Sorting_Algorithms;
/**
 * 
 */

/**
 * @author Shaik Khader
 * 
 * 
 *         Insertion sort is a simple sorting algorithm that works the way we
 *         sort playing cards in our hands.
 * 
 *         Example: 12, 11, 13, 5, 6
 * 
 *         Let us loop for i = 1 (second element of the array) to 5 (Size of
 *         input array)
 * 
 *         i = 1. Since 11 is smaller than 12, move 12 and insert 11 before 12
 *         11, 12, 13, 5, 6
 * 
 *         i = 2. 13 will remain at its position as all elements in A[0..I-1]
 *         are smaller than 13 11, 12, 13, 5, 6
 * 
 *         i = 3. 5 will move to the beginning and all other elements from 11 to
 *         13 will move one position ahead of their current position. 5, 11, 12,
 *         13, 6
 * 
 *         i = 4. 6 will move to position after 5, and elements from 11 to 13
 *         will move one position ahead of their current position. 5, 6, 11, 12,
 *         13
 * 
 *         Time Complexity: O(n*n)
 * 
 *         Auxiliary Space: O(1)
 * 
 *         Boundary Cases: Insertion sort takes maximum time to sort if elements
 *         are sorted in reverse order. And it takes minimum time (Order of n)
 *         when elements are already sorted.
 * 
 *         Algorithmic Paradigm: Incremental Approach
 * 
 *         Sorting In Place: Yes
 * 
 *         Stable: Yes
 * 
 */

class InsertionSort extends Sorter {
	int swaps = 0;

	/* Function to sort array using insertion sort */
	void sort(int arr[]) {
		for (int outerIndex = 0; outerIndex < arr.length; outerIndex++) {
			System.out.println("********* Pass : " + (outerIndex + 1) + ", Iterations to perform : " + (arr.length - 1)
					+ " *********");

			for (int innerIndex = outerIndex; innerIndex > 0; innerIndex--) {

				System.out.print("index : " + innerIndex + " -> ");
				printArray(arr);
				System.out.println();
				if (arr[innerIndex] < arr[innerIndex - 1]) {
					swap(arr, innerIndex, innerIndex - 1);
				}

			}
		}
	}

	/*
	 * private void swap(int[] arr, int innerIndex, int innerPrevIndex) {
	 * swaps++; System.out.println(arr[innerPrevIndex] + " > " + arr[innerIndex]
	 * + " so swap " + arr[innerIndex] + " and " + arr[innerPrevIndex] + ".");
	 * int t = arr[innerIndex]; arr[innerIndex] = arr[innerPrevIndex];
	 * arr[innerPrevIndex] = t; printArray(arr); System.out.println(); }
	 */

}

public class A3_InsertionSort {
	public static void main(String... args) {
		System.out.println("*** Insertion Sort  - Ascending Order ***");
		InsertionSort ob = new InsertionSort();
		int arr[] = { 99, 88, 77, 66, 55, 44, 33, 22, 11, 0 }; // worst case
		// int arr[] = {0,11,22,33,44,55,66,77,88,99}; //best case
		System.out.println("Before Sorting....");
		ob.printArray(arr);
		System.out.println();
		long start = System.currentTimeMillis();
		ob.sort(arr);
		long end = (System.currentTimeMillis() - start);
		System.out.println("After Sorting....");
		ob.printArray(arr);
		System.out.println("\nNumber of Elements = " + arr.length);
		System.out.println("Number of Swaps = " + ob.swaps);
		System.out.println("Time taken= " + end + " ms");

	}

}

/**
 * 
 */
package com.javaworld.A9_Algorithms.E_Sorting_Algorithms;

import java.util.Arrays;

/**
 * @author Admin
 *
 */
public abstract class Sorter {
	int swaps = 0;

	// Prints the array
	void printArray(int arr[]) {
		System.out.println(Arrays.toString(arr));
	}

	// with temp
	// int temp = x; x = y; y = temp;

	// without temp. 2 ways
	// x=x+y; y=x-y; x=x-y; //1
	// x = x ^ y ^ (y = x); //2
	void swap(int[] arr, int current, int min) {
		if (min == current)
			return;
		// System.out.println("Current Item -> " + arr[current] + ", Mininum
		// Item -> " + arr[min]);
		System.out.print("After Swapping " + arr[current] + " with " + arr[min] + " -> ");
		int temp = arr[min];
		arr[min] = arr[current];
		arr[current] = temp;
		swaps++;
		printArray(arr);
	}
}

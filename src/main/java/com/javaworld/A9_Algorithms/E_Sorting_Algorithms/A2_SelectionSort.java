package com.javaworld.A9_Algorithms.E_Sorting_Algorithms;
/**
 * 
 */

/**
 * @author Shaik Khader
 * 
 *         Selection sort is specifically an in-place comparison sort. It has
 *         O(n*n) time complexity, making it inefficient on large lists, and
 *         generally performs worse than the similar insertion sort. Selection
 *         sort is noted for its simplicity, and it has performance advantages
 *         over more complicated algorithms in certain situations, particularly
 *         where auxiliary memory is limited.
 * 
 *         The algorithm (considering ascending order):
 * 
 *         .Find the minimum element in the array.
 * 
 *         .Swap the minimum element with the current element.
 * 
 *         .Repeat the whole process until array is fully sorted.
 * 
 *         Time Complexity: O(n*n) as there are two nested loops. Auxiliary
 *         Space: O(1)
 * 
 *         In Place Sorting: Yes
 * 
 *         Stable: Yes
 * 
 *         The good thing about selection sort is it never makes more than O(n)
 *         swaps and can be useful when memory write is a costly operation.
 * 
 */

// Java program for implementation of Selection Sort
class SelectionSort extends Sorter {

	void sort(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; (j < arr.length && arr[j] < arr[min]); j++) {
				min = j;
			}
			swap(arr, min, i);
		}
	}

}

public class A2_SelectionSort {
	public static void main(String... args) {
		System.out.println("*** Selection Sort - Ascending Order ***");
		SelectionSort ob = new SelectionSort();
		// int arr[] = {100, 99, 88, 77, 66,55,44,33,22,11}; // worst case
		int arr[] = { 11, 22, 33, 44, 55, 66, 77, 88, 99, 100 }; // best case
		System.out.print("Before Sorting -> ");
		ob.printArray(arr);
		System.out.println();
		long start = System.currentTimeMillis();
		ob.sort(arr);
		long end = (System.currentTimeMillis() - start);
		System.out.println("\nAfter Sorting....");
		ob.printArray(arr);
		System.out.println("Number of Elements = " + arr.length);
		System.out.println("Number of Swaps = " + ob.swaps);
		System.out.println("Time taken= " + end + " ms");

	}

}

/**
 * 
 */
package com.javaworld.A9_Algorithms.E_Sorting_Algorithms;

/**
 * @author Shaik Khader
 * 
 *         Merge Sort is an efficient, general-purpose, comparison-based sorting
 *         algorithm. Most implementations produce a stable sort, which means
 *         that the implementation preserves the input order of equal elements
 *         in the sorted output. Merge sort is a divide and conquer algorithm
 *         that was invented by John von Neumann in 1945.
 * 
 *         Conceptually, a merge sort works as follows:
 * 
 *         Divide the unsorted list into n sublists, each containing 1 element
 *         (a list of 1 element is considered sorted). Repeatedly merge sublists
 *         to produce new sorted sublists until there is only 1 sublist
 *         remaining. This will be the sorted list.
 * 
 * 
 * 
 * 
 */

class MergeSort extends Sorter {
	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(int[] arr, int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int[] L = new int[n1];
		int[] R = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(int[] arr, int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	/* A utility function to print array of size n 
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}*/

}

public class A4_MergeSort {
	public static void main(String[] args) {
		int[] arr = { 99, 88, 77, 66, 55, 44, 33, 22, 11, 0 }; // worst case
		// int arr[] = {0,11,22,33,44,55,66,77,88,99}; //best case
		System.out.print("Given Array -> ");
		MergeSort ob = new MergeSort();
		ob.printArray(arr);
		long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		long start = System.currentTimeMillis();
		ob.sort(arr, 0, arr.length - 1);
		long end = (System.currentTimeMillis() - start);
		long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		long actualMemUsed=afterUsedMem-beforeUsedMem;
		System.out.println("\nMemory used= "+(actualMemUsed)+" bytes");
		System.out.println("\nSorted array");
		ob.printArray(arr);
		System.out.println("Time taken= " + end + " ms");

	}

}

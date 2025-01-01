package com.javaworld.A9_Algorithms.E_Sorting_Algorithms;
/**
 * 
 */

/**
 * @author Shaik Khader
 * 
 *         https://en.wikipedia.org/wiki/Bubble_sort
 * 
 *         Bubble sort, sometimes referred to as sinking sort, is a simple
 *         sorting algorithm that repeatedly steps through the list to be
 *         sorted, compares each pair of adjacent items and swaps them if they
 *         are in the wrong order. The pass through the list is repeated until
 *         no swaps are needed, which indicates that the list is sorted.
 * 
 *         The algorithm, which is a comparison sort, is named for the way
 *         smaller or larger elements "bubble" to the top of the list. Although
 *         the algorithm is simple, it is too slow and impractical for most
 *         problems. Even other O(n*n) sorting algorithms, such as insertion
 *         sort, tend to have better performance than bubble sort. Therefore,
 *         Bubble sort should be avoided in the case of large collections. It
 *         will not be efficient in the case of a reverse-ordered collection.
 * 
 *         Worst and Average Case Time Complexity: O(n*n). Worst case occurs
 *         when array is reverse sorted.
 * 
 *         Best Case Time Complexity: O(n). Best case occurs when array is
 *         already sorted.
 * 
 *         Auxiliary Space: O(1)
 * 
 *         Boundary Cases: Bubble sort takes minimum time (Order of n) when
 *         elements are already sorted.
 * 
 *         In Place Sorting: Yes
 * 
 *         Stable: Yes
 * 
 */

// Java program for implementation of Bubble Sort
class BubbleSort extends Sorter {
	int swaps = 0;

	void sort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					/*
					 * int temp=arr[j]; arr[j]=arr[j+1]; arr[j+1]=temp;
					 */
				}
			}
			System.out.print("Iteration " + (i + 1) + ": ");
			printArray(arr);
		}
	}

	/*
	 * private void swap(int[] arr, int currIndex, int nextIndex) {
	 * 
	 * //System.out.println(arr[currIndex] + " > " + arr[nextIndex] +
	 * " so swap " + arr[currIndex] + " and " // + arr[nextIndex] + ".");
	 * arr[currIndex] = arr[currIndex] ^ arr[nextIndex] ^ (arr[nextIndex] =
	 * arr[currIndex]); printArray(arr); System.out.println(); swaps++; }
	 */

}

public class A1_BubbleSort {
	public static void main(String... args) {
		System.out.println("*** Bubble Sort - Ascending Order ***");
		BubbleSort ob = new BubbleSort();
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

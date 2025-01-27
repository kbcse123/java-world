package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;

import org.junit.Test;

import java.util.Arrays;

/**
 * Arrays are fundamental structures in Java that allow us to store multiple values of the same type
 * in a single variable. They are useful for storing and managing collections of data.
 * Arrays in Java are objects, which makes them work differently from arrays in C/C++ in terms of
 * memory management.
 *
 * For primitive arrays, elements are stored in a contiguous memory location. For non-primitive
 * arrays, references are stored at contiguous locations, but the actual objects may be at different
 * locations in memory.
 *
 */
public class C3_Arrays {

    @Test
    public void displayArrayElements(){
        // declare and initialize array
        int[] arr = { 0, 1, 2, 3, 4 };
        for(int element:arr){
            System.out.print(element);
        }

    }
    @Test
    public void displayArrayElementsInReverse(){
        //declare array
        int[] array = new int[5];
        //initialize array
        for (int i = array.length-1; i >= 0; i--){
            array[i] = i;
            System.out.print(array[i] + " ");
        }
    }

    @Test
    public void traverseMultiDimensionalArray(){
        System.out.println("Declared and Initialized with default value 0");
        int[][] arr1 = new int[3][3];
        // Number of Rows
        System.out.println("Rows : " + arr1.length);
        // Number of Columns
        System.out.println("Columns : " + arr1[0].length);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nDeclared and Initialized with values");
        int arr2[][] = { { 2, 7, 9 }, { 3, 6, 1 }, { 7, 4, 2 } };

        System.out.println(Arrays.deepToString(arr2));
    }

    @Test
    public void cloningArrays(){
        int intArray[] = { 1, 2, 3 };
        int cloneArray[] = intArray.clone();
        System.out.println(Arrays.toString(intArray));
        // will print false as shallow copy is created
        System.out.println(intArray == cloneArray);
        System.out.println(Arrays.toString(cloneArray));
    }

    public void arryaStreamOperations(){
        int intArray[] = { 5, 2, 8, 4 };
        System.out.println(Arrays.stream(intArray).count());
        System.out.println(Arrays.stream(intArray).sum());
    }
}

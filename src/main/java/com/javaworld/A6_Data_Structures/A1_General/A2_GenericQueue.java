package com.javaworld.A6_Data_Structures.A1_General;

import java.util.Arrays;
import java.util.Random;

import com.javaworld.A6_Data_Structures.LinearStructure;

/**
 * @author shaik
 *
 */
public class A2_GenericQueue<E> implements LinearStructure<E> {

	private int front, rear, capacity, currentSize;
	private E[] elements;

	public A2_GenericQueue(int size) {
		elements = (E[]) new Object[size];
		// front=currentSize=0;
		currentSize = 0;
		front = rear = -1;
		capacity = size;
	}

	@Override
	public boolean add(E e) {
		if (isFull()) {
			System.out.println("Queue is full...Cannot add -> " + e);
			return false;
		}
		rear = (rear + 1) % capacity;
		System.out.println("Adding Item " + e + ", Front-> " + front + ", rear-> " + rear);
		elements[rear] = e;
		currentSize++;
		return true;
	}

	@Override
	public boolean isFull() {
		return currentSize == capacity;
	}

	@Override
	public E remove() {
		if (isEmpty()) {
			System.out.println("Queue is Empty...Cannot remove");
			return null;
		}
		front = (front + 1) % capacity;
		E e = elements[front];
		System.out.println("Removing Item" + e + ", Front-> " + front + ", rear-> " + rear);
		elements[front] = null;
		currentSize--;
		return e;
	}

	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}

	@Override
	public int search(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Queue elements= " + Arrays.toString(elements);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinearStructure<Integer> queue = new A2_GenericQueue<>(5);
		while (!queue.isFull()) {
			queue.add(new Random().nextInt(10));
		}
		System.out.println(queue);
		while (!queue.isEmpty()) {
			queue.remove();
		}
		System.out.println(queue);
		queue.remove();
	}

}

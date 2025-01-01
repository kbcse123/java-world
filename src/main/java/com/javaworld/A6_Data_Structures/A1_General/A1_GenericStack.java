package com.javaworld.A6_Data_Structures.A1_General;

import java.util.Arrays;
import java.util.Random;

import com.javaworld.A6_Data_Structures.LinearStructure;

public class A1_GenericStack<E> implements LinearStructure<E> {
	private int sp = -1;
	private E[] elements;

	public A1_GenericStack(int size) {
		elements = (E[]) new Object[size];
	}

	@Override
	public boolean isEmpty() {
		return sp < 0;
	}

	@Override
	public boolean isFull() {
		return sp == (elements.length - 1);
	}

	@Override
	public String toString() {
		return "Stack elements= " + Arrays.toString(elements);
	}

	@Override
	public boolean add(E e) {
		if (isFull()) {
			System.out.println("Stack is full.Cannot push element");
			return false;
		}
		elements[++sp] = e;
		return true;
	}

	@Override
	public E remove() {
		if (isEmpty()) {
			System.out.println("Stack is empty.Cannot pop element");
			return null;
		}
		E element = elements[sp];
		elements[sp--] = null;
		return element;
	}

	@Override
	public int search(E e) {
		if (e == null) {
			System.out.println("Invalid Search element");
			return -1;
		}
		for (int i = 0; i < elements.length; i++) {
			if (e.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		LinearStructure<Integer> myStack = new A1_GenericStack<>(10);
		while (!myStack.isFull()) {
			myStack.add(new Random().nextInt(10));
		}
		System.out.println(myStack);
		System.out.println("Location of item: " + myStack.search(7));
		myStack.remove();
		myStack.remove();
		System.out.println(myStack);

	}
}

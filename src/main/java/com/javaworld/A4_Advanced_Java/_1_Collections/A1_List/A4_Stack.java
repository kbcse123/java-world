package com.javaworld.A4_Advanced_Java._1_Collections.A1_List;

import java.util.Stack;

/**
 * @author Shaik Khader
 * 
 *         Stack class falls under the Collection framework that extends the
 *         Vector class. It also implements interfaces List, Collection,
 *         Iterable, Cloneable, Serializable. It represents the LIFO stack of
 *         objects.
 * 
 *         The stack is a linear data structure that is used to store the
 *         collection of objects. It is based on Last-In-First-Out (LIFO)
 * 
 *         We can perform push, pop, peek and search operation on the stack. The
 *         Java Stack class provides mainly five methods to perform these
 *         operations. Along with this, it also provides all the methods of the
 *         Java Vector class.
 * 
 */

public class A4_Stack {
	public static void main(String... args) {
		// creating an instance of Stack class
		Stack<Integer> stk = new Stack<>();
		// checking stack is empty or not
		boolean result = stk.empty();
		System.out.println("Is the stack empty? " + result);
		// pushing elements into stack
		stk.push(78);
		stk.push(113);
		stk.push(90);
		stk.push(120);
		// prints elements of the stack
		System.out.println("Elements in Stack: " + stk);
		result = stk.empty();
		System.out.println("Is the stack empty? " + result);
		// invoking pop() method
		System.out.println("Item popped: " + stk.pop());
		System.out.println("Item popped: " + stk.pop());
		// Access element from the top of the stack, it does not remove element from
		// stack
		System.out.println("Top Item is: " + stk.peek());
		// Search an element
		System.out.println("Location of item 90: " + stk.search(90));

	}

}

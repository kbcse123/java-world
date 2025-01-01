package com.javaworld.A4_Advanced_Java._1_Collections.A3_Deque;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Shaik Khader
 * 
 *         Doubly-linked list implementation of the List and Deque interfaces.
 *         Implements all optional list operations, and permits all elements
 *         (including null).
 * 
 *         Note that this implementation is not synchronized. If multiple
 *         threads access a linked list concurrently, and at least one of the
 *         threads modifies the list structurally, it must be synchronized
 *         externally.
 * 
 *         This is typically accomplished by synchronizing on some object that
 *         naturally encapsulates the list. If no such object exists, the list
 *         should be "wrapped" using the Collections.synchronizedList method.
 *         This is best done at creation time, to prevent accidental
 *         unsynchronized access to the list:
 * 
 *         List list = Collections.synchronizedList(new LinkedList(...));
 * 
 *         The iterators returned by this class's iterator and listIterator
 *         methods are fail-fast: if the list is structurally modified at any
 *         time after the iterator is created, in any way except through the
 *         Iterator's own remove or add methods, the iterator will throw a
 *         ConcurrentModificationException. Thus, in the face of concurrent
 *         modification, the iterator fails quickly and cleanly, rather than
 *         risking arbitrary, non-deterministic behavior at an undetermined time
 *         in the future.
 * 
 *         Fail-fast iterators throw ConcurrentModificationException on a
 *         best-effort basis.the fail-fast behavior of iterators should be used
 *         only to detect bugs.
 * 
 * 
 * 
 * 
 */

public class A2_LinkedList {
	public static void main(String... args) {
		Deque<Integer> dq = new LinkedList<>();
		System.out.println("--- Insert Operation ---");
		for(int i=1;i<=5;i++){
			dq.add(i);
		}
		System.out.println("After add(). Elements: "+dq); 
		//returns true if the element was added to this queue
		dq.offer(null);
		System.out.println("After offer(null). Elements: "+dq); 
		System.out.println("\n--- Delete Operation: ---");
		dq.poll();
		System.out.println("After poll(). Elements: "+dq); 
		dq.remove();
		System.out.println("After remove(). Elements: "+dq); 
		System.out.println("\n--- Examine Operation: ---");
		// returns null if queue is empty.
		System.out.println("dq.peek(): "+dq.peek());
		//throws NoSuchElementException if queue is empty
		System.out.println("dq.element(): "+dq.element());
		System.out.println("\n--- Iteration using for loop: ---");
		for(Integer i:dq){
			System.out.print(i+" -> ");
		}
		System.out.println("\n--- Iteration using iterator: ---");
		Iterator<Integer> itr = dq.iterator();
		//dq.remove(); //throws ConcurrentModificationException
		while(itr.hasNext()){
			Integer i = itr.next();
			System.out.print(i+" -> ");
		}
		
	}

}

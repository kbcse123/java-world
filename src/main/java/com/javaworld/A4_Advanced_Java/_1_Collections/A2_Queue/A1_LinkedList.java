package com.javaworld.A4_Advanced_Java._1_Collections.A2_Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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

public class A1_LinkedList {
	public static void main(String... args) {
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=5;i++){
			q.add(i);
		}
		System.out.println("--- Insert Operation ---");
		System.out.println("After add(). Elements: "+q); 
		//returns true if the element was added to this queue
		q.offer(null);
		System.out.println("After offer(null). Elements: "+q); 
		System.out.println("\n--- Delete Operation: ---");
		q.poll();
		System.out.println("After poll(). Elements: "+q); 
		q.remove();
		System.out.println("After remove(). Elements: "+q); 
		System.out.println("\n--- Examine Operation: ---");
		// returns null if queue is empty.
		System.out.println("q.peek(): "+q.peek());
		//throws NoSuchElementException if queue is empty
		System.out.println("q.element(): "+q.element());
		
		System.out.println("\n--- Iterator Operation: ---");
		Iterator<Integer> itr = q.iterator();
		//q.remove(); //throws ConcurrentModificationException
		while(itr.hasNext()){
			System.out.print(itr.next()+" -> ");
		}
		
	}

}

package com.javaworld.A4_Advanced_Java._1_Collections.A0_Introduction;

/**
 * @author Shaik Khader
 * 
 *         . Usually pronounced as deck, a deque is a double-ended-queue. A
 *         double-ended-queue is a linear collection of elements that supports
 *         the insertion and removal of elements at both end points. The Deque
 *         interface is a richer abstract data type than both Stack and Queue
 *         because it implements both stacks and queues at the same time.The
 *         Deque interface, defines methods to access the elements at both ends
 *         of the Deque instance. Methods are provided to insert, remove, and
 *         examine the elements. Predefined classes like ArrayDeque and
 *         LinkedList implement the Deque interface. Note that the Deque
 *         interface can be used both as last-in-first-out stacks and
 *         first-in-first-out queues. The methods given in the Deque interface
 *         are divided into three parts:
 * 
 *         - Insert: The addfirst and offerFirst methods insert elements at the
 *         beginning of the Deque instance. The methods addLast and offerLast
 *         insert elements at the end of the Deque instance. When the capacity
 *         of the Deque instance is restricted, the preferred methods are
 *         offerFirst and offerLast because addFirst might fail to throw an
 *         exception if it is full.
 * 
 *         - Remove: The removeFirst and pollFirst methods remove elements from
 *         the beginning of the Deque instance. The removeLast and pollLast
 *         methods remove elements from the end. The methods pollFirst and
 *         pollLast return null if the Deque is empty whereas the methods
 *         removeFirst and removeLast throw an exception if the Deque instance
 *         is empty.
 * 
 *         - Retrieve: The methods getFirst and peekFirst retrieve the first
 *         element of the Deque instance. These methods dont remove the value
 *         from the Deque instance. Similarly, the methods getLast and peekLast
 *         retrieve the last element. The methods getFirst and getLast throw an
 *         exception if the deque instance is empty whereas the methods
 *         peekFirst and peekLast return null.
 * 
 *         . The deque_methods.png shows 12 methods for insertion, removal and
 *         retieval of Deque elements.
 * 
 *         . In addition to these basic methods to insert,remove and examine a
 *         Deque instance, the Deque interface also has some more predefined
 *         methods. One of these is removeFirstOccurence, this method removes
 *         the first occurence of the specified element if it exists in the
 *         Deque instance. If the element does not exist then the Deque instance
 *         remains unchanged. Another similar method is removeLastOccurence;
 *         this method removes the last occurence of the specified element in
 *         the Deque instance. The return type of these methods is boolean, and
 *         they return true if the element exists in the Deque instance.
 * 
 * 
 */

public class A5_Deque_Interface {
	public static void main(String... args) {

	}

}

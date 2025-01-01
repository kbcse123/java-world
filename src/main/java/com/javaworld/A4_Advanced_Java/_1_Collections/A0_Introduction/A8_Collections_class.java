package com.javaworld.A4_Advanced_Java._1_Collections.A0_Introduction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Shaik Khader
 * 
 *	. This class consists exclusively of static methods that operate on or return collections. It contains polymorphic
 *	  algorithms that operate on collections, "wrappers", which return a new collection backed by a specified collection. 
 * 	. The methods of this class all throw a NullPointerException if the collections or class objects provided to them
 * 	  are null.
 * 	. The "destructive" algorithms contained in this class, that is, the algorithms that modify the collection on which
 *    they operate, are specified to throw UnsupportedOperationException if the collection does not support the 
 *    appropriate mutation primitive(s), such as the set method. These algorithms may, but are not required to, throw 
 *    this exception if an invocation would have no effect on the collection. For example, invoking the sort method on 
 *    an unmodifiable list that is already sorted may or may not throw UnsupportedOperationException.
 * 
 * 
 */

public class A8_Collections_class {
	public static void main(String... args) {
		List fruits = new ArrayList();
		Collections.addAll(fruits, "Apples", "Oranges", "Banana");
		fruits.forEach(System.out::println);
		
		Collections.sort(fruits);
		System.out.println("Sorted according to natural ordering:");
		fruits.forEach(System.out::println);
		Collections.sort(fruits, Comparator.reverseOrder());
		System.out.println("Sorted according to reverse of natural ordering:");
		fruits.forEach(System.out::println);
		
		Deque deque = new LinkedList();
		deque.addFirst("Apples");
		deque.add("Oranges");
		deque.addLast("Bananas");
		Queue queue = Collections.asLifoQueue(deque);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		
		Collections.sort(fruits);
		System.out.println(Collections.binarySearch(fruits, "Banana"));
		System.out.println(Collections.binarySearch(fruits, "Grapes"));
		
		List list = new ArrayList();
		Collections.addAll(list, "one", "two", "three", "four");
		Collection checkedList = Collections.checkedCollection(list, String.class);
		System.out.println("Checked list content: " + checkedList);
		//we can add any type of element to list
		list.add(10);
		//we cannot add any type of elements to chkList, doing so
		//throws ClassCastException
		checkedList.add(10); 

		Collections.copy(list, fruits);
		list.forEach(System.out::println);
		
		System.out.println(Collections.disjoint(list, fruits));
		List vegetables = new ArrayList();
		Collections.addAll(vegetables, "Potato", "Cabbage");
		System.out.println(Collections.disjoint(vegetables, fruits));
		System.out.println(Collections.disjoint(vegetables, vegetables));
		System.out.println(Collections.disjoint(new ArrayList(), new ArrayList()));

		Collections.fill(list, "filled with dummy data");
		list.forEach(System.out::println);

		System.out.println(Collections.frequency(list, "filled with dummy data"));
		
		List fruitsSubList1 = new ArrayList();
		Collections.addAll(fruitsSubList1, "Oranges", "Banana");
		System.out.println(Collections.indexOfSubList(fruits, fruitsSubList1));
		List fruitsSubList2 = new ArrayList();
		Collections.addAll(fruitsSubList2, "Kiwi", "Pinapple");
		System.out.println(Collections.indexOfSubList(fruits, fruitsSubList2));
		
		System.out.println(Collections.max(fruits));
		
		Collection<String> synchronizedCollection = 
		Collections.synchronizedCollection(fruits);
		List<String> synchronizedList = Collections.synchronizedList(fruits);

		
		
		
		
		
	}

}

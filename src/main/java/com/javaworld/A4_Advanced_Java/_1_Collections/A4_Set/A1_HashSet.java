package com.javaworld.A4_Advanced_Java._1_Collections.A4_Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Shaik Khader
 * 
 *         This class implements the Set interface, backed by a HashMap
 *         instance. It makes no guarantees as to the iteration order of the
 *         set; in particular, it does not guarantee that the order will remain
 *         constant over time. This class permits the null element.
 * 
 *         This class offers constant time performance for the basic operations
 *         (add, remove, contains and size), assuming the hash function
 *         disperses the elements properly among the buckets. Iterating over
 *         this set requires time proportional to the sum of the HashSet
 *         instance's size (the number of elements) plus the "capacity" of the
 *         backing HashMap instance (the number of buckets). Thus, it's very
 *         important not to set the initial capacity too high (or the load
 *         factor too low) if iteration performance is important.
 * 
 *         Note that this implementation is not synchronized. If multiple
 *         threads access a hash set concurrently, and at least one of the
 *         threads modifies the set, it must be synchronized externally. This is
 *         typically accomplished by synchronizing on some object that naturally
 *         encapsulates the set. If no such object exists, the set should be
 *         "wrapped" using the Collections.synchronizedSet method. This is best
 *         done at creation time, to prevent accidental unsynchronized access to
 *         the set:
 * 
 *         Set s = Collections.synchronizedSet(new HashSet(...));
 *         
 *         The iterators returned by this class's iterator method are fail-fast.
 * 
 * 
 */

public class A1_HashSet {
	public static void main(String... args) {
		Set<Integer> hs = new HashSet<>();
		System.out.println("--- Insert Operation ---");
		hs.add(3);
		hs.add(1);
		hs.add(null);
		hs.add(2);
		hs.add(8);
		hs.add(3);//duplicate
		hs.add(4);
		
		System.out.println(hs); 
		System.out.println("\n--- Search Operation ---");
		System.out.println("hs.contains(4): "+hs.contains(4)); 
		
		System.out.println("\n--- Delete Operation ---");
		hs.remove(3);
		System.out.println("\n--- Iterator Operation: ---");
		Iterator<Integer> itr = hs.iterator();
		//hs.remove(); //throws ConcurrentModificationException
		System.out.print("{");
		while(itr.hasNext()){
			System.out.print(itr.next()+", ");
		}
		System.out.println("}");
		
		
	}

}

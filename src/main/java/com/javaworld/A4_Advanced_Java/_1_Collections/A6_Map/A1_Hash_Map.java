package com.javaworld.A4_Advanced_Java._1_Collections.A6_Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Shaik Khader
 * 
 *         Hash table based implementation of the Map interface. This
 *         implementation provides all of the optional map operations, and
 *         permits null values and the null key. (The HashMap class is roughly
 *         equivalent to Hashtable, except that it is unsynchronized and permits
 *         nulls.) This class makes no guarantees as to the order of the map; in
 *         particular, it does not guarantee that the order will remain constant
 *         over time.
 * 
 *         This implementation provides constant-time performance for the basic
 *         operations (get and put), assuming the hash function disperses the
 *         elements properly among the buckets. Iteration over collection views
 *         requires time proportional to the "capacity" of the HashMap instance
 *         (the number of buckets) plus its size (the number of key-value
 *         mappings). Thus, it's very important not to set the initial capacity
 *         too high (or the load factor too low) if iteration performance is
 *         important.
 * 
 *         An instance of HashMap has two parameters that affect its
 *         performance: initial capacity and load factor. The capacity is the
 *         number of buckets in the hash table, and the initial capacity is
 *         simply the capacity at the time the hash table is created. The load
 *         factor is a measure of how full the hash table is allowed to get
 *         before its capacity is automatically increased. When the number of
 *         entries in the hash table exceeds the product of the load factor and
 *         the current capacity, the hash table is rehashed (that is, internal
 *         data structures are rebuilt) so that the hash table has approximately
 *         twice the number of buckets.
 * 
 *         As a general rule, the default load factor (.75) offers a good
 *         tradeoff between time and space costs. Higher values decrease the
 *         space overhead but increase the lookup cost (reflected in most of the
 *         operations of the HashMap class, including get and put). The expected
 *         number of entries in the map and its load factor should be taken into
 *         account when setting its initial capacity, so as to minimize the
 *         number of rehash operations. If the initial capacity is greater than
 *         the maximum number of entries divided by the load factor, no rehash
 *         operations will ever occur.
 * 
 *         If many mappings are to be stored in a HashMap instance, creating it
 *         with a sufficiently large capacity will allow the mappings to be
 *         stored more efficiently than letting it perform automatic rehashing
 *         as needed to grow the table. Note that using many keys with the same
 *         hashCode() is a sure way to slow down performance of any hash table.
 *         To ameliorate impact, when keys are Comparable, this class may use
 *         comparison order among keys to help break ties.
 * 
 *         Note that this implementation is not synchronized. If multiple
 *         threads access a hash map concurrently, and at least one of the
 *         threads modifies the map structurally, it must be synchronized
 *         externally. (A structural modification is any operation that adds or
 *         deletes one or more mappings; merely changing the value associated
 *         with a key that an instance already contains is not a structural
 *         modification.) This is typically accomplished by synchronizing on
 *         some object that naturally encapsulates the map. If no such object
 *         exists, the map should be "wrapped" using the
 *         Collections.synchronizedMap method. This is best done at creation
 *         time, to prevent accidental unsynchronized access to the map:
 * 
 *         Map m = Collections.synchronizedMap(new HashMap(...));
 * 
 *         The iterators returned by all of this class's
 *         "collection view methods" are fail-fast: if the map is structurally
 *         modified at any time after the iterator is created, in any way except
 *         through the iterator's own remove method, the iterator will throw a
 *         ConcurrentModificationException. Thus, in the face of concurrent
 *         modification, the iterator fails quickly and cleanly, rather than
 *         risking arbitrary, non-deterministic behavior at an undetermined time
 *         in the future.
 * 
 * 
 * 
 * 
 */


public class A1_Hash_Map {
	public static void main(String... args) {
		Map<Integer,String> m = new HashMap<>();
		m.put(1,"one");
		m.put(2,"two");
		m.put(3,"three");
		m.put(4,"four");
		//only 1 null key can be added
		m.put(null,"null1");
		m.put(null,"null2"); //this will override the above
		//multiple null values is allowed
		m.put(5,null);
		m.put(6,null);
		m.put(7,"seven1");
		m.put(7,"seven2");//this will override the above
		m.putIfAbsent(8, "Eight1");
		m.putIfAbsent(8, "Eight2");//this will not be added
		System.out.println("m.get(4)= "+m.get(4));
		System.out.println("m.remove(4)= "+m.remove(4));
		System.out.println("m.remove(3, 'four')= "+m.remove(3, "four"));
		System.out.println("m.containsKey(3)= "+m.containsKey(3));
		System.out.println("m.containsKey(4)= "+m.containsKey(4));
		System.out.println("m.containsValue('two')= "+m.containsValue("two"));
		System.out.println("m.containsValue('zero')= "+m.containsValue("zero"));
		System.out.println("m.getOrDefault(8,'Not Present')= "+m.getOrDefault(8,"Not Present"));
		System.out.println("m.getOrDefault(11,'Not Present')= "+m.getOrDefault(11,"Not Present"));
		//Replaces the entry for the specified key only if it is currently mapped to some value.
		m.replace(2, "TWO");
		System.out.println("m.replace(2, 'TWO')= "+m.get(2));
		m.replace(12, "TWELVE");// does not reflect
		System.out.println("m.replace(12, 'TWELVE')= "+m.get(12));
		//Replaces the entry for the specified key only if currently mapped to the specified value.
		m.replace(3, "Nope", "THREE");
		System.out.println("m.replace(3, 'Nope', 'THREE')= "+m.get(3));
		viewMap(m);
		
	}

	private static void viewMap(Map<Integer, String> m) {
		System.out.println("\n**** keySet() ****");
		for (Integer key : m.keySet())
			System.out.println(key);

		System.out.println("\n**** values() ****");
		for (String value : m.values())
			System.out.println(value);

		System.out.println("\n**** entrySet() ****");
		for (Map.Entry<Integer,String> e : m.entrySet())
			System.out.println("<"+e.getKey() + "," + e.getValue()+">");

		System.out.println("\n**** iterator() ****");
		for (Iterator<Entry<Integer, String>> entryIt = m.entrySet().iterator(); entryIt.hasNext();) 
			System.out.println(entryIt.next());

	}

	private static void printMap(Map<Integer, String> m) {
		
		for (Map.Entry<Integer,String> e : m.entrySet())
			System.out.println(e.getKey() + ": " + e.getValue());

	}

}

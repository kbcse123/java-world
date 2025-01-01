package com.javaworld.A4_Advanced_Java._2_Concurrency.A6_Map;
/**
 * 
 */

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * .A hash table implementation supporting full concurrency on retrievals and
 * insertions/updates.Even though all operations are thread-safe, retrieval
 * operations do not entail locking. Retrieval operations (including get)
 * generally do not block, so may overlap with update operations (including put
 * and remove). Retrievals reflect the results of the most recently completed
 * update operations holding upon their onset.
 * 
 * .Iterators, Spliterators and Enumerations do not throw
 * ConcurrentModificationException.However, iterators are designed to be used by
 * only one thread at a time. see below example
 * ConcurrentMapIterationUsingIterator.
 * 
 * .The table is dynamically expanded when there are too many collisions (i.e.,
 * keys that have distinct hash codes but fall into the same slot modulo the
 * table size). When possible, it is a good idea to provide a size estimate as
 * an optional initialCapacity constructor argument. An additional optional
 * loadFactor constructor argument provides a further means of customizing
 * initial table capacity by specifying the table density to be used in
 * calculating the amount of space to allocate for the given number of elements.
 * Also, for compatibility with previous versions of this class, constructors
 * may optionally specify an expected concurrencyLevel as an additional hint for
 * internal sizing.
 * 
 * .Like Hashtable but unlike HashMap, this class does not allow null to be used
 * as a key or value.
 * 
 * 
 * 
 * 
 * 
 * 
 * @author Shaik Khader
 */

public class A6_ConcurrentHashMap {
	public static void main(String... args) {
		// new ConcurrentMapIterationWithOutIterator().runThreads();
		new ConcurrentMapIterationUsingIterator().runThreads();

		// weaklyConsistentIterator();
	}

	private static void weaklyConsistentIterator() {
		Map<String, Integer> map = new ConcurrentHashMap<>();

		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		map.put("Four", 4);
		map.put("Five", 5);
		map.put("Six", 6);
		map.put("Seven", 7);
		map.put("Eight", 8);
		map.put("Nine", 9);
		map.put("Ten", 10);

		Iterator<String> itr = map.keySet().iterator();
		System.out.println("before. size = " + map.size());

		while (itr.hasNext()) {
			String key = itr.next();
			if (key.equals("Four")) {
				System.out.println(key + " Removed...");
				itr.remove();
				map.put("**New Entry 1**", 0);
				map.put("**New Entry 2**", 0);
			} else {
				System.out.println(key);
			}

		}
		System.out.println("After. size = " + map.size());
	}
}

class ConcurrentMapIterationWithOutIterator {
	private final Map<String, String> map = new ConcurrentHashMap<String, String>();

	private final static int MAP_SIZE = 1000;

	private final ExecutorService executor = Executors.newCachedThreadPool();

	public ConcurrentMapIterationWithOutIterator() {
		for (int i = 0; i < MAP_SIZE; i++) {
			map.put("key" + i, UUID.randomUUID().toString());
		}
	}

	private final class Accessor implements Runnable {
		private final Map<String, String> map;

		public Accessor(Map<String, String> map) {
			this.map = map;
		}

		@Override
		public void run() {
			for (Map.Entry<String, String> entry : this.map.entrySet()) {
				System.out.println(
						Thread.currentThread().getName() + " - [" + entry.getKey() + ", " + entry.getValue() + ']');
			}
		}
	}

	private final class Mutator implements Runnable {

		private final Map<String, String> map;
		private final Random random = new Random();

		public Mutator(Map<String, String> map) {
			this.map = map;
		}

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				this.map.remove("key" + random.nextInt(MAP_SIZE));
				this.map.put("key" + random.nextInt(MAP_SIZE), UUID.randomUUID().toString());
				System.out.println(Thread.currentThread().getName() + ": " + i);
			}
		}
	}

	void runThreads() {
		Accessor a1 = new Accessor(this.map);
		Accessor a2 = new Accessor(this.map);
		Mutator m = new Mutator(this.map);

		executor.execute(a1);
		executor.execute(m);
		executor.execute(a2);
	}
}

class ConcurrentMapIterationUsingIterator {
	private final Map<String, String> map = new ConcurrentHashMap<String, String>();
	private final Iterator<Map.Entry<String, String>> iterator;

	private final static int MAP_SIZE = 100000;

	public ConcurrentMapIterationUsingIterator() {
		for (int i = 0; i < MAP_SIZE; i++) {
			map.put("key" + i, UUID.randomUUID().toString());
		}
		this.iterator = this.map.entrySet().iterator();
	}

	private final ExecutorService executor = Executors.newCachedThreadPool();

	private final class Accessor implements Runnable {
		private final Iterator<Map.Entry<String, String>> iterator;

		public Accessor(Iterator<Map.Entry<String, String>> iterator) {
			this.iterator = iterator;
		}

		@Override
		public void run() {
			while (iterator.hasNext()) {
				Map.Entry<String, String> entry = iterator.next();
				try {
					String st = Thread.currentThread().getName() + " - [" + entry.getKey() + ", " + entry.getValue()
							+ ']';
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}

	private final class Mutator implements Runnable {

		private final Random random = new Random();

		private final Iterator<Map.Entry<String, String>> iterator;

		private final Map<String, String> map;

		public Mutator(Map<String, String> map, Iterator<Map.Entry<String, String>> iterator) {
			this.map = map;
			this.iterator = iterator;
		}

		@Override
		public void run() {
			while (iterator.hasNext()) {
				try {
					iterator.remove();
					this.map.put("key" + random.nextInt(MAP_SIZE), UUID.randomUUID().toString());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}
	}

	void runThreads() {
		Accessor a1 = new Accessor(this.iterator);
		Accessor a2 = new Accessor(this.iterator);
		Mutator m = new Mutator(map, this.iterator);

		executor.execute(a1);
		executor.execute(m);
		executor.execute(a2);
	}
}

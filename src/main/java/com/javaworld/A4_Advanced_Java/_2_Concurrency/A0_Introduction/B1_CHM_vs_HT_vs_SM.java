package com.javaworld.A4_Advanced_Java._2_Concurrency.A0_Introduction;
/**
 * 
 */

/**
 * 
 * @author Shaik Khader
 *
 * 
 * 
 *         Though all three collection classes are thread-safe and can be used
 *         in multi-threaded, concurrent Java application, there is a
 *         significant difference between them, which arise from the fact that
 *         how they achieve their thread-safety.
 * 
 *         Hashtable is a legacy class from JDK 1.1 itself, which uses
 *         synchronized methods to achieve thread-safety. All methods of
 *         Hashtable are synchronized which makes them quite slow due to
 *         contention if a number of thread increases.
 * 
 *         Synchronized Map is also not very different than Hashtable and
 *         provides similar performance in concurrent Java programs. The only
 *         difference between Hashtable and Synchronized Map is that later is
 *         not a legacy and you can wrap any Map to create it's synchronized
 *         version by using Collections.synchronizedMap() method.
 * 
 *         On the other hand, ConcurrentHashMap is specially designed for
 *         concurrent use i.e. more than one thread. By default it
 *         simultaneously allows 16 threads to read and write from Map without
 *         any external synchronization. It is also very scalable because of
 *         stripped locking technique used in the internal implementation of
 *         ConcurrentHashMap class. Unlike Hashtable and Synchronized Map, it
 *         never locks whole Map, instead, it divides the map into segments and
 *         locking is done on those. Though it performs better if a number of
 *         reader threads are greater than the number of writer threads.
 *
 * 
 * 
 *         https://crunchify.com/hashmap-vs-concurrenthashmap-vs-synchronizedmap-how-a-hashmap-can-be-synchronized-in-java/
 * 
 */

public class B1_CHM_vs_HT_vs_SM {
	public static void main(String... args) {

	}

}

package com.javaworld.A4_Advanced_Java._2_Concurrency.A8_BlockingQueue;

/**
 * An unbounded blocking queue of Delayed elements, in which an element can only be taken when its delay
 * has expired. The head of the queue is that Delayed element whose delay expired furthest in the past.
 * 
 * If no delay has expired there is no head and poll will return null. Expiration occurs when an
 * element's getDelay(TimeUnit.NANOSECONDS) method returns a value less than or equal to zero.
 * 
 * Even though unexpired elements cannot be removed using take or poll, they are otherwise treated as
 * normal elements. For example, the size method returns the count of both expired and unexpired
 * elements. This queue does not permit null elements.
 * 
 * 
 * @author Shaik Khader
 * 
 */

public class A6_DelayQueue {
	public static void main(String... args) {
		//BlockingQueue<String> bq = new DelayQueue<>(new ArrayList<>());

	}

}

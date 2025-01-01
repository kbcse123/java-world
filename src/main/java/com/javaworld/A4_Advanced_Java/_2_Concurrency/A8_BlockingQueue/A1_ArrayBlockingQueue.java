package com.javaworld.A4_Advanced_Java._2_Concurrency.A8_BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Shaik Khader
 * 
 *         A bounded blocking queue backed by an array. This queue orders
 *         elements FIFO (first-in-first-out). The head of the queue is that
 *         element that has been on the queue the longest time. The tail of the
 *         queue is that element that has been on the queue the shortest time.
 *         New elements are inserted at the tail of the queue, and the queue
 *         retrieval operations obtain elements at the head of the queue.
 * 
 *         This is a classic "bounded buffer", in which a fixed-sized array
 *         holds elements inserted by producers and extracted by consumers. Once
 *         created, the capacity cannot be changed. Attempts to put an element
 *         into a full queue will result in the operation blocking; attempts to
 *         take an element from an empty queue will similarly block.
 * 
 *         This class supports an optional fairness policy for ordering waiting
 *         producer and consumer threads. By default, this ordering is not
 *         guaranteed. However, a queue constructed with fairness set to true
 *         grants threads access in FIFO order. Fairness generally decreases
 *         throughput but reduces variability and avoids starvation.
 * 
 * 
 */

public class A1_ArrayBlockingQueue {
	public static void main(String... args) {
		BlockingQueue<String> bq = new ArrayBlockingQueue<>(0);
	    
	}

}

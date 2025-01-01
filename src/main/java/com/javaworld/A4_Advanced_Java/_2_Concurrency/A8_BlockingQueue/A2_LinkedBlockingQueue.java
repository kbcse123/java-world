package com.javaworld.A4_Advanced_Java._2_Concurrency.A8_BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Shaik Khader
 * 
 *         An optionally-bounded blocking queue based on linked nodes. This
 *         queue orders elements FIFO (first-in-first-out). The head of the
 *         queue is that element that has been on the queue the longest time.
 *         The tail of the queue is that element that has been on the queue the
 *         shortest time. New elements are inserted at the tail of the queue,
 *         and the queue retrieval operations obtain elements at the head of the
 *         queue. Linked queues typically have higher throughput than
 *         array-based queues but less predictable performance in most
 *         concurrent applications.
 * 
 *         The optional capacity bound constructor argument serves as a way to
 *         prevent excessive queue expansion. The capacity, if unspecified, is
 *         equal to Integer.MAX_VALUE. Linked nodes are dynamically created upon
 *         each insertion unless this would bring the queue above capacity.
 * 
 * 
 * 
 * 
 */

public class A2_LinkedBlockingQueue {
	public static void main(String... args) {
		BlockingQueue<String> bq = new LinkedBlockingQueue<>();
	    
	}

}

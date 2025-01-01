package com.javaworld.A4_Advanced_Java._2_Concurrency.A8_BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author Shaik Khader
 * 
 *         SynchronousQueue is a very special kind of queue - it implements a
 *         rendezvous approach (producer waits until consumer is ready, consumer
 *         waits until producer is ready) behind the interface of Queue.
 * 
 *         Therefore you may need it only in the special cases when you need
 *         that particular semantics, for example, Single threading a task
 *         without queuing further requests.
 * 
 *         Another reason for using SynchronousQueue is performance.
 *         Implementation of SynchronousQueue seems to be heavily optimized, so
 *         if you don't need anything more than a rendezvous point (as in the
 *         case of Executors.newCachedThreadPool(), where consumers are created
 *         "on-demand", so that queue items don't accumulate), you can get a
 *         performance gain by using SynchronousQueue.
 * 
 *         Simple synthetic test shows that in a simple single producer - single
 *         consumer scenario on dual-core machine throughput of SynchronousQueue
 *         is ~20 time higher that throughput of LinkedBlockingQueue and
 *         ArrayBlockingQueue with queue length = 1. When queue length is
 *         increased, their throughput rises and almost reaches throughput of
 *         SynchronousQueue. It means that SynchronousQueue has low
 *         synchronization overhead on multi-core machines compared to other
 *         queues. But again, it matters only in specific circumstances when you
 *         need a rendezvous point disguised as Queue.
 * 
 *         A blocking queue in which each insert operation must wait for a
 *         corresponding remove operation by another thread, and vice versa. A
 *         synchronous queue does not have any internal capacity, not even a
 *         capacity of one. You cannot peek at a synchronous queue because an
 *         element is only present when you try to remove it; you cannot insert
 *         an element (using any method) unless another thread is trying to
 *         remove it; you cannot iterate as there is nothing to iterate. The
 *         head of the queue is the element that the first queued inserting
 *         thread is trying to add to the queue; if there is no such queued
 *         thread then no element is available for removal and poll() will
 *         return null. For purposes of other Collection methods (for example
 *         contains), a SynchronousQueue acts as an empty collection. This queue
 *         does not permit null elements.
 * 
 *         Synchronous queues are similar to rendezvous channels used in CSP and
 *         Ada. They are well suited for hand-off designs, in which an object
 *         running in one thread must sync up with an object running in another
 *         thread in order to hand it some information, event, or task.
 * 
 *         This class supports an optional fairness policy for ordering waiting
 *         producer and consumer threads. By default, this ordering is not
 *         guaranteed. However, a queue constructed with fairness set to true
 *         grants threads access in FIFO order.
 * 
 *         This class and its iterator implement all of the optional methods of
 *         the Collection and Iterator interfaces.
 * 
 * 
 *         Use cases:
 * 
 *         When several threads produce objects for the queue faster than
 *         consumers can consume and process them - a queue can overgrow in
 *         size. SynchronousQueue helps to control communication without any
 *         specific code in producers.
 * 
 *         The case where SynchronousQueue can be used is in "pipelining"
 *         scenarios. Let's say that you have a processing pipeline of stages
 *         where some data block gets handed down the pipeline starting with a
 *         "producer" and ending up with a "consumer". Assuming all of the
 *         stages are somewhat deterministic, having an actual queue is
 *         overkill. All you need is a hand-off between the stages. This is
 *         important if the data blocks are large, because you don't want to
 *         create too many of them. This is analogous to the old
 *         "double buffering" strategies.
 * 
 *         A really concrete example is database loader. Suppose you want to
 *         scan a delimited text file and load into a database. You have two
 *         stages -- one that scans the file and produces blocks of "records"
 *         for insertion (the record block could be a two-dimensional array of
 *         Objects), and one that calls JDBC for record insertion, each block
 *         getting its own transaction/batch. These things overlap very nicely.
 * 
 * 
 * 
 * 
 */

public class A7_SynchronousQueue {
	public static void main(String... args) {
		BlockingQueue<String> bq = new SynchronousQueue<>();
	}

}

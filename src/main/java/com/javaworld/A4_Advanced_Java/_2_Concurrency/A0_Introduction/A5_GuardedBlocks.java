
package com.javaworld.A4_Advanced_Java._2_Concurrency.A0_Introduction;

import java.util.Random;

/**
 * 
 * @author Shaik Khader
 * 
 *         Guarded Blocks:
 * 
 * 
 * 
 *         Threads often have to coordinate their actions. The most common
 *         coordination idiom is the guarded block. Such a block begins by
 *         polling a condition that
 * 
 *         must be true before the block can proceed. There are a number of
 *         steps to follow in order to do this correctly.
 * 
 * 
 * 
 *         Suppose, for example guardedJoy is a method that must not proceed
 *         until a shared variable joy has been set by another thread. Such a
 *         method could, in
 * 
 *         theory, simply loop until the condition is satisfied, but that loop
 *         is wasteful, since it executes continuously while waiting.
 * 
 * 
 * 
 *         public void guardedJoy() {
 * 
 *         // Simple loop guard. Wastes
 * 
 *         // processor time. Don't do this!
 * 
 *         while(!joy) {}
 * 
 *         System.out.println("Joy has been achieved!");
 * 
 *         }
 * 
 * 
 * 
 *         A more efficient guard invokes Object.wait to suspend the current
 *         thread. The invocation of wait does not return until another thread
 *         has issued a
 * 
 *         notification that some special event may have occurred - though not
 *         necessarily the event this thread is waiting for:
 * 
 * 
 * 
 *         public synchronized void guardedJoy() {
 * 
 *         // This guard only loops once for each special event, which may not
 * 
 *         // be the event we're waiting for.
 * 
 *         while(!joy) {
 * 
 *         try {
 * 
 *         wait();
 * 
 *         } catch (InterruptedException e) {}
 * 
 *         }
 * 
 *         System.out.println("Joy and efficiency have been achieved!");
 * 
 *         }
 * 
 * 
 * 
 *         Note: Always invoke wait inside a loop that tests for the condition
 *         being waited for. Don't assume that the interrupt was for the
 *         particular condition you
 * 
 *         were waiting for, or that the condition is still true.
 * 
 * 
 * 
 *         Like many methods that suspend execution, wait can throw
 *         InterruptedException. In this example, we can just ignore that
 *         exception - we only care about the
 * 
 *         value of joy.
 * 
 * 
 * 
 *         Why is this version of guardedJoy synchronized? Suppose d is the
 *         object we're using to invoke wait. When a thread invokes d.wait, it
 *         must own the intrinsic
 * 
 *         lock for d - otherwise an error is thrown. Invoking wait inside a
 *         synchronized method is a simple way to acquire the intrinsic lock.
 * 
 * 
 * 
 *         When wait is invoked, the thread releases the lock and suspends
 *         execution. At some future time, another thread will acquire the same
 *         lock and invoke
 * 
 *         Object.notifyAll, informing all threads waiting on that lock that
 *         something important has happened:
 * 
 * 
 * 
 *         public synchronized notifyJoy() {
 * 
 *         joy = true;
 * 
 *         notifyAll();
 * 
 *         }
 * 
 *         Some time after the second thread has released the lock, the first
 *         thread reacquires the lock and resumes by returning from the
 *         invocation of wait.
 * 
 * 
 * 
 *         Note: There is a second notification method, notify, which wakes up a
 *         single thread. Because notify doesn't allow you to specify the thread
 *         that is woken
 * 
 *         up, it is useful only in massively parallel applications - that is,
 *         programs with a large number of threads, all doing similar chores. In
 *         such an
 * 
 *         application, you don't care which thread gets woken up.
 * 
 * 
 * 
 *         Let's use guarded blocks to create a Producer-Consumer
 *         application.This kind of application shares data between two threads:
 *         the producer, that creates the
 * 
 *         data, and the consumer, that consumes the data. The two threads
 *         communicate using a shared object. Coordination is essential: the
 *         consumer thread must
 * 
 *         not attempt to retrieve the data before the producer thread has
 *         delivered it, and the producer thread must not attempt to deliver new
 *         data if the consumer
 * 
 *         hasn't retrieved the old data.
 * 
 * 
 * 
 */

class Drop {

	private String message;

	private boolean access = true;

	public synchronized String consume() {

		// Wait until message is available.

		while (access) {

			try {

				wait();

			} catch (InterruptedException e) {
			}

		}

		// Toggle status.

		access = true;

		// Notify producer that status has changed.

		notifyAll();

		return message;

	}

	public synchronized void produce(String message) {

		// Wait until message has been retrieved.

		while (!access) {

			try {

				wait();

			} catch (InterruptedException e) {
			}

		}

		// Toggle status.

		access = false;

		// Store message.

		this.message = message;

		System.out.format("MESSAGE SENT: %s%n", message);

		// Notify consumer that status has changed.

		notifyAll();

	}

}

class Producer implements Runnable {

	private Drop drop;

	public Producer(Drop drop) {

		this.drop = drop;

	}

	public void run() {

		String importantInfo[] = {

				"Mohan like Chicken", "Dane like Pork", "Khader like Mutton"

		};

		Random random = new Random();

		for (int i = 0;

		i < importantInfo.length;

		i++) {

			drop.produce(importantInfo[i]);

			try {

				Thread.sleep(random.nextInt(5000));

			} catch (InterruptedException e) {
			}

		}

		System.out.println();

		drop.produce("DONE");

	}

}

class Consumer implements Runnable {

	private Drop drop;

	public Consumer(Drop drop) {

		this.drop = drop;

	}

	public void run() {

		Random random = new Random();

		String message = "";

		while (!(message = drop.consume()).equals("DONE")) {

			System.out.format("MESSAGE RECEIVED: %s%n", message);

			try {

				Thread.sleep(random.nextInt(5000));

			} catch (InterruptedException e) {
			}

		}

		System.out.format("MESSAGE RECEIVED: %s%n", message);

	}

}

class ProducerConsumerExample {

	public static void execute() {

		Drop drop = new Drop();

		Thread producerThread = new Thread(new Producer(drop));

		Thread consumerThread = new Thread(new Consumer(drop));

		producerThread.start();

		consumerThread.start();

	}

}

public class A5_GuardedBlocks {

	public static void main(String... args) {

		ProducerConsumerExample.execute();

	}

}

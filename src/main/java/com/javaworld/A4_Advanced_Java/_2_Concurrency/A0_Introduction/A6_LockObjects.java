package com.javaworld.A4_Advanced_Java._2_Concurrency.A0_Introduction;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Shaik Khader
 * 
 *         Synchronized code relies on a simple kind of reentrant lock. This
 *         kind of lock is easy to use, but has many limitations. More
 *         sophisticated locking idioms are supported by the
 *         java.util.concurrent.locks package. We won't examine this package in
 *         detail, but instead will focus on its most basic interface, Lock.
 * 
 *         Lock objects work very much like the implicit locks used by
 *         synchronized code. As with implicit locks, only one thread can own a
 *         Lock object at a time. Lock objects also support a wait/notify
 *         mechanism, through their associated Condition objects.
 * 
 *         The biggest advantage of Lock objects over implicit locks is their
 *         ability to back out of an attempt to acquire a lock. The tryLock
 *         method backs out if the lock is not available immediately or before a
 *         timeout expires (if specified). The lockInterruptibly method backs
 *         out if another thread sends an interrupt before the lock is acquired.
 * 
 * 
 */

class NumberPrinter implements Runnable {
	private Lock lock;
	private Condition condition;
	private String type;
	private static boolean turn = true;

	public NumberPrinter(String type, Lock lock, Condition condition) {
		this.type = type;
		this.lock = lock;
		this.condition = condition;
	}

	public void run() {
		int i = type.equals("odd") ? 1 : 2;
		while (i <= 20) {
			if (type.equals("odd"))
				printOdd(i);
			else 
				printEven(i);
			
			i = i + 2;
		}
	}

	private void printOdd(int i) {
		lock.lock();
		try {
			if (!turn) {
				condition.await();
			}
			System.out.println(type + " - " + i);
			turn = false;
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	private void printEven(int i) {
		lock.lock();
		try {
			if (turn) {
				condition.await();
			}
			System.out.println(type + " " + i);
			turn = true;
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}

public class A6_LockObjects {

	public static void main(String... args) {
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		Thread odd = new Thread(new NumberPrinter("odd", lock, condition));
		Thread even = new Thread(new NumberPrinter("even", lock, condition));
		odd.start();
		even.start();
	}

}

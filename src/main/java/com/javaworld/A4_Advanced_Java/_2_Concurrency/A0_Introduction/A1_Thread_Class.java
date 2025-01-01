package com.javaworld.A4_Advanced_Java._2_Concurrency.A0_Introduction;
/**
 * 
 * @author Shaik Khader
 *
 * 
 * 
 *         Thread :
 * 
 * 
 * 
 *         A thread is a lightweight process in a program. The Java Virtual
 *         Machine allows an application to have multiple threads of execution
 *         running concurrently.
 * 
 *         Every thread has a priority. Threads with higher priority are
 *         executed in preference to threads with lower priority. Each thread
 *         may or may not also be
 * 
 *         marked as a daemon.
 * 
 *         Defining and Starting a Thread:
 * 
 * 
 * 
 *         An application that creates an instance of Thread must provide the
 *         code that will run in that thread. There are two ways to do this:
 * 
 * 
 * 
 *         .Implement Runnable Interface: The Runnable interface defines a
 *         single method, run, meant to contain the code executed in the thread.
 *         The Runnable
 * 
 *         object is passed to the Thread constructor, see the
 *         ImplementingRunnable example:
 * 
 * 
 * 
 *         .Extend Thread Class: The Thread class itself implements Runnable,
 *         though its run method does nothing. An application can subclass
 *         Thread, providing
 * 
 *         its own implementation of run, see the ExtendingThread example:
 * 
 * 
 * 
 *         Notice that both examples invoke Thread.start in order to start the
 *         new thread.
 * 
 * 
 * 
 *         Which of these idioms should you use?
 * 
 * 
 * 
 *         .The first idiom is more general, because When you implements
 *         Runnable, you can save a space for your class to extend any other
 *         class in future or now.
 * 
 * 
 * 
 *         .The second idiom must be used if you want to override some behavior
 *         of the Thread class. When you extends Thread class, after that you
 *         can-t extend any
 * 
 *         other class which you required. (As you know, Java does not allow
 *         inheriting more than one class).
 * 
 * 
 * 
 *         Note: In most cases, the Runnable interface should be used if you are
 *         only planning to override the run() method and no other Thread
 *         methods. This is important
 * 
 *         because classes should not be subclassed unless the programmer
 *         intends on modifying or enhancing the fundamental behavior of the
 *         class.
 * 
 */

class ImplementingRunnable implements Runnable {

	public void run() {

		System.out.println("Hello from ImplementingRunnable!");

	}

}

class ExtendingThread extends Thread {

	public void run() {

		System.out.println("Hello from ExtendingThread!");

	}

}

public class A1_Thread_Class {

	public static void main(String... args) {

		Thread helloRunnable = new Thread(new ImplementingRunnable());

		helloRunnable.start();

		ExtendingThread helloThread = new ExtendingThread();

		helloThread.start();

	}

}

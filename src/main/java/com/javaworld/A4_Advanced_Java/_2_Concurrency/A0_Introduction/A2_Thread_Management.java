package com.javaworld.A4_Advanced_Java._2_Concurrency.A0_Introduction;

/**
 * 
 * @author Shaik Khader
 * 
 *         The Thread class defines a number of methods useful for thread
 *         management. These include static methods, which provide information
 *         about, or affect the status of, the thread invoking the method. The
 *         other methods are invoked from other threads involved in managing the
 *         thread and Thread object.
 * 
 *         Pausing Execution with Sleep: Thread.sleep causes the current thread
 *         to suspend execution for a specified period. This is an efficient
 *         means of making processor time available to the other threads of an
 *         application or other applications that might be running on a computer
 *         system. The sleep method can also be used for pacing, as shown
 *         in the example that follows, and waiting for another thread with
 *         duties that are understood to have time requirements, as with the
 *         SimpleThreads example in a later section.
 * 
 *         .Two overloaded versions of sleep are provided: one that specifies
 *         the sleep time to the millisecond and one that specifies the sleep
 *         time to the nanosecond. However, these sleep times are not guaranteed to be
 *         precise, because they are limited by the facilities provided by the
 *         underlying OS. Also, the sleep period can be terminated by interrupts, as we'll
 *         see in a later section. In any case, you cannot assume that invoking sleep
 *         will suspend the thread for precisely the time period specified. The below
 *         SleepMessages example uses sleep to print messages at 2-second
 *         intervals:
 * 
 *         Notice that main method declares 'throws InterruptedException', This
 *         is an exception that sleep throws when another thread interrupts the
 *         current thread while sleep is active.
 * 
 *         Interrupts:
 *
 *         .An interrupt is an indication to a thread that it should stop what it is doing and
 *         do something else. It's up to the programmer to decide exactly how a thread
 *         responds to an interrupt, but it is very common for the thread to terminate.
 *         A thread sends an interrupt by invoking interrupt() on the Thread object for the thread
 *         to be interrupted. For the interrupt mechanism to work correctly, the interrupted
 *         thread must support its own interruption.
 * 
 *         Supporting Interruption:
 *
 *         .How does a thread support its own interruption? This depends on what it's currently
 *         doing. If the thread is frequently invoking methods that throw InterruptedException,
 *         it simply returns from the run method after it catches that exception. For example,
 *         suppose the central message loop in the SleepMessages example were in the run method of
 *         a thread's Runnable object. Then it might be modified as follows to support interrupts:
 * 
 *         .Many methods that throw InterruptedException, such as sleep, are designed to cancel
 *         their current operation and return immediately when an interrupt is received.
 *
 *         The Interrupt Status Flag:
 *
 *         .The interrupt mechanism is implemented using an internal flag known as the interrupt
 *         status. Invoking Thread.interrupt sets this flag. When a thread checks for an interrupt
 *         by invoking the static method Thread.interrupted, interrupt status is cleared. The
 *         non-static isInterrupted method, which is used by one thread to query the interrupt
 *         status of another, does not change the interrupt status flag.
 *
 *         .By convention, any method that exits by throwing an InterruptedException clears
 *         interrupt status when it does so. However, it's always possible that interrupt status
 *         will immediately be set again, by another thread invoking interrupt.
 * 
 *         Joins:
 *
 *         .The join method allows one thread to wait for the completion of another. If t is a
 *         Thread object whose thread is currently executing, then t.join(); causes the current
 *         thread to pause execution until t's thread terminates. Overload methods of join allow the
 *         programmer to specify a waiting period. However, as with sleep, join is dependent on the
 *         OS for timing, so you should not assume that join will wait exactly as long as you
 *         specify. Like sleep, join responds to an interrupt by exiting with an InterruptedException.
 *
 *         Note: It is recommended that applications not use wait, notify, or notifyAll on Thread
 *         instances. On a Thread instance, the methods wait(...), notify() and notifyAll()
 *         are available only because all classes in Java extend Object and therefore automatically
 *         inherit the methods. But there are two very good reasons to not call these methods on a
 *         Thread instance:
 * 		        1)Doing so is really confusing. What is really expected when calling, for instance,
 * 		          the wait(...) method on a Thread? That the execution of the Thread is suspended,
 * 		          or that acquisition of the object monitor is waited for?
 * 		        2)Internally, the JVM relies on these methods to change the state of the Thread
 * 		          (BLOCKED, WAITING, ...), so calling them will corrupt the behavior of the JVM.
 * 
 *  Must read:
 *  https://stackoverflow.com/questions/35631955/why-cant-notifyall-be-used-in-a-thread-instance
 *
 *  https://stackoverflow.com/questions/4912165/whats-the-best-alternative-to-wait-notify-for-low-level-synchronization
 * 
 * 
 * 
 */

class SleepMessages implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()+"Who am I ? ");
			String importantInfo[] = {
					"Mohan like Chicken", "Dane like Fish", "Khader like Mutton" };
			for (String str : importantInfo) {
				// Pause for 2 seconds
				Thread.sleep(2000);
				if (Thread.interrupted()) {
					throw new InterruptedException();
				}
				// Print a message
				System.out.println(Thread.currentThread().getName()+str);
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName()+"Thread interrupted! no more messages");
        }
	}

}

public class A2_Thread_Management {

	public static void main(String... args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+" Thread: Who am I ? ");
		Thread thread = new Thread(new SleepMessages(), "SleepMessages Thread: ");
		thread.start();
		// thread.join(); //Waits for this thread until it dies.
		// thread.join(0);// Waits for this thread until it dies.
		thread.join(5000);// Waits at most 5000 milliseconds for this thread to die.
		if (thread.isAlive()) {
			System.out.println(Thread.currentThread().getName()+"Thread: Interrupting the Thread since it has taken more than 5 seconds");
			thread.interrupt();
		}
	}
}

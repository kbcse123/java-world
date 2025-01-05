
package com.javaworld.A4_Advanced_Java._2_Concurrency.A0_Introduction;

/**
 * 
 * @author Shaik Khader
 * 
 *         Synchronization is the tool needed to prevent thread interference and
 *         memory consistency errors.
 * 
 *         However, synchronization can introduce thread contention, which
 *         occurs when two or more threads try to access the same resource
 *         simultaneously and cause the Java runtime to execute one or more
 *         threads more slowly, or even suspend their execution. Starvation and
 *         livelock are forms of thread contention.
 * 
 *         Thread interference:
 * 
 *         it is a condition which occurs when more than one threads, executing
 *         simultaneously, access same piece of data, possibly resulting in data
 *         corruption through sequences of steps overlapping with each other.
 *         See the below example ThreadIntereferenceDemo.unSynchronizedTask() to
 *         understand.
 * 
 *         Memory Consistency Errors:
 * 
 *         Memory consistency errors occur when different threads have
 *         inconsistent views of what should be the same data. The key to
 *         avoiding memory consistency errors is understanding the
 *         happens-before relationship. This relationship is simply a guarantee
 *         that memory writes by one specific statement are visible to another
 *         specific statement. See the below example
 *         ThreadIntereferenceDemo.synchronizedTask() to understand.
 * 
 *         The synchronized and volatile constructs, as well as the
 *         Thread.start() and Thread.join() methods, can form happens-before
 *         relationships.
 * 
 *         Synchronized Methods:
 * 
 *         The Java programming language provides two basic synchronization
 *         idioms: synchronized methods and synchronized statements.
 * 
 *         making these methods synchronized has two effects:
 * 
 *         First, it is not possible for two invocations of synchronized methods
 *         on the same object to interleave. When one thread is executing a
 *         synchronized method for an object, all other threads that invoke
 *         synchronized methods for the same object block (suspend execution)
 *         until the first thread is done with the object.
 * 
 *         Second, when a synchronized method exits, it automatically
 *         establishes a happens-before relationship with any subsequent
 *         invocation of a synchronized method for the same object. This
 *         guarantees that changes to the state of the object are visible to all
 *         threads.
 * 
 *         Note that constructors cannot be synchronized - using the
 *         synchronized keyword with a constructor is a syntax error.
 *         Synchronizing constructors doesn't make sense, because only the
 *         thread that creates an object should have access to it while it is
 *         being constructed.
 * 
 *         Warning: When constructing an object that will be shared between
 *         threads, be very careful that a reference to the object does not
 *         "leak" prematurely. For example, suppose you want to maintain a List
 *         called instances containing every instance of class. You might be
 *         tempted to add the following line to your
 * 
 *         constructor:
 * 
 *         instances.add(this);
 * 
 *         But then other threads can use instances to access the object before
 *         construction of the object is complete.
 * 
 *         Synchronized methods enable a simple strategy for preventing thread
 *         interference and memory consistency errors: if an object is visible
 *         to more than one thread, all reads or writes to that object's
 *         variables are done through synchronized methods. (An important
 *         exception: final fields, which cannot be modified after the object is
 *         constructed, can be safely read through non-synchronized methods,
 *         once the object is constructed) This strategy is effective, but can
 *         present problems with liveness, as we'll see it later.
 * 
 *         Intrinsic Locks and Synchronization:
 * 
 *         Synchronization is built around an internal entity known as the
 *         intrinsic lock or monitor lock. (The API specification often refers
 *         to this entity simply as a "monitor.") Intrinsic locks play a role in
 *         both aspects of synchronization: enforcing exclusive access to an
 *         object's state and establishing happens-before relationships that are
 *         essential to visibility.
 * 
 *         Every object has an intrinsic lock associated with it. By convention,
 *         a thread that needs exclusive and consistent access to an object's
 *         fields has to acquire the object's intrinsic lock before accessing
 *         them, and then release the intrinsic lock when it's done with them. A
 *         thread is said to own the intrinsic lock between the time it has
 *         acquired the lock and released the lock. As long as a thread owns an
 *         intrinsic lock, no other thread can acquire the same lock. The other
 *         thread will block when it attempts to acquire the lock.
 * 
 *         When a thread releases an intrinsic lock, a happens-before
 *         relationship is established between that action and any subsequent
 *         acquisition of the same lock.
 * 
 *         Locks In Synchronized Methods:
 * 
 *         When a thread invokes a synchronized method, it automatically
 *         acquires the intrinsic lock for that method's object and releases it
 *         when the method returns. The lock release occurs even if the return
 *         was caused by an uncaught exception.
 * 
 *         You might wonder what happens when a static synchronized method is
 *         invoked, since a static method is associated with a class, not an
 *         object. In this case, the thread acquires the intrinsic lock for the
 *         Class object associated with the class. Thus access to class's static
 *         fields is controlled by a lock that's distinct from the lock for any
 *         instance of the class.
 * 
 *         Synchronized Statements:
 * 
 *         Another way to create synchronized code is with synchronized
 *         statements. Unlike synchronized methods, synchronized statements must
 *         specify the object that provides the intrinsic lock:
 * 
 *         public void addName(String name) {
 * 
 *         synchronized(this) {
 * 
 *         lastName = name;
 * 
 *         nameCount++;
 * 
 *         }
 * 
 *         nameList.add(name);
 * 
 *         }
 * 
 *         In this example, the addName method needs to synchronize changes to
 *         lastName and nameCount, but also needs to avoid synchronizing
 *         invocations of other objects' methods. (Invoking other object's
 *         methods from synchronized code can create problems that are described
 *         in the section on Liveness.) Without synchronized statements, there
 *         would have to be a separate, unsynchronized method for the sole
 *         purpose of invoking nameList.add.
 * 
 *         Synchronized statements are also useful for improving concurrency
 *         with fine-grained synchronization. Suppose, for example, class
 *         MsLunch has two instance fields, c1 and c2, that are never used
 *         together. All updates of these fields must be synchronized, but
 *         there's no reason to prevent an update of c1 from being interleaved
 *         with an update of c2 - and doing so reduces concurrency by creating
 *         unnecessary blocking. Instead of using synchronized methods or
 *         otherwise using the lock associated with this, we create two objects
 *         solely to provide locks.
 * 
 *         public class MsLunch {
 * 
 *         private long c1 = 0;
 * 
 *         private long c2 = 0;
 * 
 *         private Object lock1 = new Object();
 * 
 *         private Object lock2 = new Object();
 * 
 *         public void inc1() {
 * 
 *         synchronized(lock1) {
 * 
 *         c1++;
 * 
 *         }
 * 
 *         }
 * 
 *         public void inc2() {
 * 
 *         synchronized(lock2) {
 * 
 *         c2++;
 * 
 *         }
 * 
 *         }
 * 
 *         }
 * 
 *         Use this idiom with extreme care. You must be absolutely sure that it
 *         really is safe to interleave access of the affected fields.
 * 
 *         Reentrant Synchronization:
 * 
 *         Recall that a thread cannot acquire a lock owned by another thread.
 *         But a thread can acquire a lock that it already owns. Allowing a
 *         thread to acquire the same lock more than once enables reentrant
 *         synchronization. This describes a situation where synchronized code,
 *         directly or indirectly, invokes a method that also contains
 *         synchronized code, and both sets of code use the same lock. Without
 *         reentrant synchronization, synchronized code would have to take many
 *         additional precautions to avoid having a thread cause itself to
 *         block.
 * 
 *         Atomic Access:
 * 
 *         In programming, an atomic action is one that effectively happens all
 *         at once. An atomic action cannot stop in the middle: it either
 *         happens completely, or it doesn't happen at all. No side effects of
 *         an atomic action are visible until the action is complete.
 * 
 *         We have already seen that an increment expression, such as c++, does
 *         not describe an atomic action. Even very simple expressions can
 *         define complex actions that can decompose into other actions.
 *         However, there are actions you can specify that are atomic:
 * 
 *         .Reads and writes are atomic for reference variables and for most
 *         primitive variables (all types except long and double).
 * 
 *         .Reads and writes are atomic for all variables declared volatile
 *         (including long and double variables).
 * 
 *         Atomic actions cannot be interleaved, so they can be used without
 *         fear of thread interference. However, this does not eliminate all
 *         need to synchronize atomic actions, because memory consistency errors
 *         are still possible.
 * 
 *         Using volatile variables reduces the risk of memory consistency
 *         errors, because any write to a volatile variable establishes a
 *         happens-before relationship with subsequent reads of that same
 *         variable. This means that changes to a volatile variable are always
 *         visible to other threads. What's more, it also means that when a
 *         thread reads a volatile variable, it sees not just the latest change
 *         to the volatile, but also the side effects of the code that led up
 *         the change.
 * 
 *         Using simple atomic variable access is more efficient than accessing
 *         these variables through synchronized code, but requires more care by
 *         the programmer to avoid memory consistency errors. Whether the extra
 *         effort is worthwhile depends on the size and complexity of the
 *         application.
 * 
 *         Some of the classes in the java.util.concurrent package provide
 *         atomic methods that do not rely on synchronization. it will be
 *         discussed in the section on High Level Concurrency Objects.
 * 
 */

class ThreadIntereferenceDemo {
	private Integer counter = 0;
	private static boolean synchronizedCode;
	public static void startDemo(boolean syncCode) throws InterruptedException {
		synchronizedCode = syncCode;
		ThreadIntereferenceDemo demo = new ThreadIntereferenceDemo();
		Task task1 = demo.new Task();
		Thread thread1 = new Thread(task1,"Thread1");
		Task task2 = demo.new Task();
		Thread thread2 = new Thread(task2,"Thread2");
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
	}

	private void unSynchronizedTask() {
		int temp = counter;
		counter++;
		System.out.println(Thread.currentThread()
				.getName() + " - before: " + temp + " after:" + counter);
	}

	private synchronized void synchronizedTask() {
		int temp = counter;
		counter++;
		System.out.println(Thread.currentThread()
				.getName() + " - before: " + temp + " after:" + counter);
	}

	private class Task implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				if (synchronizedCode) {
					synchronizedTask();
				} else {
					unSynchronizedTask();
				}
			}
		}
	}

}

public class A3_Synchronization {
	public static void main(String... args) throws InterruptedException {
		System.out.println("*** Using Non Synchronized ***");
		ThreadIntereferenceDemo.startDemo(false);
		System.out.println("\n*** Using Synchronized ***");
		ThreadIntereferenceDemo.startDemo(true);
	}
}

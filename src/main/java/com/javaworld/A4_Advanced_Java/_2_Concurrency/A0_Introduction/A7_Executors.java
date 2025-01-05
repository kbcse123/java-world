
package com.javaworld.A4_Advanced_Java._2_Concurrency.A0_Introduction;

/**
 * 
 * @author Shaik Khader
 * 
 *         Executors:
 * 
 *         In all the previous examples, there's a close connection between the task being done by a new
 *         thread, as defined by its Runnable object, and the thread itself, as defined by a Thread
 *         object. This works well for small applications, but in large-scale applications, it makes
 *         sense to separate thread management and creation from the rest of the application. Objects
 *         that encapsulate these functions are known as executors. The java.util.concurrent package
 *         defines three executor interfaces:
 * 
 *         1.Executor - a simple interface that supports launching new tasks.
 * 
 *         2.ExecutorService - a subinterface of Executor,which adds features that help manage the
 *         lifecycle,both of the individual tasks and of the executor itself.
 * 
 *         3.ScheduledExecutorService - a subinterface of ExecutorService, supports future and/or periodic
 *         execution of tasks.
 * 
 *         Typically, variables that refer to executor objects are declared as
 *         one of these three interface types, not with an executor class type.
 * 
 *         The Executor Interface provides a single method, execute, designed
 *         to be a drop-in replacement for a common thread-creation idiom. If r
 *         is a Runnable object, and e is an Executor object you can replace
 * 
 *         (new Thread(r)).start(); with e.execute(r);
 * 
 *         However, the definition of execute is less specific. The low-level
 *         idiom creates a new thread and launches it immediately. Depending on
 *         the Executor implementation, execute may do the same thing, but is
 *         more likely to use an existing worker thread to run r, or to place r
 *         in a queue to wait for a worker thread to become available.
 * 
 *         The executor implementations in java.util.concurrent are designed to
 *         make full use of the more advanced ExecutorService and
 *         ScheduledExecutorService interfaces, although they also work with the
 *         base Executor interface.
 * 
 *         The ExecutorService Interface:
 * 
 *         This interface supplements execute with a similar, but more versatile
 *         submit method. Like execute, submit accepts Runnable objects, but
 *         also accepts Callable objects, which allow the task to return a
 *         value. The submit method returns a Future object, which is used to
 *         retrieve the Callable return value and to manage the status of both
 *         Callable and Runnable tasks.
 * 
 *         ExecutorService also provides methods for submitting large
 *         collections of Callable objects. Finally, ExecutorService provides a
 *         number of methods for managing the shutdown of the executor. To
 *         support immediate shutdown, tasks should handle interrupts correctly.
 * 
 *         The ScheduledExecutorService Interface:
 * 
 *         This interface supplements the methods of its parent ExecutorService
 *         with schedule, which executes a Runnable or Callable task after a
 *         specified delay. In addition, the interface defines
 *         scheduleAtFixedRate and scheduleWithFixedDelay, which executes
 *         specified tasks repeatedly, at defined intervals.
 * 
 *         Thread Pools:
 * 
 *         Most of the executor implementations in java.util.concurrent use
 *         thread pools, which consist of worker threads. This kind of thread
 *         exists separately from the Runnable and Callable tasks it executes
 *         and is often used to execute multiple tasks.
 * 
 *         Using worker threads minimizes the overhead due to thread creation.
 *         Thread objects use a significant amount of memory, and in a
 *         large-scale application, allocating and deallocating many thread
 *         objects creates a significant memory management overhead.
 * 
 *         One common type of thread pool is the fixed thread pool. This type of
 *         pool always has a specified number of threads running; if a thread is
 *         somehow terminated while it is still in use, it is automatically
 *         replaced with a new thread. Tasks are submitted to the pool via an
 *         internal queue, which holds extra tasks whenever there are more
 *         active tasks than threads.
 * 
 *         An important advantage of the fixed thread pool is that applications
 *         using it degrade gracefully. To understand this, consider a web
 *         server application where each HTTP request is handled by a separate
 *         thread. If the application simply creates a new thread for every new
 *         HTTP request, and the system receives more requests than it can
 *         handle immediately, the application will suddenly stop responding to
 *         all requests when the overhead of all those threads exceed the
 *         capacity of the system. With a limit on the number of the threads
 *         that can be created, the application will not be servicing HTTP
 *         requests as quickly as they come in, but it will be servicing them as
 *         quickly as the system can sustain.
 * 
 *         A simple way to create an executor that uses a fixed thread pool is
 *         to invoke the newFixedThreadPool factory method in
 *         java.util.concurrent.Executors. This class also provides the
 *         following factory methods:
 * 
 *         .The newCachedThreadPool method creates an executor with an
 *         expandable thread pool. This executor is suitable for applications
 *         that launch many short-lived tasks.
 * 
 *         .The newSingleThreadExecutor method creates an executor that executes
 *         a single task at a time.
 * 
 *         .Several factory methods are ScheduledExecutorService versions of the
 *         above executors.
 * 
 *         If none of the executors provided by the above factory methods meet
 *         your needs,constructing instances of
 *         java.util.concurrent.ThreadPoolExecutor or
 *         java.util.concurrent.ScheduledThreadPoolExecutor will give you
 *         additional options.
 * 
 *         Fork/Join:
 * 
 *         This framework is an implementation of the ExecutorService interface
 *         that helps you take advantage of multiple processors. It is designed
 *         for work that can be broken into smaller pieces recursively. The goal
 *         is to use all the available processing power to enhance the
 *         performance of your application.
 * 
 *         As with any ExecutorService implementation, the fork/join framework
 *         distributes tasks to worker threads in a thread pool. The fork/join
 *         framework is distinct because it uses a work-stealing algorithm.
 *         Worker threads that run out of things to do can steal tasks from
 *         other threads that are still busy.
 * 
 *         The center of the fork/join framework is the ForkJoinPool class, an
 *         extension of the AbstractExecutorService class. ForkJoinPool
 *         implements the core work-stealing algorithm and can execute
 *         ForkJoinTask processes.
 * 
 *         Basic Use:
 * 
 *         The first step for using the fork/join framework is to write code
 *         that performs a segment of the work. Your code should look similar to
 *         the following pseudocode:
 * 
 *         if (my portion of the work is small enough) do the work directly else
 *         split my work into two pieces invoke the two pieces and wait for the
 *         results
 * 
 *         Wrap this code in a ForkJoinTask subclass, typically using one of its
 *         more specialized types, either RecursiveTask (which can return a
 *         result) or RecursiveAction.
 * 
 *         After your ForkJoinTask subclass is ready, create the object that
 *         represents all the work to be done and pass it to the invoke() method
 *         of a ForkJoinPool instance. Blurring for Clarity
 * 
 * 
 * 
 */

public class A7_Executors {

	public static void main(String... args) {

	}

}

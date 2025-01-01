package com.javaworld.A4_Advanced_Java._2_Concurrency.A0_Introduction;

/**
 * 
 * @author Shaik Khader
 * 
 *         Concurrency: means multiple tasks which start, run, and complete in
 *         overlapping time periods, in no specific order. Concurrency is
 *         essentially applicable when
 * 
 *         we talk about minimum two tasks or more. When an application is
 *         capable of executing two or more tasks virtually at same time, we
 *         call it concurrent
 * 
 *         application.
 * 
 * 
 * 
 *         Though here tasks run looks like simultaneously, but essentially they
 *         MAY not. They take advantage of CPU time-slicing feature of operating
 * 
 *         system where each task run part of its task and then go to waiting
 *         state. When first task is in waiting state, CPU is assigned to second
 *         task to complete
 * 
 *         it-s part of task. Operating system assigns CPU and other computing
 *         resources e.g. memory; based on priority of tasks, turn by turn to
 *         all tasks and give
 * 
 *         them chance to complete. To end user, it seems that all tasks are
 *         running in parallel. This is called Concurrency.
 * 
 *         Parallelism: is when multiple tasks OR several parts of a unique task
 *         literally run at the same time, e.g. on a multi-core processor.
 *         Parallelism does not
 * 
 *         require two tasks to exist. It literally physically run parts of
 *         tasks OR multiple tasks, at the same time using multi-core
 *         infrastructure of CPU, by
 * 
 *         assigning one core to each task or sub-task. Parallelism requires
 *         hardware with multiple processing units, essentially. In single core
 *         CPU, you may get concurrency but NOT parallelism.
 * 
 *         Asynchronous methods: This is not related to Concurrency and
 *         Parallelism, asynchrony is used to present the impression of
 *         concurrent or parallel tasking but
 * 
 *         effectively an asynchronous method call is normally used for a
 *         process that needs to do work away from the current application and
 *         we don't want to wait and
 * 
 *         block our application awaiting the response. eg. Sending mail.
 * 
 *         Note: Concurrency and parallelism are NOT the same thing.
 * 
 *         - An application can be concurrent - but not parallel, which means
 *         that it processes more than one task at the same time, but no two
 *         tasks are executing
 * 
 *         at same time instant.
 * 
 *         - An application can be parallel - but not concurrent, which means
 *         that it processes multiple sub-tasks of a task in multi-core CPU at
 *         same time.
 * 
 *         - An application can be neither parallel - nor concurrent, which
 *         means that it processes all tasks one at a time, sequentially.
 * 
 *         - An application can be both parallel - and concurrent, which means
 *         that it processes multiple tasks concurrently in multi-core CPU at
 *         same time.
 * 
 * 
 * 
 *         The Java platform is designed from the ground up to support
 *         concurrent programming.
 * 
 * 
 * 
 *         Processes and Threads:
 * 
 * 
 * 
 *         In concurrent programming, there are two basic units of execution:
 *         processes and threads. In the Java programming language, concurrent
 *         programming is mostly
 * 
 *         concerned with threads. However, processes are also important. It's
 *         becoming more and more common for computer systems to have multiple
 *         processors or
 * 
 *         processors with multiple execution cores. This greatly enhances a
 *         system's capacity for concurrent execution of processes and threads -
 *         but concurrency is
 * 
 *         possible even on simple systems, without multiple processors or
 *         execution cores.
 * 
 * 
 * 
 *         Processes:
 * 
 *         .A process has a self-contained execution environment, resources and
 *         has its own memory space.
 * 
 *         .Processes are often seen as synonymous with programs or
 *         applications. However, what the user sees as a single application may
 *         in fact be a set of
 * 
 *         cooperating processes. To facilitate communication between processes,
 *         most operating systems support Inter Process Communication (IPC)
 *         resources, such
 * 
 *         as pipes and sockets. IPC is used not just for communication between
 *         processes on the same system, but processes on different systems.
 * 
 * 
 * 
 *         .Most implementations of the Java virtual machine run as a single
 *         process. A Java application can create additional processes using a
 *         ProcessBuilder
 * 
 *         object.
 * 
 * 
 * 
 *         Threads:
 * 
 *         .Threads are sometimes called lightweight processes. Both processes
 *         and threads provide an execution environment, but creating a new
 *         thread requires fewer resources than creating a new process.
 * 
 *         .Multithreaded execution is an essential feature of the Java
 *         platform. From the application programmer's point of view, you start
 *         with just one thread, (main thread) and this thread has the ability
 *         to create additional threads.
 * 
 * 
 * 
 *         Limitations of Built-in Synchronization in J2SE 1.4.x :
 * 
 *         When writing multithread applications, the issues that may create
 *         difficulties are related to data synchronization; these are the
 *         errors that make design
 * 
 *         harder, and such errors are hard to detect. Built-in synchronization
 *         (methods and blocks) are fine for many lock-based applications, but
 *         they do have their own limitations, such as:
 * 
 *         .No way to back off from an attempt to acquire a lock that is already
 *         held, or to give up after waiting for a specified period of time, or
 *         to cancel a lock attempt after an interrupt.
 * 
 *         .No way to alter the semantics of a lock, for example, with respect
 *         to reentrancy, read versus write protection, or fairness.
 * 
 *         .No access control for synchronization. Any method can perform
 *         synchronized(obj) for any accessible object.
 * 
 *         .Synchronization is done within methods and blocks, thus limiting use
 *         to strict block-structured locking. In other words, you cannot
 *         acquire a lock in one method and release it in another.
 * 
 *         High Level Concurrency Objects:
 * 
 *         So far, we have focused on the low-level APIs that have been part of
 *         the Java platform from the very beginning. These APIs are adequate
 *         for very basic tasks, but higher-level building blocks are needed for
 *         more advanced tasks. This is especially true for massively concurrent
 *         applications that fully exploit today's multiprocessor and multi-core
 *         systems.
 * 
 *         The java.util.concurrent package in J2SE 5.0 provides classes and
 *         interfaces aiming to simplify the development of concurrent classes
 *         and applications by providing high quality implementations of common
 *         building blocks used in concurrent applications. The package includes
 *         classes optimized for concurrent access.
 * 
 *         In this section we'll look at some of the high-level concurrency
 *         features introduced with version 5.0 of the Java platform. Most of
 *         these features are implemented in the new java.util.concurrent
 *         packages. There are also new concurrent data structures in the Java
 *         Collections Framework.
 * 
 *         .Lock objects - support locking idioms that simplify many concurrent
 *         applications.
 * 
 *         .Executors - define a high-level API for launching and managing
 *         threads. Executor implementations provided by java.util.concurrent
 *         provide thread pool management suitable for large-scale applications.
 * 
 *         .Concurrent collections - make it easier to manage large collections
 *         of data, and can greatly reduce the need for synchronization.
 * 
 *         .Atomic variables - have features that minimize synchronization and
 *         help avoid memory consistency errors.
 * 
 *         .ThreadLocalRandom (in JDK 7) - provides efficient generation of
 *         pseudorandom numbers from multiple threads.
 * 
 *         Note:
 * 
 *         Using the java.util.concurrent package can help you make your
 *         applications shorter, cleaner, faster, more reliable, more scalable,
 *         easier to write and read, and thus easier to maintain. However, it is
 *         important to note that using the package doesn't remove the
 *         responsibility of the developer from ensuring that the applications
 *         are free of deadlock, or CPU starvation. Developers still need to
 *         design their applications with concurrency and data synchronization
 *         issues in mind.
 * 
 *         Must Read:
 *         https://dzone.com/articles/java-concurrency-in-depth-part-1
 * 
 *         http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-
 *         thread-executor-examples/
 * 
 * 
 * 
 */

package com.javaworld.A4_Advanced_Java._2_Concurrency.A8_BlockingQueue;

/**
 * @author Shaik Khader
 * 
 *         A Queue that additionally supports operations that wait for the queue
 *         to become non-empty when retrieving an element, and wait for space to
 *         become available in the queue when storing an element.
 * 
 *         BlockingQueue methods come in four forms, with different ways of
 *         handling operations that cannot be satisfied immediately, but may be
 *         satisfied at some point in the future: one throws an exception, the
 *         second returns a special value (either null or false, depending on
 *         the operation), the third blocks the current thread indefinitely
 *         until the operation can succeed, and the fourth blocks for only a
 *         given maximum time limit before giving up.
 * 
 *         A BlockingQueue does not accept null elements. Implementations throw
 *         NullPointerException on attempts to add, put or offer a null. A null
 *         is used as a sentinel value to indicate failure of poll operations.
 * 
 *         A BlockingQueue may be capacity bounded. At any given time it may
 *         have a remainingCapacity beyond which no additional elements can be
 *         put without blocking. A BlockingQueue without any intrinsic capacity
 *         constraints always reports a remaining capacity of Integer.MAX_VALUE.
 * 
 *         BlockingQueue implementations are designed to be used primarily for
 *         producer-consumer queues, but additionally support the Collection
 *         interface. So, for example, it is possible to remove an arbitrary
 *         element from a queue using remove(x). However, such operations are in
 *         general not performed very efficiently, and are intended for only
 *         occasional use, such as when a queued message is cancelled.
 * 
 *         BlockingQueue implementations are thread-safe. All queuing methods
 *         achieve their effects atomically using internal locks or other forms
 *         of concurrency control. However, the bulk Collection operations
 *         addAll, containsAll, retainAll and removeAll are not necessarily
 *         performed atomically unless specified otherwise in an implementation.
 *         So it is possible, for example, for addAll(c) to fail (throwing an
 *         exception) after adding only some of the elements in c.
 * 
 *         A BlockingQueue does not intrinsically support any kind of "close" or
 *         "shutdown" operation to indicate that no more items will be added.
 *         The needs and usage of such features tend to be
 *         implementation-dependent. For example, a common tactic is for
 *         producers to insert special end-of-stream or poison objects, that are
 *         interpreted accordingly when taken by consumers.
 * 
 *         Note that a BlockingQueue can safely be used with multiple producers
 *         and multiple consumers.
 * 
 *         Memory consistency effects: As with other concurrent collections,
 *         actions in a thread prior to placing an object into a BlockingQueue
 *         happen-before actions subsequent to the access or removal of that
 *         element from the BlockingQueue in another thread.
 * 
 * 
 *         Methods:
 * 
 *         add(E e): Inserts the specified element into this queue if it is
 *         possible to do so immediately without violating capacity
 *         restrictions, returning true upon success and throwing an
 *         IllegalStateException if no space is currently available.
 * 
 *         contains(Object o): Returns true if this queue contains the specified
 *         element.
 * 
 *         drainTo(Collection<? super E> c): Removes all available elements from
 *         this queue and adds them to the given collection.
 * 
 *         drainTo(Collection<? super E> c, int maxElements): Removes at most
 *         the given number of available elements from this queue and adds them
 *         to the given collection.
 * 
 *         offer(E e): Inserts the specified element into this queue if it is
 *         possible to do so immediately without violating capacity
 *         restrictions, returning true upon success and false if no space is
 *         currently available.
 * 
 *         offer(E e, long timeout, TimeUnit unit): Inserts the specified
 *         element into this queue, waiting up to the specified wait time if
 *         necessary for space to become available.
 * 
 *         poll(long timeout, TimeUnit unit): Retrieves and removes the head of
 *         this queue, waiting up to the specified wait time if necessary for an
 *         element to become available.
 * 
 *         put(E e): Inserts the specified element into this queue, waiting if
 *         necessary for space to become available.
 * 
 *         remainingCapacity(): Returns the number of additional elements that
 *         this queue can ideally (in the absence of memory or resource
 *         constraints) accept without blocking, or Integer.MAX_VALUE if there
 *         is no intrinsic limit.
 * 
 *         remove(Object o): Removes a single instance of the specified element
 *         from this queue, if it is present.
 * 
 *         take(): Retrieves and removes the head of this queue, waiting if
 *         necessary until an element becomes available.
 * 
 * 
 *         Methods inherited from interface java.util.Queue:
 * 
 *         element, peek, poll, remove.
 * 
 */

public class A0_BlockingQueue_Interface {
	public static void main(String... args) {

	}

}

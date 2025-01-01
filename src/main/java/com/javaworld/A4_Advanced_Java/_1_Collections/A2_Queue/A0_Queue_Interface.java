package com.javaworld.A4_Advanced_Java._1_Collections.A2_Queue;


import java.util.Random;


/**
 * @author Shaik Khader
 * 
 *         . A Queue is a collection for holding elements prior to processing.
 *         Besides basic Collection operations, queues provide additional
 *         insertion, removal, and inspection operations.
 * 
 *         . Each Queue method exists in two forms: (1) one throws an exception
 *         if the operation fails, and (2) the other returns a special value if
 *         the operation fails (either null or false, depending on the
 *         operation). The regular structure of the interface is illustrated in
 *         the following table.
 * 
 * 			-------------------------------------------------------------
			Type of Operation	Throws exception	Returns special value
			-------------------------------------------------------------
				Insert				add(e)				offer(e)
				Delete				remove()			poll()
				Examine				element()			peek()
 * 
 *         . Queues typically, but not necessarily, order elements in a FIFO
 *         (first-in-first-out) manner. Among the exceptions are priority
 *         queues, which order elements according to their values see the
 *         Object Ordering section for details). Whatever ordering is used, the
 *         head of the queue is the element that would be removed by a call to
 *         remove or poll. In a FIFO queue, all new elements are inserted at the
 *         tail of the queue. Other kinds of queues may use different placement
 *         rules. 
 * 
 *         . It is possible for a Queue implementation to restrict the number of
 *         elements that it holds; such queues are known as bounded. Some Queue
 *         implementations in java.util.concurrent are bounded, but the
 *         implementations in java.util are not.
 * 
 *         . The add method, which Queue inherits from Collection, inserts an
 *         element unless it would violate the queue's capacity restrictions, in
 *         which case it throws IllegalStateException. The offer method, which
 *         is intended solely for use on bounded queues, differs from add only
 *         in that it indicates failure to insert an element by returning false.
 * 
 *         . The remove and poll methods both remove and return the head of the
 *         queue. Exactly which element gets removed is a function of the
 *         queue's ordering policy. The remove and poll methods differ in their
 *         behavior only when the queue is empty. Under these circumstances,
 *         remove throws NoSuchElementException, while poll returns null.
 * 
 *         . The element and peek methods return, but do not remove, the head of
 *         the queue. They differ from one another in precisely the same fashion
 *         as remove and poll: If the queue is empty, element throws
 *         NoSuchElementException, while peek returns null.
 * 
 *         . Queue implementations generally do not allow insertion of null
 *         elements. The LinkedList implementation, which was retrofitted to
 *         implement Queue, is an exception. For historical reasons, it permits
 *         null elements, but you should refrain from taking advantage of this,
 *         because null is used as a special return value by the poll and peek
 *         methods.
 * 
 *         . Queue implementations generally do not define element-based
 *         versions of the equals and hashCode methods but instead inherit the
 *         identity-based versions from Object.
 * 
 *         . The Queue interface does not define the blocking queue methods,
 *         which are common in concurrent programming. These methods, which wait
 *         for elements to appear or for space to become available, are defined
 *         in the interface java.util.concurrent.BlockingQueue, which extends
 *         Queue.
 * 
 		   Like Stack, Queue is a linear structure which follows First In First
 *         Out (FIFO) order. A good example of queue is any queue of consumers
 *         for a resource where the consumer that came first is served first.
 *         The difference between stacks and queues is in removing. In a stack
 *         we remove the most recently added item; in a queue, we remove the
 *         least recently added item. It can be implemented by using both array
 *         (static) and linked list(dynamic).
 * 
 *         Time Complexities: 
 *         Insertion : O(1) 
 *         Deletion : O(1) 
 *         Access : O(1)
 * 
 *         Applications of Queue: .CPU scheduling, Disk Scheduling where
 *         resources are shared among multiple users and served on 'First Come
 *         First Serve' basis. .IO Buffers, pipes, file IO, etc.
 * 
 * 
 * 		   Why Stack and Queue are called Abstract Data Types?
 * 
 * 		   A data type is called abstract when it is independent of various 
 * 		   concrete implementations i.e If your operations on data types doesn't 
 * 		   care about the type of data.
 * 		   
 * 		   Lets say Integer supports addition, subtraction, multiplication, division
		   operations. This operations wont work on String data. Hence Integer is not ADT.
 * 	
 * 
 */


//Queue Implementation in java

class QueueDemo {
	int front, rear, size, capacity;
	int buffer[];

	public QueueDemo(int cap) {
		capacity = cap;
		front = size = 0;
		rear = capacity - 1;
		buffer = new int[capacity];
	}

	// Queue is full when size becomes equal to
	// the capacity
	boolean isFull() {
		return (size == capacity);
	}

	// Queue is empty when size is 0
	boolean isEmpty() {
		return (size == 0);
	}

	// Method to add an item to the queue.
	// It changes rear and size
	void enqueue(int item) {
		if (isFull()) {
			System.out.println("Queue Overflow...Cannot enqueue -> " + item);
			return;
		}
		rear = (rear + 1) % capacity;
		buffer[rear] = item;
		size++;
		System.out.println("Item enqueued -> " + item);

	}

	// Method to remove an item from queue.
	// It changes front and size
	int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue Underflow...");
			return 0;
		}

		int item = buffer[front];
		buffer[front] = 0; // optional
		front = (front + 1) % capacity;
		size--;
		System.out.println("Item dequeued -> " + item);

		return item;
	}

	// Method to get front of queue
	private int front() {
		if (isEmpty())
			return Integer.MIN_VALUE;

		return buffer[front];
	}

	// Method to get rear of queue
	private int rear() {
		if (isEmpty())
			return Integer.MIN_VALUE;

		return buffer[rear];
	}

	void printQueue() {
		for (int a : buffer) {
			System.out.print(a + " | ");
		}
	}
}



public class A0_Queue_Interface {
	public static void main(String... args) {
		QueueDemo queue = new QueueDemo(10);
		System.out.println("*** Enqueue Operation ***\n");
		while (!queue.isFull()) {
			queue.enqueue(new Random().nextInt(100));
			queue.printQueue();
			System.out.println("\n");
		}
		System.out.println("*** dequeue Operation ***\n");
		while (!queue.isEmpty()) {
			queue.dequeue();
			queue.printQueue();
			System.out.println("\n");
		}

	}

}

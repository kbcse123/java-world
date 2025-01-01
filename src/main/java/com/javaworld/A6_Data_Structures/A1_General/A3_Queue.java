package com.javaworld.A6_Data_Structures.A1_General;
/**
 * 
 */

import java.util.Random;

/**
 * Like Stack, Queue is a linear structure which follows First In First Out
 * (FIFO) order. A good example of queue is any queue of consumers for a
 * resource where the consumer that came first is served first. The difference
 * between stacks and queues is in removing. In a stack we remove the most
 * recently added item; in a queue, we remove the least recently added item. It
 * can be implemented by using both array (static) and linked list(dynamic).
 * 
 * Principal operations:
 * 
 * .Enqueue - The process of adding an element to the collection.(The element is
 * added from the rear side)
 * 
 * .Dequeue - The process of removing the element that was added. (The element
 * is removed from the front side).
 * 
 * .Front: - Get the front item from queue.
 * 
 * .Rear: - Get the last item from queue.
 * 
 * Time Complexities: Insertion : O(1) Deletion : O(1) Access : O(1)
 * 
 * Applications of Queue: 
 * .CPU scheduling, Disk Scheduling where resources are shared among multiple users
 *  and served on 'First Come First Serve' basis. 
 * .IO Buffers, pipes, file IO, etc.
 * 
 * 
 */

class MyQueue {
	int front, rear, size, capacity;
	int queue[];

	public MyQueue(int cap) {
		capacity = cap;
		front = size = 0;
		rear = capacity - 1;
		queue = new int[capacity];

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
		queue[rear] = item;
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

		int item = queue[front];
		queue[front] = 0; // optional
		front = (front + 1) % capacity;
		size--;
		System.out.println("Item dequeued -> " + item);

		return item;
	}

	// Method to get front of queue
	int front() {
		if (isEmpty())
			return Integer.MIN_VALUE;

		return queue[front];
	}

	// Method to get rear of queue
	int rear() {
		if (isEmpty())
			return Integer.MIN_VALUE;

		return queue[rear];
	}

	void printQueue() {
		for (int a : queue) {
			System.out.print(a + " | ");
		}
	}
}

public class A3_Queue {
	public static void main(String... args) {
		MyQueue queue = new MyQueue(10);
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

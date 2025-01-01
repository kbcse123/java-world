package com.javaworld.A4_Advanced_Java._1_Collections.A2_Queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Shaik Khader
 *
 * An unbounded queue based on a priority heap. The elements of
 * the priority queue are ordered according to their natural ordering,
 * or by a Comparator provided at queue construction time, depending on
 * which constructor is used. A priority queue does not permit null
 * elements. A priority queue relying on natural ordering also does not
 * permit insertion of non-comparable objects (doing so may result in
 * ClassCastException).
 *
 * The head of this queue is the least element with respect to the
 * specified ordering. If multiple elements are tied for least value,
 * the head is one of those elements -- ties are broken arbitrarily. The
 * queue retrieval operations poll, remove, peek, and element access the
 * element at the head of the queue.
 *
 * A priority queue is unbounded, but has an internal capacity governing
 * the size of an array used to store the elements on the queue. It is
 * always at least as large as the queue size. As elements are added to
 * a priority queue, its capacity grows automatically. The details of
 * the growth policy are not specified.
 *
 * This class and its iterator implement all of the optional methods of
 * the Collection and Iterator interfaces. The Iterator provided in
 * method iterator() is not guaranteed to traverse the elements of the
 * priority queue in any particular order. If you need ordered
 * traversal, consider using Arrays.sort(pq.toArray()).
 *
 * Note that this implementation is not synchronized. Multiple threads
 * should not access a PriorityQueue instance concurrently if any of the
 * threads modifies the queue. Instead, use the thread-safe
 * PriorityBlockingQueue class.
 *
 * Implementation note: this implementation provides O(log(n)) time for
 * the enqueuing and dequeuing methods (offer, poll, remove() and add);
 * linear time for the remove(Object) and contains(Object) methods; and
 * constant time for the retrieval methods (peek, element, and size).
 *
 */

public class A2_PriorityQueue {
    public static void main(String[] args) {
        //declare a PriorityQueue object with default ordering
        Queue<Integer> minPQ = new PriorityQueue<Integer>();
        //add element to the PriorityQueue
        addElements(minPQ);
        //display the min PriorityQueue
        System.out.println("The min Priority Queue (natural ordering) contents:");
        showElements(minPQ);
        //declare a PriorityQueue object with custom comparator to generate max PQ
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((lhs, rhs) -> {
            if (lhs < rhs) return +1;
            if (lhs.equals(rhs)) return 0;
            return -1;
        });
        addElements(maxPQ);
        System.out.println("The Max Priority Queue contents:");
        showElements(minPQ);
    }

    private static void showElements(Queue<Integer> pq) {
        Integer val;
        while ((val = pq.poll()) != null) {
            System.out.print(val + " ");
        }
    }

    private static void addElements(Queue<Integer> pq) {
        pq.add(8);
        pq.add(6);
        pq.add(4);
        pq.add(2);
        pq.add(12);
        pq.add(10);
    }

}

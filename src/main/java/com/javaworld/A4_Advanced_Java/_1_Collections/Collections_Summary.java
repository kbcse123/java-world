package com.javaworld.A4_Advanced_Java._1_Collections;

/**
 * Collections Framework:
 * . A collection, sometimes called a container, is simply an object that groups multiple elements into a single unit.
 * Collections are used to store, retrieve, manipulate, and communicate aggregate data.
 * . A collections framework is a unified architecture for representing and manipulating collections.
 * <p>
 * Benefits of the Java Collections Framework:
 * . Reduces programming effort - By providing useful data structures and algorithms, the Collections Framework frees
 * you to concentrate on the important parts of your program rather than on the low-level "plumbing"
 * . Increases program speed and quality - Collections Framework provides high-performance, high-quality
 * implementations of useful data structures and algorithms. The various implementations of each interface are
 * interchangeable, so programs can be easily tuned by switching collection implementations.
 * . Reduces effort to design new APIs - Designers and implementers don't have to reinvent the wheel each time they
 * create an API that relies on collections; instead, they can use standard collection interfaces.
 * . Fosters software reuse: New data structures that conform to the standard collection interfaces are by nature
 * reusable. The same goes for new algorithms that operate on objects that implement these interfaces.
 * <p>
 * Collection interface:
 * . This interface is used to pass around collections of objects where maximum generality is desired. For example, by
 * convention all general-purpose collection implementations have a constructor that takes a Collection argument and
 * allows you to convert the collection's type.
 * . The Collection interface contains methods to perform various operations -
 * a) Basic operations - int size(), boolean isEmpty(), boolean contains(Object element), boolean add(E element),
 * boolean remove(Object element), and Iterator<E> iterator().
 * b) Bulk Operations  - boolean containsAll(Collection<?> c),    boolean addAll(Collection<? extends E> c),
 * boolean removeAll(Collection<?> c), boolean retainAll(Collection<?> c) and void clear().
 * c) array operations - Object[] toArray() and <T> T[] toArray(T[] a).
 * d) aggregate operations - Stream<E> stream() and Stream<E> parallelStream().
 * <p>
 * Object Ordering:
 * . Comparable Interface -
 * a) Comparable implementations provide a natural ordering for a class, which allows objects of that class to be
 * sorted automatically.
 * b) If you try to sort a list, the elements of which do not implement Comparable, Collections.sort(list) will
 * throw a ClassCastException. Similarly, Collections.sort(list, comparator) too.
 * c) Elements that can be compared to one another are called mutually comparable
 * d) Writing Your Own Comparable Types - The Comparable interface consists of the following method.
 * public interface Comparable<T> { public int compareTo(T o); }
 * The compareTo method compares the receiving object with the specified object and returns a negative integer,
 * 0, or a positive integer depending on whether the receiving object is less than, equal to, or greater than
 * the specified object. If the specified object cannot be compared to the receiving object, the method throws a
 * ClassCastException.
 * . Comparator Interface -
 * a) What if you want to sort some objects in an order other than their natural ordering? Or what if you want to
 * sort some objects that don't implement Comparable? To do either of these things, you'll need to provide a
 * Comparator.
 * b) Like the Comparable interface, the Comparator interface consists of a single method -
 * public interface Comparator<T> { int compare(T o1, T o2); }
 * c) Much of what was said about Comparable applies to Comparator as well. Writing a compare method is nearly
 * identical to writing a compareTo method, except that the former gets both objects passed in as arguments.
 * <p>
 * List Interface:
 * . A List is an ordered Collection (sometimes called a sequence). Lists may contain duplicate elements. In addition
 * to the operations inherited from Collection, the List interface includes operations for the following:
 * a) Positional access - manipulates elements based on their numerical position in the list. This includes
 * methods such as get, set, add, addAll, and remove.
 * b) Search - searches for a specified object in the list and returns its numerical position. Search methods
 * include indexOf and lastIndexOf.
 * c) Iteration - extends Iterator semantics to take advantage of the list's sequential nature. The listIterator
 * methods provide this behavior.
 * d) Range-view - The sublist method performs arbitrary range operations on the list.
 * . General-Purpose List Implementations -
 * a) ArrayList
 * b) LinkedList - If you frequently add elements to the beginning of the List or iterate over the List to delete
 * elements from its interior. LinkedList has no tuning parameters and seven optional operations.
 * addFirst, getFirst, removeFirst, addLast, getLast, removeLast and clone. LinkedList also
 * implements the Queue interface.
 * . Special-Purpose List Implementations -
 * CopyOnWriteArrayList is a List implementation backed up by a copy-on-write array. This implementation is similar
 * in nature to CopyOnWriteArraySet. No synchronization is necessary, even during iteration, and iterators are
 * guaranteed never to throw ConcurrentModificationException. This implementation is well suited to maintaining
 * event-handler lists, in which change is infrequent, and traversal is frequent and potentially time-consuming.
 * <p>
 * . List Algorithms -
 * 1) sort - sorts a List
 * 2) shuffle - randomly permutes the elements in a List.
 * 3) reverse - reverses the order of the elements in a List.
 * 4) rotate - rotates all the elements in a List by a specified distance.
 * 5) swap - swaps the elements at specified positions in a List.
 * 6) replaceAll - replaces all occurrences of one specified value with another.
 * 7) fill - overwrites every element in a List with the specified value.
 * 8) copy - copies the source List into the destination List.
 * 9) binarySearch - searches for an element in an ordered List using the binary search algorithm.
 * 10)indexOfSubList - returns the index of the first sublist of one List that is equal to another.
 * 11)lastIndexOfSubList - returns the index of the last sublist of one List that is equal to another.
 * <p>
 * ArrayList-
 * . Resizable-array implementation of the List interface, offers constant-time positional access and is just plain fast.
 * . ArrayList has one tuning parameter, the initial capacity, which refers to the number of elements the ArrayList can
 * hold before it has to grow.
 * . Implements all optional list operations, and permits all elements, including null.
 * . The size, isEmpty, get, set, iterator, and listIterator operations run in constant time. The add operation runs
 * in amortized constant time, that is, adding n elements requires O(n) time. All of the other operations run in
 * linear time (roughly speaking).
 * . Note that this implementation is not synchronized. If multiple threads access an ArrayList instance concurrently,
 * and at least one of the threads modifies the list structurally, it must be synchronized externally or best way is
 * using the Collections.synchronizedList() method.
 * . The iterators returned by this class's iterator and listIterator methods are fail-fast(cannot be guaranteed):
 * if the list is structurally modified at any time after the iterator is created, in any way except through the
 * iterator's own remove or add methods, the iterator will throw a ConcurrentModificationException.
 * <p>
 * LinkedList-
 * . Doubly-linked list implementation of the List interfaces. Implements all optional list operations, and permits
 * all elements (including null).
 * . Note that this implementation is not synchronized (following is same as ArrayList).
 * <p>
 * Stack-
 * . Stack class falls under the Collection framework that extends the Vector class. It also implements interfaces List,
 * Collection,Iterable, Cloneable, Serializable. It represents the LIFO stack of objects.
 * <p>
 * . The stack is a linear data structure that is used to store the collection of objects. It is based on
 * Last-In-First-Out (LIFO) We can perform push, pop, peek and search operation on the stack. The Java Stack class
 * provides mainly five methods to perform these operations. Along with this, it also provides all the methods of the
 * Java Vector class.
 * <p>
 * <p>
 * Queue Interface:
 * . Like Stack, Queue is a linear structure which follows First In First Out (FIFO) order. A good example of queue is
 * any queue of consumers for a resource where the consumer that came first is served first. The difference between
 * stacks and queues is in removing. In a stack we remove the most recently added item; in a queue, we remove the
 * least recently added item. It can be implemented by using both array (static) and linked list(dynamic).
 * <p>
 * Time Complexities:
 * Insertion : O(1)
 * Deletion : O(1)
 * Access : O(1)
 * <p>
 * . Applications of Queue: CPU scheduling, Disk Scheduling where resources are shared among multiple users and served
 * on 'First Come First Serve' basis, IO Buffers, pipes, file IO, etc.
 * <p>
 * LinkedList- Same as above for List
 * <p>
 * Queue<Integer> q = new LinkedList<>();
 * for(int i=1;i<=5;i++){
 * q.add(i);
 * }
 * System.out.println("After add(). Elements: "+q);
 * //returns true if the element was added to this queue
 * q.offer(null);
 * System.out.println("After offer(null). Elements: "+q);
 * System.out.println("\n--- Delete Operation: ---");
 * q.poll();
 * System.out.println("After poll(). Elements: "+q);
 * q.remove();
 * System.out.println("After remove(). Elements: "+q);
 * System.out.println("\n--- Examine Operation: ---");
 * // returns null if queue is empty.
 * System.out.println("q.peek(): "+q.peek());
 * //throws NoSuchElementException if queue is empty
 * System.out.println("q.element(): "+q.element());
 * System.out.println("\n--- Iterator Operation: ---");
 * Iterator<Integer> itr = q.iterator();
 * //q.remove(); //throws ConcurrentModificationException
 * while(itr.hasNext()){
 * System.out.print(itr.next()+" -> ");
 * }
 * <p>
 * Priority queue-
 * . An unbounded queue based on a priority heap. The elements of the priority queue are ordered according to their
 * natural ordering, or by a Comparator provided at queue construction time.
 * . It does not permit null elements.
 * . It relying on natural ordering also does not permit insertion of non-comparable objects (doing so may result in
 * ClassCastException).
 * . The head of this queue is the least element with respect to the specified ordering. If multiple elements are
 * tied for least value, the head is one of those elements -- ties are broken arbitrarily. The queue retrieval
 * operations poll, remove, peek, and element access the element at the head of the queue.
 * . Note that this implementation is not synchronized. Multiple threads should not access a PriorityQueue instance
 * concurrently if any of the threads modifies the queue. Instead, use the thread-safe PriorityBlockingQueue class.
 * . This implementation provides O(log(n)) time for the enqueuing and dequeuing methods (offer, poll, remove() and add);
 * linear time for the remove(Object) and contains(Object) methods; and constant time for the retrieval methods
 * (peek, element, and size).
 * <p>
 * //declare a PriorityQueue object with default ordering
 * PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
 * //add element to the PriorityQueue
 * pq.add(8);
 * pq.add(6);
 * pq.add(4);
 * pq.add(2);
 * pq.add(12);
 * pq.add(10);
 * //display the min PriorityQueue
 * System.out.println("The min Priority Queue (natural ordering) contents:");
 * Integer val = null;
 * while( (val = pq.poll()) != null) {
 * System.out.print(val + " ");
 * }
 */


public class Collections_Summary {

}

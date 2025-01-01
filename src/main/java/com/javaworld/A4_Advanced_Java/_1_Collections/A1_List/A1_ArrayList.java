package com.javaworld.A4_Advanced_Java._1_Collections.A1_List;


import java.util.ArrayList;

/**
 * 
 * Resizable-array implementation of the List interface. Implements all optional
 * list operations, and permits all elements, including null. In addition to
 * implementing the List interface, this class provides methods to manipulate
 * the size of the array that is used internally to store the list. (This class
 * is roughly equivalent to Vector, except that it is unsynchronized.)
 * 
 * The size, isEmpty, get, set, iterator, and listIterator operations run in
 * constant time. The add operation runs in amortized constant time, that is,
 * adding n elements requires O(n) time. All of the other operations run in
 * linear time (roughly speaking).
 * 
 * Each ArrayList instance has a capacity. The capacity is the size of the array
 * used to store the elements in the list. It is always at least as large as the
 * list size. As elements are added to an ArrayList, its capacity grows
 * automatically.
 * 
 * An application can increase the capacity of an ArrayList instance before
 * adding a large number of elements using the ensureCapacity operation. This
 * may reduce the amount of incremental reallocation.
 * 
 * Note that this implementation is not synchronized. If multiple threads access
 * an ArrayList instance concurrently, and at least one of the threads modifies
 * the list structurally, it must be synchronized externally or best way is
 * using the Collections.synchronizedList() method.
 * 
 * The iterators returned by this class's iterator and listIterator methods are
 * fail-fast: if the list is structurally modified at any time after the
 * iterator is created, in any way except through the iterator's own remove or
 * add methods, the iterator will throw a ConcurrentModificationException.
 * 
 * Note that the fail-fast behavior of an iterator cannot be guaranteed as it
 * is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification. Fail-fast iterators throw
 * ConcurrentModificationException on a best-effort basis. Therefore, it would
 * be wrong to write a program that depended on this exception for its
 * correctness: the fail-fast behavior of iterators should be used only to
 * detect bugs.
 * 
 * Method Details:
 * 
 * add(E e) - Appends the specified element to the end of this list.
 * 
 * add(int index, E element) - Inserts the specified element at the specified
 * position in this list.
 * 
 * addAll(Collection<? extends E> c) - Appends all of the elements in the
 * specified collection to the end of this list, in the order that they are
 * returned by the specified collection's Iterator.
 * 
 * addAll(int index, Collection<? extends E> c) - Inserts all of the elements in
 * the specified collection into this list, starting at the specified position.
 * 
 * clear() - Removes all of the elements from this list.
 * 
 * clone() - Returns a shallow copy of this ArrayList instance.
 * 
 * contains(Object o) - Returns true if this list contains the specified
 * element.
 * 
 * ensureCapacity(int minCapacity) - Increases the capacity of this ArrayList
 * instance, if necessary, to ensure that it can hold at least the number of
 * elements specified by the minimum capacity argument.
 * 
 * forEach(Consumer<? super E> action) - Performs the given action for each
 * element of the Iterable until all elements have been processed or the action
 * throws an exception.
 * 
 * get(int index) - Returns the element at the specified position in this list.
 * 
 * indexOf(Object o) - Returns the index of the first occurrence of the
 * specified element in this list, or -1 if this list does not contain the
 * element.
 * 
 * isEmpty() - Returns true if this list contains no elements.
 * 
 * iterator() - Returns an iterator over the elements in this list in proper
 * sequence.
 * 
 * lastIndexOf(Object o) - Returns the index of the last occurrence of the
 * specified element in this list, or -1 if this list does not contain the
 * element.
 * 
 * listIterator() - Returns a list iterator over the elements in this list (in
 * proper sequence).
 * 
 * listIterator(int index) - Returns a list iterator over the elements in this
 * list (in proper sequence), starting at the specified position in the list.
 * 
 * remove(int index) - Removes the element at the specified position in this
 * list.
 * 
 * remove(Object o) - Removes the first occurrence of the specified element from
 * this list, if it is present.
 * 
 * removeAll(Collection<?> c) - Removes from this list all of its elements that
 * are contained in the specified collection.
 * 
 * removeIf(Predicate<? super E> filter) - Removes all of the elements of this
 * collection that satisfy the given predicate.
 * 
 * protected void removeRange(int fromIndex, int toIndex) - Removes from this
 * list all of the elements whose index is between fromIndex, inclusive, and
 * toIndex, exclusive.
 * 
 * replaceAll(UnaryOperator<E> operator) - Replaces each element of this
 * list with the result of applying the operator to that element.
 * 
 * retainAll(Collection<?> c) - Retains only the elements in this list that are
 * contained in the specified collection.
 * 
 * set(int index, E element) - Replaces the element at the specified position in
 * this list with the specified element.
 * 
 * size() - Returns the number of elements in this list.
 * 
 * sort(Comparator<? super E> c) - Sorts this list according to the order
 * induced by the specified Comparator.
 * 
 * spliterator() - Creates a late-binding and fail-fast Spliterator over the
 * elements in this list.
 * 
 * subList(int fromIndex, int toIndex) - Returns a view of the portion of this
 * list between the specified fromIndex and toIndex.
 * 
 * toArray() - Returns an array containing all of the elements in this list in
 * proper sequence (from first to last element).
 * 
 * toArray(T[] a) - Returns an array containing all of the elements in this list
 * in proper sequence (from first to last element); the runtime type of the
 * returned array is that of the specified array.
 * 
 * trimToSize() - Trims the capacity of this ArrayList instance to be the list's
 * current size. This operation can be used to minimize the storage of an
 * ArrayList instance.
 * 
 * 
 * 
 * 
 * @author Shaik Khader
 */

public class A1_ArrayList {
	public static void main(String... args) {
		ArrayList<String> list = new ArrayList<>();
		
		list.trimToSize();
	}

}

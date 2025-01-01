package com.javaworld.A4_Advanced_Java._1_Collections.A0_Introduction;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * @author Shaik Khader
 * 
 *         . A List is an ordered Collection (sometimes called a sequence).
 *         Lists may contain duplicate elements. In addition to the operations
 *         inherited from Collection, the List interface includes operations for
 *         the following:
 * 
 *         Positional access � manipulates elements based on their numerical
 *         position in the list. This includes methods such as get, set, add,
 *         addAll, and remove.
 * 
 *         Search � searches for a specified object in the list and returns its
 *         numerical position. Search methods include indexOf and lastIndexOf.
 * 
 *         Iteration � extends Iterator semantics to take advantage of the
 *         list's sequential nature. The listIterator methods provide this
 *         behavior.
 * 
 *         Range-view � The sublist method performs arbitrary range operations
 *         on the list.
 * 
 *         . The Java platform contains two general-purpose List
 *         implementations. ArrayList, which is usually the better-performing
 *         implementation, and LinkedList which offers better performance under
 *         certain circumstances.
 * 
 *         Collection Operations:
 * 
 *         The operations inherited from Collection all do about what you'd
 *         expect them to do, assuming you're already familiar with them. If
 *         you're not familiar with them from Collection, now would be a good
 *         time to read The Collection Interface section. The remove operation
 *         always removes the first occurrence of the specified element from the
 *         list. The add and addAll operations always append the new element(s)
 *         to the end of the list. Thus, the following idiom concatenates one
 *         list to another.
 * 
 *         list1.addAll(list2);
 * 
 *         Here's a non-destructive form of this idiom, which produces a third
 *         List consisting of the second list appended to the first.
 * 
 *         List<Type> list3 = new ArrayList<Type>(list1); list3.addAll(list2);
 * 
 *         Note that the idiom, in its non-destructive form, takes advantage of
 *         ArrayList's standard conversion constructor.
 * 
 *         And here's an example (JDK 8 and later) that aggregates some names
 *         into a List:
 * 
 *         List<String> list = people.stream() .map(Person::getName)
 *         .collect(Collectors.toList());
 * 
 *         Like the Set interface, List strengthens the requirements on the
 *         equals and hashCode methods so that two List objects can be compared
 *         for logical equality without regard to their implementation classes.
 *         Two List objects are equal if they contain the same elements in the
 *         same order.
 * 
 *         Positional Access and Search Operations:
 * 
 *         The basic positional access operations are get, set, add and remove.
 *         (The set and remove operations return the old value that is being
 *         overwritten or removed.) Other operations (indexOf and lastIndexOf)
 *         return the first or last index of the specified element in the list.
 * 
 *         The addAll operation inserts all the elements of the specified
 *         Collection starting at the specified position. The elements are
 *         inserted in the order they are returned by the specified Collection's
 *         iterator. This call is the positional access analog of Collection's
 *         addAll operation.
 * 
 *         Iterators:
 * 
 *         . As you'd expect, the Iterator returned by List's iterator operation
 *         returns the elements of the list in proper sequence. List also
 *         provides a richer iterator, called a ListIterator, which allows you
 *         to traverse the list in either direction, modify the list during
 *         iteration, and obtain the current position of the iterator.
 * 
 *         . The three methods that ListIterator inherits from Iterator
 *         (hasNext, next, and remove) do exactly the same thing in both
 *         interfaces. The hasPrevious and the previous operations are exact
 *         analogues of hasNext and next. The former operations refer to the
 *         element before the (implicit) cursor, whereas the latter refer to the
 *         element after the cursor. The previous operation moves the cursor
 *         backward, whereas next moves it forward.
 * 
 *         . The List interface has two forms of the listIterator method. The
 *         form with no arguments returns a ListIterator positioned at the
 *         beginning of the list; the form with an int argument returns a
 *         ListIterator positioned at the specified index. The index refers to
 *         the element that would be returned by an initial call to next. An
 *         initial call to previous would return the element whose index was
 *         index-1. In a list of length n, there are n+1 valid values for index,
 *         from 0 to n, inclusive.
 * 
 *         . It should come as no surprise that the nextIndex method returns the
 *         index of the element that would be returned by a subsequent call to
 *         next, and previousIndex returns the index of the element that would
 *         be returned by a subsequent call to previous. These calls are
 *         typically used either to report the position where something was
 *         found or to record the position of the ListIterator so that another
 *         ListIterator with identical position can be created.
 * 
 *         . It should also come as no surprise that the number returned by
 *         nextIndex is always one greater than the number returned by
 *         previousIndex. This implies the behavior of the two boundary cases:
 *         (1) a call to previousIndex when the cursor is before the initial
 *         element returns -1 and (2) a call to nextIndex when the cursor is
 *         after the final element returns list.size().
 * 
 *         Range-View Operation:
 * 
 *         . The range-view operation, subList(int fromIndex, int toIndex),
 *         returns a List view of the portion of this list whose indices range
 *         from fromIndex, inclusive, to toIndex, exclusive.
 * 
 *         . As the term view implies, the returned List is backed up by the
 *         List on which subList was called, so changes in the former are
 *         reflected in the latter.
 * 
 *         . This method eliminates the need for explicit range operations (of
 *         the sort that commonly exist for arrays). Any operation that expects
 *         a List can be used as a range operation by passing a subList view
 *         instead of a whole List. For example, the following idiom removes a
 *         range of elements from a List.
 * 
 *         list.subList(fromIndex, toIndex).clear();
 * 
 *         . Similar idioms can be constructed to search for an element in a
 *         range.
 * 
 *         int i = list.subList(fromIndex, toIndex).indexOf(o); int j =
 *         list.subList(fromIndex, toIndex).lastIndexOf(o);
 * 
 *         . Note that the preceding idioms return the index of the found
 *         element in the subList, not the index in the backing List.
 * 
 *         . Although the subList operation is extremely powerful, some care
 *         must be exercised when using it. The semantics of the List returned
 *         by subList become undefined if elements are added to or removed from
 *         the backing List in any way other than via the returned List. Thus,
 *         it's highly recommended that you use the List returned by subList
 *         only as a transient object � to perform one or a sequence of range
 *         operations on the backing List. The longer you use the subList
 *         instance, the greater the probability that you'll compromise it by
 *         modifying the backing List directly or through another subList
 *         object. Note that it is legal to modify a sublist of a sublist and to
 *         continue using the original sublist (though not concurrently).
 * 
 *         List Algorithms:
 * 
 *         . Most polymorphic algorithms in the Collections class apply
 *         specifically to List. Having all these algorithms at your disposal
 *         makes it very easy to manipulate lists. Here's a summary of these
 *         algorithms, which are described in more detail in the Algorithms
 *         section.
 * 
 *         sort � sorts a List using a merge sort algorithm, which provides a
 *         fast, stable sort. (A stable sort is one that does not reorder equal
 *         elements.)
 * 
 *         shuffle � randomly permutes the elements in a List.
 * 
 *         reverse � reverses the order of the elements in a List.
 * 
 *         rotate � rotates all the elements in a List by a specified distance.
 * 
 *         swap � swaps the elements at specified positions in a List.
 * 
 *         replaceAll � replaces all occurrences of one specified value with
 *         another.
 * 
 *         fill � overwrites every element in a List with the specified value.
 * 
 *         copy � copies the source List into the destination List.
 * 
 *         binarySearch � searches for an element in an ordered List using the
 *         binary search algorithm.
 * 
 *         indexOfSubList � returns the index of the first sublist of one List
 *         that is equal to another.
 * 
 *         lastIndexOfSubList � returns the index of the last sublist of one
 *         List that is equal to another.
 * 
 * 
 * 
 */

public class A3_List_Interface {

	public static void main(String... args) {
		/*
		 * List<String> list = Arrays.asList("hi", "there", "how", "are", "you", "its",
		 * "been", "a", "long", "time"); Collections.sort(list);
		 * System.out.println("\nAfter sorting: " + list); List<String> list2 = new
		 * ArrayList<String>(list); System.out.println("Before Shuffling: " + list2);
		 * Collections.shuffle(list2, new Random()); List<String> emptyList =
		 * Collections.emptyList(); System.out.println("\nAfter Shuffling: " + list2);
		 * list. System.out.println("\nList iteration in reverse order: "); for
		 * (ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious();)
		 * { System.out.println(it.previous()); }
		 */
		
		List<String> list = Arrays.asList("Samsung", "Vivo", "Redmi", "IPhone", "Realme", "Samsung", "Redmi", "Vivo", "Iphone", "Samsung");
		
		System.out.println(Collections.frequency(list, "Samsung"));
	}

}

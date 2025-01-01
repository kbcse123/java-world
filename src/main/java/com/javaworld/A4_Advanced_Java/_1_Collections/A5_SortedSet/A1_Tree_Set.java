package com.javaworld.A4_Advanced_Java._1_Collections.A5_SortedSet;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Shaik Khader
 * 
 *         A NavigableSet implementation based on a TreeMap. The elements are
 *         ordered using their natural ordering, or by a Comparator provided at
 *         set creation time, depending on which constructor is used.
 * 
 *         This implementation provides guaranteed log(n) time cost for the
 *         basic operations (add, remove and contains).
 * 
 *         Note that this implementation is not synchronized. In order to
 *         synchronize use Collections.synchronizedSortedSet method.
 * 
 *         SortedSet<Type> s = Collections.synchronizedSortedSet(new
 *         TreeSet<>(...));
 * 
 *         Note: 1) The iterators returned by this class's iterator method are
 *         fail-fast. 2) This implementation does not accept null elements.
 *         Attempting to do so results in NullPointerException.
 * 
 *         Methods:
 * 
 *         first() - Returns the first element currently in this set. Throws
 *         NoSuchElementException, if set is empty
 * 
 *         last() - Returns the last (highest) element currently in this set.
 *         Throws NoSuchElementException, if set is empty
 * 
 *         subSet(Integer fromElement, Integer toElement) - Returns a view of
 *         the portion of this set whose elements range from fromElement,
 *         inclusive, to toElement, exclusive. (If fromElement and toElement are
 *         equal, the returned set is empty.)
 * 
 *         headSet(Integer toElement) - Returns a view of the portion of this
 *         set whose elements are strictly less than toElement.
 * 
 *         tailSet(E fromElement) - Returns a view of the portion of this set
 *         whose elements are greater than or equal to fromElement.
 * 
 *         Note: the set returned by subSet,headSet and tailSet is backed by
 *         operating set, so changes in the returned set are reflected in
 *         operating set, and vice-versa. The returned set supports all optional
 *         set operations that operating set supports.
 *         
 *         
 * 
 */


class CustomSetWithComparable implements Comparable<CustomSetWithComparable>{

	String val;
	
	CustomSetWithComparable(String v){
		val = v;
	}
	@Override
	public int compareTo(CustomSetWithComparable o) {
		//desc order
		return val.compareTo(o.val);
	}
	
	public String toString(){
		return val;
	}
	
}

public class A1_Tree_Set {
	public static void main(String... args) {
		SortedSet<Integer> ascOrder = new TreeSet<>();
		ascOrder.add(15);
		ascOrder.add(3);
		ascOrder.add(10);
		ascOrder.add(8);
		ascOrder.add(12);
		ascOrder.add(1);
		ascOrder.add(6);
		ascOrder.add(4);
		// ascOrder.add(null);// Can't add null
		System.out.println("*** Ascending Order ***");
		printSet(ascOrder, 2, 9);
		//using comparator
		Comparator<Integer> descCom = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		};

		SortedSet<Integer> descOrder = new TreeSet<>(descCom);
		descOrder.add(5);
		descOrder.add(3);
		descOrder.add(10);
		descOrder.add(8);
		descOrder.add(2);
		descOrder.add(1);
		descOrder.add(6);
		descOrder.add(4);

		System.out.println("\n*** Descending Order ***");
		printSet(descOrder, 8, 2);

		System.out.println("\n*** Strings ***");

		SortedSet<String> stringSet = new TreeSet<>();
		stringSet.add("Ahmed");
		stringSet.add("Basha");
		stringSet.add("Dane");
		stringSet.add("Khader");
		stringSet.add("Shaik");
		printSet(stringSet, "B", "K");
		
		System.out.println("\n*** using Comparable ***");
		CustomSetWithComparable c1 = new CustomSetWithComparable("Khader");
		CustomSetWithComparable c2 = new CustomSetWithComparable("Mohan");
		CustomSetWithComparable c3 = new CustomSetWithComparable("Dane");
		CustomSetWithComparable c4 = new CustomSetWithComparable("Tharif");
		CustomSetWithComparable c5 = new CustomSetWithComparable("Ramesh");
		CustomSetWithComparable c6 = new CustomSetWithComparable("Mudassir");
		SortedSet<CustomSetWithComparable> customSet = new TreeSet<>();
		customSet.add(c1);
		customSet.add(c2);
		customSet.add(c3);
		customSet.add(c4);
		customSet.add(c5);
		customSet.add(c6);
		//printSet(customSet, "K", "S");
		System.out.println(customSet); 
	}

	private static <E> void printSet(SortedSet<E> s, E from, E to) {
		System.out.println("Elements= " + s);
		System.out.println("set.first()= " + s.first());
		System.out.println("set.last()= " + s.last());
		System.out.println("set.subSet(" + from + "," + to + ")= " + s.subSet(from, to));
		System.out.println("set.headSet(" + to + ")= " + s.headSet(to));
		System.out.println("set.tailSet(" + from + ")= " + s.tailSet(from));
	}

}

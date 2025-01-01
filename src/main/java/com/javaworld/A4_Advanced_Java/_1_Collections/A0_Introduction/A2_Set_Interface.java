package com.javaworld.A4_Advanced_Java._1_Collections.A0_Introduction;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author Shaik Khader
 * 
 *         . A Set is a Collection that cannot contain duplicate elements. It
 *         models the mathematical set abstraction. The Set interface contains
 *         only methods inherited from Collection and adds the restriction that
 *         duplicate elements are prohibited. Set also adds a stronger contract
 *         on the behavior of the equals and hashCode operations, allowing Set
 *         instances to be compared meaningfully even if their implementation
 *         types differ. Two Set instances are equal if they contain the same
 *         elements.
 * 
 *         . The Java platform contains three general-purpose Set
 *         implementations: HashSet, TreeSet, and LinkedHashSet. HashSet, which
 *         stores its elements in a hash table, is the best-performing
 *         implementation; however it makes no guarantees concerning the order
 *         of iteration. TreeSet, which stores its elements in a red-black tree,
 *         orders its elements based on their values; it is substantially slower
 *         than HashSet. LinkedHashSet, which is implemented as a hash table
 *         with a linked list running through it, orders its elements based on
 *         the order in which they were inserted into the set (insertion-order).
 *         LinkedHashSet spares its clients from the unspecified, generally
 *         chaotic ordering provided by HashSet at a cost that is only slightly
 *         higher.
 * 
 *         . Here's a simple but useful Set idiom. Suppose you have a
 *         Collection, c, and you want to create another Collection containing
 *         the same elements but with all duplicates eliminated. The following
 *         one-liner does the trick: Collection<Type> noDups = new HashSet
 *         <Type>(c);
 * 
 *         . It works by creating a Set (which, by definition, cannot contain
 *         duplicates), initially containing all the elements in c. It uses the
 *         standard conversion constructor described in the Collection
 *         Interface section.
 * 
 *         . Or, if using JDK 8 or later, you could easily collect into a Set
 *         using aggregate operations: c.stream().collect(Collectors.toSet());
 *         // no duplicates
 * 
 *         . Here's a slightly longer example that accumulates a Collection of
 *         names into a TreeSet:
 * 
 *         Set<String> set =
 *         people.stream().map(Person::getName).collect(Collectors.toCollection(
 *         TreeSet::new));
 * 
 *         . And the following is a minor variant of the first idiom that
 *         preserves the order of the original collection while removing
 *         duplicate elements:
 * 
 *         Collection<Type> noDups = new LinkedHashSet<Type>(c);
 * 
 *         . The following is a generic method that encapsulates the preceding
 *         idiom, returning a Set of the same generic type as the one passed.
 * 
 *         public static <E> Set<E> removeDups(Collection<E> c) { return new
 *         LinkedHashSet<E>(c); }
 * 
 *         Set Interface Basic Operations:
 * 
 *         . The size operation returns the number of elements in the Set (its
 *         cardinality). The isEmpty method does exactly what you think it
 *         would.The add method adds the specified element to the Set if it is
 *         not already present and returns a boolean indicating whether the
 *         element was added.Similarly, the remove method removes the specified
 *         element from the Set if it is present and returns a boolean
 *         indicating whether the element was present. The iterator method
 *         returns an Iterator over the Set.
 * 
 *         . The below program prints out all distinct words in its argument
 *         list. Two versions of this program are provided. The first uses JDK 8
 *         aggregate operations.The second uses the for-each construct.
 * 
 *         . Note that the code always refers to the Collection by its interface
 *         type (Set) rather than by its implementation type. This is a strongly
 *         recommended programming practice because it gives you the flexibility
 *         to change implementations merely by changing the constructor. If
 *         either of the variables used to store a collection or the parameters
 *         used to pass it around are declared to be of the Collection's
 *         implementation type rather than its interface type, all such
 *         variables and parameters must be changed in order to change its
 *         implementation type.
 * 
 *         . The implementation type of the Set in the preceding example is
 *         HashSet, which makes no guarantees as to the order of the elements in
 *         the Set. If you want the program to print the word list in
 *         alphabetical order, merely change the Set's implementation type from
 *         HashSet to TreeSet, just one-line change.
 * 
 * 
 *         Set Interface Bulk Operations:
 * 
 *         . Bulk operations are particularly well suited to Sets; when applied,
 *         they perform standard set-algebraic operations. Suppose s1 and s2 are
 *         sets. Here's what bulk operations do:
 * 
 *         s1.containsAll(s2) � returns true if s2 is a subset of s1. (s2 is a
 *         subset of s1 if set s1 contains all of the elements in s2.)
 *         s1.addAll(s2) � transforms s1 into the union of s1 and s2. (The union
 *         of two sets is the set containing all of the elements contained in
 *         either set.) s1.retainAll(s2) � transforms s1 into the intersection
 *         of s1 and s2. (The intersection of two sets is the set containing
 *         only the elements common to both sets.) s1.removeAll(s2) � transforms
 *         s1 into the (asymmetric) set difference of s1 and s2. (For example,
 *         the set difference of s1 minus s2 is the set containing all of the
 *         elements found in s1 but not in s2.)
 * 
 *         . To calculate the union, intersection, or set difference of two sets
 *         nondestructively (without modifying either set), the caller must copy
 *         one set before calling the appropriate bulk operation. 
 * 
 * 
 */

class FindDups {
	static String[] values = { "i", "came", "i", "saw", "you", "i", "left" };
	// static String[] values = initValues(); // Another way

	public static String[] initValues() {
		String[] val = { "i", "came", "i", "saw", "i", "left" };
		System.out.println("**** Actual values ****\n" + Arrays.toString(val));
		return val;
	}

	static {
		System.out.println("**** Actual values ****");
		System.out.println(Arrays.toString(values));
	}

	public static void usingAggregateOperation() {
		System.out.println("\n**** using Aggregate Operation ****");
		Set<String> distinctWords = Arrays.asList(values).stream().collect(Collectors.toSet());
		System.out.println(distinctWords.size() + " distinct words: " + distinctWords);
	}

	public static void usingForEach() {
		System.out.println("\n**** using for-each ****");
		Set<String> distinctWords = new HashSet<String>();
		for (String a : values)
			distinctWords.add(a);
		System.out.println(distinctWords.size() + " distinct words: " + distinctWords);
	}

	public static void usingConstructor() {
		System.out.println("\n**** using constructor ****");
		Set<String> distinctWords = new HashSet<String>(Arrays.asList(values));
		System.out.println(distinctWords.size() + " distinct words: " + distinctWords);
	}

	public static void usingTreeSet() {
		System.out.println("\n**** using TreeSet for natural order****");
		Set<String> distinctWords = new TreeSet<String>(Arrays.asList(values));
		System.out.println(distinctWords.size() + " distinct words: " + distinctWords);
	}

	public static void bulkOperation() {
		Set<String> s1 = new HashSet<String>(Arrays.asList(values));

		Set<String> union = new HashSet<String>();
		union.add("how");
		union.add("are");
		union.add("you");
		union.addAll(s1);
		System.out.println("Union using addAll() = " + union);

		Set<String> intersection = new HashSet<String>();
		intersection.add("came");
		intersection.add("you");
		intersection.retainAll(s1);
		System.out.println("Instersection using retailAll() = " + intersection);

		Set<String> difference = new HashSet<String>(s1);
		difference.removeAll(intersection);
		System.out.println("Set difference using removeAll() = " + difference);
	}

}

public class A2_Set_Interface {
	public static void main(String... args) {
		System.out.println("Set Interface Basic Operations");
		hashSetOperations();
		linkedHashSetOperations(); 
		treeSetOperations();
		
		
		
		
		FindDups.usingAggregateOperation();
		FindDups.usingForEach();
		FindDups.usingConstructor();
		FindDups.usingTreeSet();

		System.out.println("\n ---- Set Interface Bulk Operations ----");
		FindDups.bulkOperation();

	}

	private static void hashSetOperations() {
		Set<String> hashSet = new HashSet<>();
		
	}

	private static void linkedHashSetOperations() {
		Set<String> linkedHashSet = new LinkedHashSet<>();
		
	}

	private static void treeSetOperations() {
		Set<String> treeSet = new TreeSet<>();
		
	}

	
}

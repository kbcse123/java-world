package com.javaworld.A4_Advanced_Java._1_Collections.A4_Set;


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
 *          Set Interface Bulk Operations:
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

public class A0_Set_Interface {}

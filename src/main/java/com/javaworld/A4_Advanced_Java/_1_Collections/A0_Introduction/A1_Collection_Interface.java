package com.javaworld.A4_Advanced_Java._1_Collections.A0_Introduction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Shaik Khader
 * <p>
 * . A Collection represents a group of objects known as its elements.
 * The Collection interface is used to pass around collections of
 * objects where maximum generality is desired. For example, by
 * convention all general-purpose collection implementations have a
 * constructor that takes a Collection argument. This constructor, known
 * as a conversion constructor, initializes the new collection to
 * contain all of the elements in the specified collection, whatever the
 * given collection's subinterface or implementation type. In other
 * words, it allows you to convert the collection's type.
 * <p>
 * . Suppose, for example, that you have a Collection<String> c, which
 * may be a List, a Set, or another kind of Collection. This idiom
 * creates a new ArrayList (an implementation of the List interface),
 * initially containing all the elements in c: List<String> list = new
 * ArrayList<String>(c); Or � if you are using JDK 7 or later � you can
 * use the diamond operator: List<String> list = new ArrayList<>(c);
 * <p>
 * . The Collection interface contains methods that perform basic
 * operations, such as int size(), boolean isEmpty(), boolean
 * contains(Object element), boolean add(E element), boolean
 * remove(Object element), and Iterator<E> iterator().
 * <p>
 * . It also contains methods that operate on entire collections, such
 * as boolean containsAll(Collection<?> c), boolean addAll(Collection<?
 * extends E> c), boolean removeAll(Collection<?> c), boolean
 * retainAll(Collection<?> c), and void clear().
 * <p>
 * . Additional methods for array operations (such as Object[] toArray()
 * and <T> T[] toArray(T[] a) exist as well.
 * <p>
 * . In JDK 8 and later, the Collection interface also exposes methods
 * Stream<E> stream() and Stream<E> parallelStream(), for obtaining
 * sequential or parallel streams from the underlying collection.
 * <p>
 * Traversing Collections:
 * <p>
 * . There are three ways to traverse collections: (1) using aggregate
 * operations (2) with the for-each construct and (3) by using
 * Iterators.
 * <p>
 * 1.Aggregate Operations: ----------------------- - In JDK 8 and later,
 * the preferred method of iterating over a collection is to obtain a
 * stream and perform aggregate operations on it. Aggregate operations
 * are often used in conjunction with lambda expressions to make
 * programming more expressive, using less lines of code. The following
 * code sequentially iterates through a collection of shapes and prints
 * out the red objects:
 * <p>
 * myShapesCollection.stream().filter(shape -> shape.getColor() ==
 * Color.RED).forEach(shape -> System.out.println(shape.getName()));
 * <p>
 * - Likewise, you could easily request a parallel stream, which might
 * make sense if the collection is large enough and your computer has
 * enough cores:
 * <p>
 * myShapesCollection.parallelStream().filter(shape -> shape.getColor()
 * == Color.RED).forEach(shape -> System.out.println(shape.getName()));
 * <p>
 * - There are many different ways to collect data with this API. For
 * example, you might want to convert the elements of a Collection to
 * String objects, then join them, separated by commas:
 * <p>
 * String joined =
 * elements.stream().map(Object::toString).collect(Collectors.joining(
 * ", "));
 * <p>
 * Or perhaps sum the salaries of all employees:
 * <p>
 * int total =
 * employees.stream().collect(Collectors.summingInt(Employee::getSalary)
 * ));
 * <p>
 * - The Collections framework has always provided a number of so-called
 * "bulk operations" as part of its API. These include methods that
 * operate on entire collections, such as containsAll, addAll,
 * removeAll, etc. Do not confuse those methods with the aggregate
 * operations that were introduced in JDK 8. The key difference between
 * the new aggregate operations and the existing bulk operations
 * (containsAll, addAll, etc.) is that the old versions are all
 * mutative, meaning that they all modify the underlying collection. In
 * contrast, the new aggregate operations do not modify the underlying
 * collection. When using the new aggregate operations and lambda
 * expressions, you must take care to avoid mutation so as not to
 * introduce problems in the future, should your code be run later from
 * a parallel stream.
 * <p>
 * 2.for-each Construct: --------------------- - The for-each construct
 * allows you to concisely traverse a collection or array using a for
 * loop � see The for Statement. The following code uses the for-each
 * construct to print out each element of a collection on a separate
 * line.
 * <p>
 * for (Object o : collection) System.out.println(o);
 * <p>
 * 3.Iterators: ------------ - An Iterator is an object that enables you
 * to traverse through a collection and to remove elements from the
 * collection selectively, if desired. You get an Iterator for a
 * collection by calling its iterator method. The following is the
 * Iterator interface.
 * <p>
 * public interface Iterator<E> { boolean hasNext(); E next(); void
 * remove(); //optional } - The hasNext method returns true if the
 * iteration has more elements, and the next method returns the next
 * element in the iteration. The remove method removes the last element
 * that was returned by next from the underlying Collection. The remove
 * method may be called only once per call to next and throws an
 * exception if this rule is violated.
 * <p>
 * - Note that Iterator.remove is the only safe way to modify a
 * collection during iteration; the behavior is unspecified if the
 * underlying collection is modified in any other way while the
 * iteration is in progress.
 * <p>
 * - Use Iterator instead of the for-each construct when you need to:
 * <p>
 * . Remove the current element. The for-each construct hides the
 * iterator, so you cannot call remove. Therefore, the for-each
 * construct is not usable for filtering. . Iterate over multiple
 * collections in parallel.
 * <p>
 * - The following method shows you how to use an Iterator to filter an
 * arbitrary Collection � that is, traverse the collection removing
 * specific elements.
 * <p>
 * static void filter(Collection<?> c) { for (Iterator<?> it =
 * c.iterator(); it.hasNext(); ) if (!cond(it.next())) it.remove(); } -
 * This simple piece of code is polymorphic, which means that it works
 * for any Collection regardless of implementation. This example
 * demonstrates how easy it is to write a polymorphic algorithm using
 * the Java Collections Framework.
 * <p>
 * Collection Interface Bulk Operations:
 * <p>
 * . Bulk operations perform an operation on an entire Collection. You
 * could implement these shorthand operations using the basic
 * operations, though in most cases such implementations would be less
 * efficient. The following are the bulk operations:
 * <p>
 * containsAll � returns true if the target Collection contains all of
 * the elements in the specified Collection. addAll � adds all of the
 * elements in the specified Collection to the target Collection.
 * removeAll � removes from the target Collection all of its elements
 * that are also contained in the specified Collection. retainAll �
 * removes from the target Collection all its elements that are not also
 * contained in the specified Collection. That is, it retains only those
 * elements in the target Collection that are also contained in the
 * specified Collection. clear � removes all elements from the
 * Collection.
 * <p>
 * . The addAll, removeAll, and retainAll methods all return true if the
 * target Collection was modified in the process of executing the
 * operation.
 * <p>
 * . As a simple example of the power of bulk operations, consider the
 * following idiom to remove all instances of a specified element, e,
 * from a Collection, c.
 * <p>
 * c.removeAll(Collections.singleton(e));
 * <p>
 * More specifically, suppose you want to remove all of the null
 * elements from a Collection.
 * <p>
 * c.removeAll(Collections.singleton(null));
 * <p>
 * . This idiom uses Collections.singleton, which is a static factory
 * method that returns an immutable Set containing only the specified
 * element.
 * <p>
 * Collection Interface Array Operations:
 * <p>
 * . The toArray methods are provided as a bridge between collections
 * and older APIs that expect arrays on input. The array operations
 * allow the contents of a Collection to be translated into an array.
 * The simple form with no arguments creates a new array of Object. The
 * more complex form allows the caller to provide an array or to choose
 * the runtime type of the output array.
 * <p>
 * . For example, suppose that c is a Collection. The following snippet
 * dumps the contents of c into a newly allocated array of Object whose
 * length is identical to the number of elements in c.
 * <p>
 * Object[] a = c.toArray();
 * <p>
 * . Suppose that c is known to contain only strings (perhaps because c
 * is of type Collection<String>). The following snippet dumps the
 * contents of c into a newly allocated array of String whose length is
 * identical to the number of elements in c.
 * <p>
 * String[] a = c.toArray(new String[0]);
 */

public class A1_Collection_Interface {

    public static void main(String... args) {
        String[] colors = new String[]{"Red", "Blue", "Green", "Yellow"};
        List<String> elements = Arrays.asList(colors);

        String joined = elements.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println(joined);
        System.out.println(joined);
    }


}

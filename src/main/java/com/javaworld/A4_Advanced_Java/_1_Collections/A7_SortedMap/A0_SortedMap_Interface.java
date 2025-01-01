package com.javaworld.A4_Advanced_Java._1_Collections.A7_SortedMap;

/**
 * @author Shaik Khader
 * 
 *         A Map that further provides a total ordering on its keys. The map is
 *         ordered according to the natural ordering of its keys, or by a
 *         Comparator typically provided at sorted map creation time. This order
 *         is reflected when iterating over the sorted map's collection views
 *         (returned by the entrySet, keySet and values methods). Several
 *         additional operations are provided to take advantage of the ordering.
 * 
 *         All keys inserted into a sorted map must implement the Comparable
 *         interface (or be accepted by the specified comparator). Furthermore,
 *         all such keys must be mutually comparable: k1.compareTo(k2) (or
 *         comparator.compare(k1, k2)) must not throw a ClassCastException for
 *         any keys k1 and k2 in the sorted map. Attempts to violate this
 *         restriction will cause the offending method or constructor invocation
 *         to throw a ClassCastException.
 * 
 *         All general-purpose sorted map implementation classes should provide
 *         four "standard" constructors. It is not possible to enforce this
 *         recommendation though as required constructors cannot be specified by
 *         interfaces. The expected "standard" constructors for all sorted map
 *         implementations are:
 * 
 *         1. A void (no arguments) constructor, which creates an empty sorted
 *         map sorted according to the natural ordering of its keys.
 * 
 *         2. A constructor with a single argument of type Comparator, which
 *         creates an empty sorted map sorted according to the specified
 *         comparator.
 * 
 *         3. A constructor with a single argument of type Map, which creates a
 *         new map with the same key-value mappings as its argument, sorted
 *         according to the keys' natural ordering.
 * 
 *         4. A constructor with a single argument of type SortedMap, which
 *         creates a new sorted map with the same key-value mappings and the
 *         same ordering as the input sorted map.
 * 
 *         Note: several methods return submaps with restricted key ranges. Such
 *         ranges are half-open, that is, they include their low endpoint but
 *         not their high endpoint (where applicable). If you need a closed
 *         range (which includes both endpoints), and the key type allows for
 *         calculation of the successor of a given key, merely request the
 *         subrange from lowEndpoint to successor(highEndpoint). For example,
 *         suppose that m is a map whose keys are strings. The following idiom
 *         obtains a view containing all of the key-value mappings in m whose
 *         keys are between low and high, inclusive:
 * 
 *         SortedMap<String, V> sub = m.subMap(low, high+"\0");
 * 
 *         A similar technique can be used to generate an open range (which
 *         contains neither endpoint). The following idiom obtains a view
 *         containing all of the key-value mappings in m whose keys are between
 *         low and high, exclusive:
 * 
 *         SortedMap<String, V> sub = m.subMap(low+"\0", high);
 * 
 * 
 */

public class A0_SortedMap_Interface {
	public static void main(String... args) {

	}

}

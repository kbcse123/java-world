package com.javaworld.A4_Advanced_Java._1_Collections.A5_SortedSet;

/**
 * @author Shaik Khader
 * 
 *         A Set that further provides a total ordering on its elements. The
 *         elements are ordered using their natural ordering, or by a Comparator
 *         typically provided at creation time. The set's iterator will traverse
 *         the set in ascending element order. Several additional operations are
 *         provided to take advantage of the ordering. All elements inserted
 *         into a sorted set must implement the Comparable interface (or be
 *         accepted by the specified comparator).
 * 
 *         Note that the ordering maintained by a sorted set (whether or not an
 *         explicit comparator is provided) must be consistent with equals if
 *         the sorted set is to correctly implement the Set interface.This is so
 *         because the Set interface is defined in terms of the equals
 *         operation, but a sorted set performs all element comparisons using
 *         its compareTo (or compare) method, so two elements that are deemed
 *         equal by this method are, from the standpoint of the sorted set,
 *         equal.
 * 
 *         Note: several methods return subsets with restricted ranges. Such
 *         ranges are half-open, that is, they include their low endpoint but
 *         not their high endpoint (where applicable). If you need a closed
 *         range (which includes both endpoints), and the element type allows
 *         for calculation of the successor of a given value, merely request the
 *         subrange from lowEndpoint to successor(highEndpoint). For example,
 *         suppose that s is a sorted set of strings. The following idiom
 *         obtains a view containing all of the strings in s from low to high,
 *         inclusive:
 * 
 *         SortedSet<String> sub = s.subSet(low, high+"\0");
 * 
 *         A similar technique can be used to generate an open range (which
 *         contains neither endpoint). The following idiom obtains a view
 *         containing all of the Strings in s from low to high, exclusive:
 * 
 *         SortedSet<String> sub = s.subSet(low+"\0", high);
 * 
 */

public class A0_Sorted_Set_Interface {
}

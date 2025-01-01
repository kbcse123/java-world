package com.javaworld.A4_Advanced_Java._1_Collections.A6_Map;

/**
 * @author Shaik Khader
 * 
 *         This class implements the Map interface with a hash table, using
 *         reference-equality in place of object-equality when comparing keys
 *         (and values). In other words, in an IdentityHashMap, two keys k1 and
 *         k2 are considered equal if and only if (k1==k2).
 * 
 *         This class is not a general-purpose Map implementation! While this
 *         class implements the Map interface, it intentionally violates Map's
 *         general contract, which mandates the use of the equals method when
 *         comparing objects. This class is designed for use only in the rare
 *         cases wherein reference-equality semantics are required.
 * 
 *         This class provides all of the optional map operations, and permits
 *         null values and the null key. This class makes no guarantees as to
 *         the order of the map; in particular, it does not guarantee that the
 *         order will remain constant over time.
 * 
 *         This class provides constant-time performance for the basic
 *         operations (get and put), assuming the system identity hash function
 *         (System.identityHashCode(Object)) disperses elements properly among
 *         the buckets.
 * 
 *         This class has one tuning parameter (which affects performance but
 *         not semantics): expected maximum size. This parameter is the maximum
 *         number of key-value mappings that the map is expected to hold.
 *         Internally, this parameter is used to determine the number of buckets
 *         initially comprising the hash table. The precise relationship between
 *         the expected maximum size and the number of buckets is unspecified.
 * 
 *         If the size of the map (the number of key-value mappings)
 *         sufficiently exceeds the expected maximum size, the number of buckets
 *         is increased. Increasing the number of buckets ("rehashing") may be
 *         fairly expensive
 * 
 *         Note that this implementation is not synchronized. To do so use the
 *         below idiom:
 * 
 *         Map ihm = Collections.synchronizedMap(new IdentityHashMap(...));
 * 
 *         The iterators returned by the iterator method are fail-fast.
 * 
 *         Implementation note: This is a simple linear-probe hash table, as
 *         described for example in texts by Sedgewick and Knuth. The array
 *         alternates holding keys and values. (This has better locality for
 *         large tables than does using separate arrays.) For many JRE
 *         implementations and operation mixes, this class will yield better
 *         performance than HashMap (which uses chaining rather than
 *         linear-probing).
 * 
 *         One case where you can use IdentityHashMap is if your keys are User
 *         defined data type.
 * 
 *         Benefits: Because of reference equality, IdentityHashMap is faster
 *         and leaves a much smaller memory footprint compared to HashMap for
 *         large cardinalities.
 * 
 *         IdentityHashMap v/s HashMap:
 * 
 *         IdentityHashMap uses equality operator �==� for comparing keys and
 *         values while HashMap uses equals method.
 * 
 *         Since IdentityHashMap doesn�t use equals() its comparatively faster
 *         than HashMap for object with expensive equals().
 * 
 *         IdentityHashMap doesn�t require keys to be immutable as it is not
 *         relied on equals().
 * 
 * 
 */

public class A3_Identity_Hash_Map {
	public static void main(String... args) {

	}

}

package com.javaworld.A4_Advanced_Java._1_Collections.A7_SortedMap;

/**
 * @author Shaik Khader
 * 
 *         A SortedMap extended with navigation methods returning the closest
 *         matches for given search targets. Methods lowerEntry, floorEntry,
 *         ceilingEntry, and higherEntry return Map.Entry objects associated
 *         with keys respectively less than, less than or equal, greater than or
 *         equal, and greater than a given key, returning null if there is no
 *         such key. Similarly, methods lowerKey, floorKey, ceilingKey, and
 *         higherKey return only the associated keys. All of these methods are
 *         designed for locating, not traversing entries.
 * 
 *         A NavigableMap may be accessed and traversed in either ascending or
 *         descending key order. The descendingMap method returns a view of the
 *         map with the senses of all relational and directional methods
 *         inverted. The performance of ascending operations and views is likely
 *         to be faster than that of descending ones. Methods subMap, headMap,
 *         and tailMap differ from the like-named SortedMap methods in accepting
 *         additional arguments describing whether lower and upper bounds are
 *         inclusive versus exclusive. Submaps of any NavigableMap must
 *         implement the NavigableMap interface.
 * 
 *         This interface additionally defines methods firstEntry,
 *         pollFirstEntry, lastEntry, and pollLastEntry that return and/or
 *         remove the least and greatest mappings, if any exist, else returning
 *         null.
 * 
 *         Implementations of entry-returning methods are expected to return
 *         Map.Entry pairs representing snapshots of mappings at the time they
 *         were produced, and thus generally do not support the optional
 *         Entry.setValue method. Note however that it is possible to change
 *         mappings in the associated map using method put.
 * 
 *         Methods subMap(K, K), headMap(K), and tailMap(K) are specified to
 *         return SortedMap to allow existing implementations of SortedMap to be
 *         compatibly retrofitted to implement NavigableMap, but extensions and
 *         implementations of this interface are encouraged to override these
 *         methods to return NavigableMap. Similarly, SortedMap.keySet() can be
 *         overriden to return NavigableSet.
 * 
 *         Methods:
 * 
 *         ceilingEntry(K key): Returns a key-value mapping associated with the
 *         least key greater than or equal to the given key, or null if there is
 *         no such key.
 * 
 *         ceilingKey(K key): Returns the least key greater than or equal to the
 *         given key, or null if there is no such key.
 * 
 *         descendingKeySet(): Returns a reverse order NavigableSet view of the
 *         keys contained in this map.
 * 
 *         descendingMap(): Returns a reverse order view of the mappings
 *         contained in this map.
 * 
 *         firstEntry(): Returns a key-value mapping associated with the least
 *         key in this map, or null if the map is empty.
 * 
 *         floorEntry(K key): Returns a key-value mapping associated with the
 *         greatest key less than or equal to the given key, or null if there is
 *         no such key.
 * 
 *         floorKey(K key): Returns the greatest key less than or equal to the
 *         given key, or null if there is no such key.
 * 
 *         headMap(K toKey): Returns a view of the portion of this map whose
 *         keys are strictly less than toKey.
 * 
 *         headMap(K toKey, boolean inclusive): Returns a view of the portion of
 *         this map whose keys are less than (or equal to, if inclusive is true)
 *         toKey.
 * 
 *         higherEntry(K key): Returns a key-value mapping associated with the
 *         least key strictly greater than the given key, or null if there is no
 *         such key.
 * 
 *         higherKey(K key): Returns the least key strictly greater than the
 *         given key, or null if there is no such key.
 * 
 *         lastEntry(): Returns a key-value mapping associated with the greatest
 *         key in this map, or null if the map is empty.
 * 
 *         lowerEntry(K key): Returns a key-value mapping associated with the
 *         greatest key strictly less than the given key, or null if there is no
 *         such key.
 * 
 *         lowerKey(K key): Returns the greatest key strictly less than the
 *         given key, or null if there is no such key.
 * 
 *         navigableKeySet(): Returns a NavigableSet view of the keys contained
 *         in this map.
 * 
 *         pollFirstEntry(): Removes and returns a key-value mapping associated
 *         with the least key in this map, or null if the map is empty.
 * 
 *         pollLastEntry(): Removes and returns a key-value mapping associated
 *         with the greatest key in this map, or null if the map is empty.
 * 
 *         subMap(K fromKey, boolean fromInclusive, K toKey, boolean
 *         toInclusive): Returns a view of the portion of this map whose keys
 *         range from fromKey to toKey.
 * 
 *         subMap(K fromKey, K toKey): Returns a view of the portion of this map
 *         whose keys range from fromKey, inclusive, to toKey, exclusive.
 * 
 *         tailMap(K fromKey): Returns a view of the portion of this map whose
 *         keys are greater than or equal to fromKey.
 * 
 *         tailMap(K fromKey, boolean inclusive): Returns a view of the portion
 *         of this map whose keys are greater than (or equal to, if inclusive is
 *         true) fromKey.
 * 
 * 
 * 
 */

public class A1_NavigableMap_Interface {
	public static void main(String... args) {

	}

}

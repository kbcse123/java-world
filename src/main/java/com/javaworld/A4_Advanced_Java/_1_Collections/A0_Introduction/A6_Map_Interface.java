package com.javaworld.A4_Advanced_Java._1_Collections.A0_Introduction;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Shaik Khader
 * 
 *         . A Map is an object that maps keys to values. A map cannot contain
 *         duplicate keys: Each key can map to at most one value. It models the
 *         mathematical function abstraction. The Map interface includes methods
 *         for basic operations (such as put, get, remove, containsKey,
 *         containsValue, size, and empty), bulk operations (such as putAll and
 *         clear), and collection views (such as keySet, entrySet, and values).
 * 
 *         . The Java platform contains three general-purpose Map
 *         implementations: HashMap, TreeMap, and LinkedHashMap. Their behavior
 *         and performance are precisely analogous to HashSet, TreeSet, and
 *         LinkedHashSet, as described in The Set Interface section.
 * 
 *         . The remainder of this page discusses the Map interface in detail.
 *         But first, here are some more examples of collecting to Maps using
 *         JDK 8 aggregate operations. Modeling real-world objects is a common
 *         task in object-oriented programming, so it is reasonable to think
 *         that some programs might, for example, group employees by department:
 * 
 *         // Group employees by department Map<Department, List<Employee>>
 *         byDept = employees.stream().collect(Collectors.groupingBy(Employee::
 *         getDepartment));
 * 
 *         - Or compute the sum of all salaries by department:
 * 
 *         // Compute sum of salaries by department Map<Department, Integer>
 *         totalByDept =
 *         employees.stream().collect(Collectors.groupingBy(Employee::
 *         getDepartment,Collectors.summingInt(Employee::getSalary)));
 * 
 *         - Or perhaps group students by passing or failing grades:
 * 
 *         // Partition students into passing and failing Map<Boolean, List
 *         <Student>> passingFailing =
 *         students.stream().collect(Collectors.partitioningBy(s ->
 *         s.getGrade()>= PASS_THRESHOLD));
 * 
 *         - You could also group people by city:
 * 
 *         // Classify Person objects by city Map<String, List<Person>>
 *         peopleByCity =
 *         personStream.collect(Collectors.groupingBy(Person::getCity));
 * 
 *         - Or even cascade two collectors to classify people by state and
 *         city:
 * 
 *         // Cascade Collectors Map<String, Map<String, List<Person>>>
 *         peopleByStateAndCity =
 *         personStream.collect(Collectors.groupingBy(Person::getState,
 *         Collectors.groupingBy(Person::getCity)))
 * 
 *         . Again, these are but a few examples of how to use the new JDK 8
 *         APIs. For in-depth coverage of lambda expressions and aggregate
 *         operations see the lesson entitled Aggregate Operations.
 * 
 *         Map Interface Basic Operations:
 * 
 *         . The basic operations of Map (put, get, containsKey, containsValue,
 *         size, and isEmpty) behave exactly like their counterparts in
 *         Hashtable. The below program generates a frequency table of the words
 *         that maps each word to the number of times it occurs in the array.
 * 
 *         . The only tricky thing about this program is the second argument of
 *         the put statement. That argument is a conditional expression that has
 *         the effect of setting the frequency to one if the word has never been
 *         seen before or one more than its current value if the word has
 *         already been seen.
 * 
 *         . Suppose you'd prefer to see the frequency table in alphabetical
 *         order. All you have to do is change the implementation type of the
 *         Map from HashMap to TreeMap.
 * 
 *         . Similarly, you could make the program print the frequency table in
 *         the order the words first appear on the command line simply by
 *         changing the implementation type of the map to LinkedHashMap.
 * 
 *         . This flexibility provides a potent illustration of the power of an
 *         interface-based framework.
 * 
 *         . Like the Set and List interfaces, Map strengthens the requirements
 *         on the equals and hashCode methods so that two Map objects can be
 *         compared for logical equality without regard to their implementation
 *         types. Two Map instances are equal if they represent the same
 *         key-value mappings.
 * 
 *         . By convention, all general-purpose Map implementations provide
 *         constructors that take a Map object and initialize the new Map to
 *         contain all the key-value mappings in the specified Map. This
 *         standard Map conversion constructor is entirely analogous to the
 *         standard Collection constructor: It allows the caller to create a Map
 *         of a desired implementation type that initially contains all of the
 *         mappings in another Map, regardless of the other Map's implementation
 *         type. For example, suppose you have a Map, named m. The following
 *         one-liner creates a new HashMap initially containing all of the same
 *         key-value mappings as m.
 * 
 *         Map<K, V> copy = new HashMap<K, V>(m);
 * 
 *         Collection Views:
 * 
 *         . The Collection view methods allow a Map to be viewed as a
 *         Collection in these three ways:
 * 
 *         keySet � the Set of keys contained in the Map. values � The
 *         Collection of values contained in the Map. This Collection is not a
 *         Set, because multiple keys can map to the same value. entrySet � the
 *         Set of key-value pairs contained in the Map. The Map interface
 *         provides a small nested interface called Map.Entry, the type of the
 *         elements in this Set.
 * 
 *         . At first, many people worry that these idioms may be slow because
 *         the Map has to create a new Collection instance each time a
 *         Collection view operation is called. Rest easy: There's no reason
 *         that a Map cannot always return the same object each time it is asked
 *         for a given Collection view. This is precisely what all the Map
 *         implementations in java.util do.
 * 
 *         . With all three Collection views, calling an Iterator's remove
 *         operation removes the associated entry from the backing Map, assuming
 *         that the backing Map supports element removal to begin with.
 * 
 *         . With the entrySet view, it is also possible to change the value
 *         associated with a key by calling a Map.Entry's setValue method during
 *         iteration (again, assuming the Map supports value modification to
 *         begin with). Note that these are the only safe ways to modify a Map
 *         during iteration; the behavior is unspecified if the underlying Map
 *         is modified in any other way while the iteration is in progress.
 * 
 *         . The Collection views support element removal in all its many forms
 *         � remove, removeAll, retainAll, and clear operations, as well as the
 *         Iterator.remove operation. (Yet again, this assumes that the backing
 *         Map supports element removal).
 * 
 *         . The Collection views do not support element addition under any
 *         circumstances. It would make no sense for the keySet and values
 *         views, and it's unnecessary for the entrySet view, because the
 *         backing Map's put and putAll methods provide the same functionality.
 * 
 *         Fancy Uses of Collection Views: Map Algebra:
 * 
 *         . When applied to the Collection views, bulk operations (containsAll,
 *         removeAll, and retainAll) are surprisingly potent tools. For
 *         starters, suppose you want to know whether one Map is a submap of
 *         another � that is, whether the first Map contains all the key-value
 *         mappings in the second. The following idiom does the trick.
 * 
 *         if (m1.entrySet().containsAll(m2.entrySet())) { ... }
 * 
 *         . Along similar lines, suppose you want to know whether two Map
 *         objects contain mappings for all of the same keys.
 * 
 *         if (m1.keySet().equals(m2.keySet())) { ... }
 * 
 *         . Suppose you want to know all the keys common to two Map objects.
 * 
 *         Set<KeyType>commonKeys = new HashSet<KeyType>(m1.keySet());
 *         commonKeys.retainAll(m2.keySet());
 * 
 *         . All the idioms presented thus far have been nondestructive; that
 *         is, they don't modify the backing Map. Here are a few that do.
 *         Suppose you want to remove all of the key-value pairs that one Map
 *         has in common with another.
 * 
 *         m1.entrySet().removeAll(m2.entrySet());
 * 
 *         . Suppose you want to remove from one Map all of the keys that have
 *         mappings in another.
 * 
 *         m1.keySet().removeAll(m2.keySet());
 * 
 *         . What happens when you start mixing keys and values in the same bulk
 *         operation? Suppose you have a Map, managers, that maps each employee
 *         in a company to the employee's manager. We'll be deliberately vague
 *         about the types of the key and the value objects. It doesn't matter,
 *         as long as they're the same. Now suppose you want to know who all the
 *         "individual contributors" (or nonmanagers) are. The following snippet
 *         tells you exactly what you want to know.
 * 
 *         Set<Employee> individualContributors = new HashSet
 *         <Employee>(managers.keySet());
 *         individualContributors.removeAll(managers.values());
 * 
 *         . Suppose you want to fire all the employees who report directly to
 *         some manager, Simon.
 * 
 *         Employee simon = ... ;
 *         managers.values().removeAll(Collections.singleton(simon));
 * 
 *         . Note that this idiom makes use of Collections.singleton, a static
 *         factory method that returns an immutable Set with the single,
 *         specified element.
 * 
 *         . Once you've done this, you may have a bunch of employees whose
 *         managers no longer work for the company (if any of Simon's
 *         direct-reports were themselves managers). The following code will
 *         tell you which employees have managers who no longer works for the
 *         company.
 * 
 *         Map<Employee, Employee> m = new HashMap<Employee,
 *         Employee>(managers); m.values().removeAll(managers.keySet()); Set
 *         <Employee> slackers = m.keySet();
 * 
 *         . This example is a bit tricky. First, it makes a temporary copy of
 *         the Map, and it removes from the temporary copy all entries whose
 *         (manager) value is a key in the original Map. Remember that the
 *         original Map has an entry for each employee. Thus, the remaining
 *         entries in the temporary Map comprise all the entries from the
 *         original Map whose (manager) values are no longer employees. The keys
 *         in the temporary copy, then, represent precisely the employees that
 *         we're looking for.
 * 
 *         Multimaps:
 * 
 *         . A multimap is like a Map but it can map each key to multiple
 *         values. The Java Collections Framework doesn't include an interface
 *         for multimaps because they aren't used all that commonly. It's a
 *         fairly simple matter to use a Map whose values are List instances as
 *         a multimap. This technique is demonstrated in the next code example,
 *         which reads a word list containing one word per line (all lowercase)
 *         and prints out all the anagram groups that meet a size criterion. An
 *         anagram group is a bunch of words, all of which contain exactly the
 *         same letters but in a different order.
 * 
 *         . There is a standard trick for finding anagram groups: For each word
 *         in the dictionary, alphabetize the letters in the word (that is,
 *         reorder the word's letters into alphabetical order) and put an entry
 *         into a multimap, mapping the alphabetized word to the original word.
 *         For example, the word bad causes an entry mapping abd into bad to be
 *         put into the multimap. A moment's reflection will show that all the
 *         words to which any given key maps form an anagram group. It's a
 *         simple matter to iterate over the keys in the multimap, printing out
 *         each anagram group that meets the size constraint.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class A6_Map_Interface {

	public static void main(String... args) {
		String[] values = { "hi", "there", "how", "are", "you", "you", "are", "looking", "good" };

		Map<String, Integer> hash = new HashMap<String, Integer>();
		printValues(hash, "unordered: using HashMap", values);
		Map<String, Integer> linkedHash = new LinkedHashMap<String, Integer>();
		printValues(linkedHash, "ordered: using LinkedHashMap", values);
		Map<String, Integer> tree = new TreeMap<String, Integer>();
		printValues(tree, "Natural order: using TreeMap", values);

		System.out.println("\n**** keySet() ****");
		for (String key : tree.keySet())
			System.out.println(key);

		System.out.println("\n**** values() ****");
		for (int value : tree.values())
			System.out.println(value);

		System.out.println("\n**** entrySet() ****");
		for (Map.Entry<String, Integer> e : tree.entrySet())
			System.out.println(e.getKey() + ": " + e.getValue());

		System.out.println("\n**** Using iterator ****");
		for (Iterator<String> keyIt = tree.keySet().iterator(); keyIt.hasNext();)
			System.out.println(keyIt.next());

		Anagrams.execute();

	}

	private static void printValues(Map<String, Integer> m, String type, String... values) {
		// Initialize frequency table
		for (String a : values) {
			Integer freq = m.get(a);
			m.put(a, (freq == null) ? 1 : freq + 1);
		}
		System.out.println("\n**** " + type + " ****");
		System.out.println(m.size() + " distinct words:\n" + m);

	}

}

class Anagrams {
	public static void execute() {
		System.out.println("**** Multimaps Example ****");

		int minGroupSize = 1;

		Map<String, List<String>> mm = new HashMap<String, List<String>>();

		// Read words from file and put into a simulated multimap
		try (FileInputStream fis = new FileInputStream("src\\main\\resources\\inputFile.txt")) {
			Scanner s = new Scanner(fis);
			while (s.hasNext()) {
				String word = s.next();
				System.out.println("word = " + word);
				String alpha = alphabetize(word);
				List<String> l = mm.get(alpha);
				if (l == null)
					mm.put(alpha, l = new ArrayList<String>());
				l.add(word);
			}
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}

		// Print all permutation groups above size threshold
		for (List<String> l : mm.values())
			if (l.size() >= minGroupSize)
				System.out.println(l.size() + ": " + l);
	}

	private static String alphabetize(String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}
}

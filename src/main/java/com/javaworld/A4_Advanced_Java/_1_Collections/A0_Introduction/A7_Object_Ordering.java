package com.javaworld.A4_Advanced_Java._1_Collections.A0_Introduction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Shaik Khader
 * 
 *         A List l may be sorted as follows.
 * 
 *         Collections.sort(l);
 * 
 *         If the List consists of String elements, it will be sorted into
 *         alphabetical order. If it consists of Date elements, it will be
 *         sorted into chronological order. How does this happen? String and
 *         Date both implement the Comparable interface. Comparable
 *         implementations provide a natural ordering for a class, which allows
 *         objects of that class to be sorted automatically. The
 *         'classes_implementing_comparable.png' summarizes some of the more
 *         important Java platform classes that implement Comparable.
 * 
 *         If you try to sort a list, the elements of which do not implement
 *         Comparable, Collections.sort(list) will throw a ClassCastException.
 *         Similarly, Collections.sort(list, comparator) will throw a
 *         ClassCastException if you try to sort a list whose elements cannot be
 *         compared to one another using the comparator. Elements that can be
 *         compared to one another are called mutually comparable. Although
 *         elements of different types may be mutually comparable, none of the
 *         classes listed here permit interclass comparison.
 * 
 *         This is all you really need to know about the Comparable interface if
 *         you just want to sort lists of comparable elements or to create
 *         sorted collections of them. The next section will be of interest to
 *         you if you want to implement your own Comparable type.
 * 
 *         Writing Your Own Comparable Types:
 * 
 *         The Comparable interface consists of the following method.
 * 
 *         public interface Comparable<T> { public int compareTo(T o); }
 * 
 *         The compareTo method compares the receiving object with the specified
 *         object and returns a negative integer, 0, or a positive integer
 *         depending on whether the receiving object is less than, equal to, or
 *         greater than the specified object. If the specified object cannot be
 *         compared to the receiving object, the method throws a
 *         ClassCastException.
 * 
 *         The Name's compareTo method implements the standard name-ordering
 *         algorithm, where last names take precedence over first names. This is
 *         exactly what you want in a natural ordering. It would be very
 *         confusing indeed if the natural ordering were unnatural!
 * 
 *         Comparators:
 * 
 *         What if you want to sort some objects in an order other than their
 *         natural ordering? Or what if you want to sort some objects that don't
 *         implement Comparable? To do either of these things, you'll need to
 *         provide a Comparator � an object that encapsulates an ordering. Like
 *         the Comparable interface, the Comparator interface consists of a
 *         single method.
 * 
 *         public interface Comparator<T> { int compare(T o1, T o2); }
 * 
 *         The compare method compares its two arguments, returning a negative
 *         integer, 0, or a positive integer depending on whether the first
 *         argument is less than, equal to, or greater than the second. If
 *         either of the arguments has an inappropriate type for the Comparator,
 *         the compare method throws a ClassCastException.
 * 
 *         Much of what was said about Comparable applies to Comparator as well.
 *         Writing a compare method is nearly identical to writing a compareTo
 *         method, except that the former gets both objects passed in as
 *         arguments. The compare method has to obey the same four technical
 *         restrictions as Comparable's compareTo method for the same reason � a
 *         Comparator must induce a total order on the objects it compares.
 * 
 *         The below program displays a list of employees in order of seniority.
 *         The Comparator in the program is reasonably straightforward. It
 *         relies on the natural ordering of Date applied to the values returned
 *         by the hireDate accessor method.
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
 * 
 * 
 * 
 * 
 */

class Name implements Comparable<Name> {
	private final String firstName, lastName;

	public Name(String firstName, String lastName) {
		if (firstName == null || lastName == null)
			throw new NullPointerException();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean equals(Object o) {
		if (o.getClass() != getClass())
			return false;
		Name n = (Name) o;
		return n.getFirstName().equals(firstName) && n.getLastName().equals(lastName);
	}

	public int hashCode() {
		return Objects.hash(firstName, lastName); // 31*firstName.hashCode() + lastName.hashCode();
	}

	public String toString() {
		return firstName + " " + lastName;
	}

	public int compareTo(Name n) {
		int lastNameCmp = lastName.compareTo(n.lastName);
		return (lastNameCmp != 0 ? lastNameCmp : firstName.compareTo(n.firstName));
	}

}

class NameSort {
	public static void execute() {
		System.out.println("*** Comparable Demo: Sorting based on last name ***");
		Name nameArray[] = { new Name("Shaik", "Khader"), new Name("Dane", "Jashua"), new Name("Mohan", "Upreti"), };

		List<Name> names = Arrays.asList(nameArray);
		Collections.sort(names);
		System.out.println(names);
	}
}

class Employee {
	private final String firstName, lastName;
	private Date hiredDate;
	private int empId;

	public Employee(int empId, String firstName, String lastName, Date hiredDate) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hiredDate = hiredDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getHiredDate() {
		return hiredDate;
	}

	public int getEmpId() {
		return empId;
	}

	public boolean equals(Object o) {
		if (o.getClass() != getClass())
			return false;
		Employee n = (Employee) o;
		return n.getFirstName().equals(firstName) && n.getLastName().equals(lastName);
	}

	public int hashCode() {
		return Objects.hash(firstName, lastName); // 31*firstName.hashCode() + lastName.hashCode();
	}

	public String toString() {
		return firstName + " " + lastName;
	}

	public int compareTo(Employee n) {
		int lastNameCmp = lastName.compareTo(n.lastName);
		return (lastNameCmp != 0 ? lastNameCmp : firstName.compareTo(n.firstName));
	}
}

class EmpSort {
	static final Comparator<Employee> SENIORITY_ORDER = new Comparator<Employee>() {
		public int compare(Employee e1, Employee e2) {
			int dateCmp = e1.getHiredDate().compareTo(e2.getHiredDate());
			if (dateCmp != 0)
				return dateCmp;
			return e1.getEmpId() - e2.getEmpId();
		}
	};
	static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

	public static void execute() throws ParseException {
		System.out.println("*** Comparator Demo: Sorting based on hired date and emp id ***");
		List<Employee> e = new ArrayList<Employee>();
		e.add(new Employee(3, "Shaik", "Khader", sdf.parse("01-Dec-2016")));
		e.add(new Employee(1, "Dane", "Jashua", sdf.parse("19-Jan-2016")));
		e.add(new Employee(2, "Mohan", "Upreti", sdf.parse("19-Jan-2016")));

		Collections.sort(e, SENIORITY_ORDER);
		System.out.println(e);
	}
}

public class A7_Object_Ordering {
	public static void main(String... args) throws Exception {

		NameSort.execute();

		EmpSort.execute();

	}

}

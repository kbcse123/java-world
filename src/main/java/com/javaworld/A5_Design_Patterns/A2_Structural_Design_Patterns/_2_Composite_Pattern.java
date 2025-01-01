package com.javaworld.A5_Design_Patterns.A2_Structural_Design_Patterns;
/**
 * 
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shaik Khader
 * 
 *         Composite pattern is used where we need to treat a group of objects
 *         in similar way as a single object. Composite pattern composes objects
 *         in term of a tree structure to represent part as well as whole
 *         hierarchy.
 * 
 */

class Employee {
	private String name;
	private String dept;
	private int salary;
	private List<Employee> subordinates;

	// constructor
	public Employee(String name, String dept, int sal) {
		this.name = name;
		this.dept = dept;
		this.salary = sal;
		subordinates = new ArrayList<Employee>();
	}

	public void add(Employee e) {
		subordinates.add(e);
	}

	public void remove(Employee e) {
		subordinates.remove(e);
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	@Override
	public String toString() {
		return ("Employee -> Name: " + name + ", dept : " + dept + ", salary:" + salary);
	}
}

public class _2_Composite_Pattern {
	public static void main(String... args) {
		Employee CEO = new Employee("John", "CEO", 30000);

		Employee headSales = new Employee("Robert", "Head Sales", 20000);

		Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);

		Employee clerk1 = new Employee("Laura", "Marketing", 10000);
		Employee clerk2 = new Employee("Bob", "Marketing", 10000);

		Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
		Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

		CEO.add(headSales);
		CEO.add(headMarketing);

		headSales.add(salesExecutive1);
		headSales.add(salesExecutive2);

		headMarketing.add(clerk1);
		headMarketing.add(clerk2);

		// print all employees of the organization
		System.out.println(CEO);
		System.out.println("\n*** Sub ordinates ***");

		for (Employee employee : CEO.getSubordinates()) {
			System.out.println(employee);
			for (Employee subOrdinate : employee.getSubordinates()) {
				System.out.println(subOrdinate);
			}
		}
	}

}

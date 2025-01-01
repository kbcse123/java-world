package com.javaworld.A1_Core_Java.A1_OOP_Concepts;
import java.util.ArrayList;
import java.util.List;

/**
 * The process of providing proper access to the object's state(data members) and behaviors(members functions)
 * in order to protect from other objects. This is done using access modifiers (private, protected and public). 
 * 
 * In this process we wrap the code and data together into a single unit(capsule), 'Class' is the best example
 * of encapsulation.
 * 
 * ADVANTAGES:
 * 
 * 	.FLEXIBLE - With changing requirements you can easily change the encapsulated Code.
 * 
 * 	.TOTAL CONTROL - A class can have total control over what must be stored in its fields. Suppose you want
 * 		to set the rule that 'marks' field value should always be positive, then you can write the logic of
 * 		validation in setter method.
 * 
 * 	.READ ONLY CLASSES - By providing only getter method access, you can make the class read only.
 * 
 * 	.IMMUTABLE CLASSES - Encapsulation also helps to write immutable classes which are a good choice in 
 *   	multi-threaded environments.
 * 
 * Relation with Abstraction:
 * 
 * - Abstraction is more about 'What' functionality a class can offer (Specification).
 * 
 * - Encapsulation is more about 'How' to achieve that functionality (Implementation).
 */


class Address {
	
	public String country;
	public String city;
	protected String street;

	public Address() {
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	protected String getStreet() {
		return street;
	}

	protected void setStreet(String street) {
		this.street = street;
	}

	public void displayAdressValues() {
		System.out.println(" Country = " + country + "\n City = " + city + "\n Street = " + street);
	}

}

class Employee extends Address {

	private int employeeId;

	private String employeeName;

	private String designation;

	public Employee() {

	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void addEmpAddressDetails(String country, String city, String street) {
		this.country = country;
		this.city = city;
		this.street = street;
	}

	public void displayEmpValues() {
		System.out.println(" Employee id = " + employeeId + "\n Employee Name = " + employeeName 
				+ "\n Designation = "+ designation);
	}

	public static List<Employee> loadEmpMockData(int listSize) {
		List<Employee> empMockList = new ArrayList<Employee>(listSize);
		for (int i = 0; i < listSize; i++) {
			Employee emp = new Employee();
			emp.setEmployeeId(i);
			emp.setEmployeeName("Shaik Khader " + i);
			emp.setDesignation("Software Engineer " + i);
			emp.addEmpAddressDetails("India", "Bangalore " + i, "R.T.Nagar " + i);
			empMockList.add(emp);
		}
		return empMockList;
	}

	public static void displayEmpMockData(List<Employee> empList) {
		for (Employee emp : empList) {
			System.out.println("id = " + emp.getEmployeeId() + "  Name = " + emp.getEmployeeName() 
			+ "  Designation = " + emp.getDesignation() + "  Country = " + emp.getCountry() 
			+ "  City = " + emp.getCity() + "  Street = " + emp.getStreet());
		}
	}

	public static Employee newInstance() {
		return new Employee();
	}

}

public class A2_Encapsulation {
	
	public static void main(String[] args) {
		Employee emp = Employee.newInstance();
		// emp.employeeId = 123; //illegal
		// employeeId = 123; // illegal
		emp.setEmployeeId(123);
		emp.setEmployeeName("Shaik Khader");
		emp.setDesignation("Software Engineer");
		emp.addEmpAddressDetails("India", "Bangalore", "R.T.Nagar");
		emp.displayEmpValues();
		emp.displayAdressValues();
		System.out.println("\n ---- With Restricted Access ----");
		Address adrs = new Address();
		adrs.setCountry("India");
		adrs.setCity("Bangalore");
		// adrs.setStreet("R.T.Nagar"); //cannot access, protected state
		adrs.displayAdressValues();
	}
}
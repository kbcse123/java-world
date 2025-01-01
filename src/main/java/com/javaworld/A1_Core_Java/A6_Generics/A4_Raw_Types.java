package com.javaworld.A1_Core_Java.A6_Generics; /**
 * . A raw type is the name of a generic class or interface without any type arguments. For example, the GenericBox class:
       GenericBox rawBox = new GenericBox();
 *   
 * . Here, GenericBox is the raw type of the generic type GenericBox<T>. However, a non-generic class or interface type
 *   is not a raw type. 
 *   
 * . Raw types show up in legacy code because lots of API classes (such as the Collections classes) were not generic prior 
 *   to JDK 5.0. 
 *   
 * . When using raw types, you essentially get pre-generics behavior.
 *  
 * . For backward compatibility, assigning a parameterized type to its raw type is allowed: 
       GenericBox <String> stringBox = new GenericBox<>(); 
       GenericBox rawBox = stringBox; // OK
 * 
 * . But if you assign a raw type to a parameterized type, you get a warning:
 *     GenericBox rawBox = new GenericBox(); // rawBox is a raw type of GenericBox<T>
 *     GenericBox<Integer> intBox = rawBox; // warning: unchecked conversion
 * 
 * . You also get a warning if you use a raw type to invoke generic methods defined in the corresponding generic type: 
 *     GenericBox <String> stringBox = new GenericBox<>(); 
 *     GenericBox rawBox = stringBox; 
 *     rawBox.set(8); // warning: unchecked invocation to set(T)
 * 
 *   The warning shows that raw types bypass generic type checks, deferring the catch of unsafe code to runtime. Therefore,
 *   you should avoid using raw types.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
	private int employeeId;
	private String employeeName;
	private String designation;

	public Employee(int empId, String empName, String desig) {
		employeeId = empId;
		employeeName = empName;
		designation = desig;
	}

	public static List<Employee> loadEmpMockData(int listSize) {
		List<Employee> empMockList = new ArrayList<>(listSize);
		for (int i = 0; i < listSize; i++) {
			empMockList.add(new Employee(i, "Shaik Khader " + i, "Software Engineer " + i));
		}
		return empMockList;
	}

	public static void displayEmpMockData(List<Employee> empList){
		for(Employee emp : empList){
			System.out.println("id = "+emp.employeeId+
					"  Name = "+emp.employeeName+
					"  Designation = "+emp.designation);
		}
	}
}

class Customer {
	private String name;
	private int phoneNum;

	public Customer(String nm, int pNum) {
		name = nm;
		phoneNum = pNum;
	}

	public static List<Customer> loadCustomerMockdata(int listSize) {
		List<Customer> custMockdata = new ArrayList<Customer>();
		for (int i = 0; i < listSize; i++) {
			custMockdata.add(new Customer("Shaik" + i, 123 + i));
		}
		return custMockdata;
	}

	public static void displayCustomerMockData(List<Customer> custList) {
		for (Customer cust : custList) {
			System.out.println("Name = " + cust.name + "  Phone Number = " + cust.phoneNum);
		}
	}
}

public class A4_Raw_Types {
	//this map can hold objects of different types.
	static Map rawMap = new HashMap(); 

	static {
		rawMap.put("empList", Employee.loadEmpMockData(5));
		rawMap.put("custList", Customer.loadCustomerMockdata(5));
	}

	public static void main(String[] args) {
		System.out.println("****Using Explicit Type Casting****");
		Employee.displayEmpMockData((List<Employee>) rawMap.get("empList"));
		System.out.println("****Using Generic Method for Type Safety****");
		Employee.displayEmpMockData(castList(rawMap.get("empList"), Employee.class));
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("****Using Explicit Type Casting****");
		Customer.displayCustomerMockData((List<Customer>) rawMap.get("custList"));
		System.out.println("****Using Generic Method for Type Safety****");
		Customer.displayCustomerMockData(castList(rawMap.get("custList"), Customer.class));
	}

	// Generic Code for Type Safety
	public static <T> List<T> castList(Object obj, Class<T> clazz) {
		if (obj instanceof List<?>) {
			List<T> result = new ArrayList<T>();
			for (Object o : (List<?>) obj) {
				result.add(clazz.cast(o));
			}
			return result;
		}
		return null;
	}
}
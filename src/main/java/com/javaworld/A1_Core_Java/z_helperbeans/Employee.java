package com.javaworld.A1_Core_Java.z_helperbeans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shaik khader
 *
 */
public class Employee extends Address{
	
	private int employeeId;
	
	private String employeeName;
	
	private String designation;
	
	public Employee(){
		
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
	
	public void addEmpAddressDetails(String country,String city,String street){
		this.country = country;
		this.city = city;
		this.street = street;
	}
	
	public void displayEmpValues(){
		System.out.println(" Employee id = "+employeeId+
				"\n Employee Name = "+employeeName+
				"\n Designation = "+designation); 
	}
	
	public static List<Employee> loadEmpMockData(int listSize){
		
		List<Employee> empMockList = new ArrayList<Employee>(listSize);
		for(int i = 0;i<listSize;i++){
			Employee emp = new Employee();
			emp.setEmployeeId(i);
			emp.setEmployeeName("Shaik Khader "+i);
			emp.setDesignation("Software Engineer "+i);
			emp.addEmpAddressDetails("India","Bangalore "+i,"R.T.Nagar "+i);
			empMockList.add(emp);
		}
		return empMockList;
	}
	
	public static void displayEmpMockData(List<Employee> empList){
		for(Employee emp : empList){
			System.out.println("id = "+emp.getEmployeeId()+
					"  Name = "+emp.getEmployeeName()+
					"  Designation = "+emp.getDesignation()+
					"  Country = "+emp.getCountry()+
					"  City = "+emp.getCity()+
					"  Street = "+emp.getStreet()); 
			
		}
	}

	public static Employee newInstance() { 
		return new Employee();
	}
	
}	




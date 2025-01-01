package com.javaworld.A1_Core_Java.z_helperbeans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shaik Khader
 *
 */
public class Customer {
	private String name;
	private int phoneNum;

	public Customer(String name) {
		this.setName(name);
	}

	public Customer() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public static List<Customer> loadCustomerMockdata(int listSize){
		List<Customer> custMockdata = new ArrayList<Customer>();
		for(int i = 0;i<listSize;i++){
			Customer cust = new Customer();
			cust.setName("Shaik"+i);
			cust.setPhoneNum(12345+i);
			custMockdata.add(cust);
		}
		return custMockdata;
	}
	
	public static void displayCustomerMockData(List<Customer> custList){
		for(Customer cust : custList){
			System.out.println("Name = "+cust.getName()+
					"  Phone Number = "+cust.getPhoneNum()); 
		}
	}
}

package com.javaworld.A1_Core_Java.z_helperbeans;


/**
 * @author Shaik Khader
 *
 */
public class Address {
	public String country;
	public String city;
	protected String street;
	
	
	/**
	 * 
	 */
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	
	/**
	 * @return the street
	 */
	protected String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	protected void setStreet(String street) {
		this.street = street;
	}

	public void displayAdressValues(){
		System.out.println(
				" Country = "+country+
				"\n City = "+city+
				"\n Street = "+street); 
	}
	

}

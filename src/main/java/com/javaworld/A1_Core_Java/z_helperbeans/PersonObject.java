package com.javaworld.A1_Core_Java.z_helperbeans;

import java.util.Objects;

/**
 * @author Shaik khader
 *
 */
public class PersonObject {
    
    private String id;
	private String name;
	
	public PersonObject(String id,String name){
		this.id = id;
		this.name = name;
	}
	public PersonObject(){
		
	}

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals (Object obj){
    	// checking if both the object references are referring to the same object.
    	if(this == obj)
            return true;
    	if(obj == null)
            return false;
    	// if(!(obj instanceof PersonObject)) return false; ---> avoid this style.
    	if(obj.getClass()!= getClass())
            return false;
    	
    	// type casting of the argument. 
    	PersonObject personObj = (PersonObject)obj;
    	
    	return personObj.id.equals(this.id) && personObj.name.equals(this.name);
    }
    
    //31 * i == (i << 5) - i
    @Override
    public int hashCode() {
    	//JDK 7 and above.
    	return Objects.hash(name, id);
    }
    
    @Override
    public String toString(){
    	return "PersonObject: id = "+id+" name = "+name;
    }
   

  	public void printClassName() {
  	    System.out.println("The object's class is " +
  	        this.getClass().getSimpleName());
  	}
}
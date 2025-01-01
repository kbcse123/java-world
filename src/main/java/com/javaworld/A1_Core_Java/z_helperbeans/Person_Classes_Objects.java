package com.javaworld.A1_Core_Java.z_helperbeans;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.function.Supplier;

/**
 * @author Shaik Khader
 
 */


public class Person_Classes_Objects {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
    	return Period.between(birthday, LocalDate.now()).getYears();
    }

    
    public Person_Classes_Objects(){
    	
    }
    
	public Person_Classes_Objects(String name, LocalDate birthday, Sex gender, String emailAddress) {
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress= emailAddress;
	}
    

   public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	 
	public void printPerson() {
	    System.out.println(this);    
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getBirthday() {
		return birthday;
	}


	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public int compareByName(Person_Classes_Objects a, Person_Classes_Objects b) {
        return a.getName().compareTo(b.getName());
    }
	
	public static int compareByAge(Person_Classes_Objects a, Person_Classes_Objects b) {
        return a.birthday.compareTo(b.birthday);
    }
	//S - SOURCE, D - DEST
	public static <T, S extends Collection<T>, D extends Collection<T>>
    D transferElements(S sourceCollection,Supplier<D> collectionFactory) {
        
        D result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
	}
	
	public String toString(){
		
		return "name = "+name+", Gender = "+gender+", Birthday = "+birthday+", "
				+ "Email Address = "+emailAddress;
	}
	
}
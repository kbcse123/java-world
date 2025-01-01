package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;

import java.io.*;

/**
 * @author Shaik Khader
 */

class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 0L;
    public String firstName;
    public String lastName;
    static String companyName;
    transient String companyAddress;
    transient final String personalAddress = "Shaikpet";

}


class SerializationClass {

    public static void serialize() {
        Employee emp = new Employee();
        emp.firstName = "Shaik";
        emp.lastName = "Khader";
        emp.companyName = "Sapient";
        emp.companyAddress = "Hitech City";
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("src/main/java/com/javaworld/A1_Core_Java/A2_ClassesAndObjects/employee.txt"))) {
            out.writeObject(emp);
            System.out.println("Serialized data is saved in employee.txt file");
        } catch (IOException i) {
            i.printStackTrace();
        }
        //Employee.companyName = "";
    }
}

class DeserializationClass {

    public static void deserialize() {
        Employee emp = null;
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("src/main/java/com/javaworld/A1_Core_Java/A2_ClassesAndObjects/employee.txt"))) {
            emp = (Employee) in.readObject();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserializing Employee data from employee.txt file...");
        System.out.println("First Name of Employee: " + emp.firstName);
        System.out.println("Last Name of Employee: " + emp.lastName);
        System.out.println("Company Name: " + emp.companyName);
        System.out.println("Company Address: " + emp.companyAddress);
        System.out.println("Personal Address: " + emp.personalAddress);
    }
}

public class C2_Serialization {
    public static void main(String... args) {
        SerializationClass.serialize();
        DeserializationClass.deserialize();
    }
}

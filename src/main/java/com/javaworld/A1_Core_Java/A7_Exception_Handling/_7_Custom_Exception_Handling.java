/**
 *
 */
package com.javaworld.A1_Core_Java.A7_Exception_Handling;

import com.javaworld.A1_Core_Java.z_helperbeans.Customer;
import com.javaworld.A1_Core_Java.z_helperbeans.ListTooLargeUncheckedException;
import com.javaworld.A1_Core_Java.z_helperbeans.NameNotFoundCheckedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Shaik Khader

Java platform provides a lot of exception classes that you can use or you can write one of your own. 
Now the real question is when you should create your own exception classes;

.	Do you need an exception type that isn't represented by those in the Java platform?
.	Would it help users if they could differentiate your exceptions from those thrown by classes written by other vendors?
.	Does your code throw more than one related exception?
.	If you use someone else's exceptions, will users have access to those exceptions? A similar question is, should your
    package be independent and self-contained?

if you answer yes to any of the above questions then you should write your own exception handler.

Note: For readable code, it's good practice to append the string Exception to the names of all classes that inherit
      (directly or indirectly) from the Exception class.

 */


class CustomerService {

    public Customer findByName(String name) throws NameNotFoundCheckedException {
        if ("".equals(name)) {
            throw new NameNotFoundCheckedException("Checked Exception: Name is empty!"); //chained exception (one exception causes another).
        }
        return new Customer(name);
    }

    public void analyze(List<String> data) {
        if (data.size() > 50) {
            //runtime exception
            throw new ListTooLargeUncheckedException("unChecked Exception: Source List can't exceed 50 items!");
        }
    }

}


public class _7_Custom_Exception_Handling {

    /**
     *
     */
    public _7_Custom_Exception_Handling() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        System.out.println("****** Java 'CustomExceptionHandler' Example ********\n");

        CustomerService customerService = new CustomerService();

        try {
            customerService.findByName("");
        } catch (NameNotFoundCheckedException e) {
            e.printStackTrace();
        }


        try {
            List<String> nameData = new ArrayList<>(Collections.nCopies(60, "Shaik"));
            customerService.analyze(nameData);
        } catch (ListTooLargeUncheckedException e) {
            e.printStackTrace();
        }
        System.out.println("\n****************************************");
    }
}

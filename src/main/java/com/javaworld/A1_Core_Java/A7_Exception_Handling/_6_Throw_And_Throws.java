/**
 *
 */
package com.javaworld.A1_Core_Java.A7_Exception_Handling;

/**
 * @author Shaik Khader
 *
 *         Before you can catch an exception, some code somewhere must throw
 *         one. Any code can throw an exception: your code, code from a package
 *         written by someone else such as the packages that come with the Java
 *         platform, or the Java runtime environment.
 *
 *         The throw Statement: All methods use the 'throw' statement to throw
 *         an exception explicitly. The throw statement requires a single
 *         argument: a throwable object. Throwable objects are instances of any
 *         subclass of the Throwable class. Find below an example of a throw
 *         statement.
 *
 *         The throws Statement: indicate that this method might throw one of
 *         the listed type exceptions. The caller to these methods has to handle
 *         the exception using a try-catch block.
 *
 *         Note: 1.throws clause is used to declare an exception and throw
 *         keyword is used to throw an exception explicitly. 2.If we see syntax
 *         wise, throw is followed by an instance variable and throws is
 *         followed by exception class names. 3.The keyword 'throw' is used
 *         inside method body to invoke an exception and 'throws' clause is used
 *         in method declaration (signature). 4.By using Throw keyword you
 *         cannot throw more than one exception but using throws you can declare
 *         multiple exceptions.
 */

public class _6_Throw_And_Throws {

    /**
     *
     */
    public _6_Throw_And_Throws() {

    }

    public static void throwDemo(Integer value) {
        System.out.println("----- Throw Demo ------" + "\nValue = " + value);

        try {
            if (value == null) {
                throw new NullPointerException("Throw Demo: Value is null");
            }
        } catch (NullPointerException e) {
            System.out.println("Rethrowing exception from throwDemo() catch.");
            throw e;
        }
        System.out.println("Multiplied Value = " + (value * 2));
    }

    public static void throwsDemo(Integer value) throws NullPointerException {
        System.out.println("----- Throws Demo ------" + "\nValue = " + value);
        System.out.println("Multiplied Value = " + (value * 2));
    }

    public static void main(String[] args) {
        System.out.println("****** Java 'Throw And Throws' Example ********\n");

        try {
            throwDemo(null);

        } catch (NullPointerException e) {
            System.out.println("Exception caught in main().");
            e.printStackTrace();
        }

        try {
            throwsDemo(null);

        } catch (NullPointerException e) {
            System.out.println("Exception caught in main().");
            e.printStackTrace();
        }
        throwDemo(2);
        throwsDemo(5);

        System.out.println("\n****************************************");
    }

}

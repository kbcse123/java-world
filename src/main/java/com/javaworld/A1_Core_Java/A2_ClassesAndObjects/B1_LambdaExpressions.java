package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;

import com.javaworld.A1_Core_Java.z_helperbeans.Person_Classes_Objects;

import java.nio.file.DirectoryStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Shaik Khader
 * <p>
 * . One issue with anonymous classes is that if the implementation of
 * your anonymous class is very simple, such as an interface that
 * contains only one method, then the syntax of anonymous classes may
 * seem unwieldy and unclear. In these cases, you're usually trying to
 * pass functionality as an argument to another method, such as what
 * action should be taken when someone clicks a button. Lambda
 * expressions enable you to do this, to treat functionality as method
 * argument, or code as data.
 * <p>
 * Approach 1 - Create More Generalized Search Methods:
 * <p>
 * . What if you want to print members of a specified sex, or a
 * combination of a specified gender and age range? What if you decide
 * to change the Person_Classes_Objects class and add other attributes such as
 * relationship status or geographical location? Although this method is
 * more generic than printPerson_Classes_ObjectssOlderThan, trying to create a separate
 * method for each possible search query can still lead to brittle code.
 * You can instead separate the code that specifies the criteria for
 * which you want to search in a different class.
 * <p>
 * Approach 2 - Specify Search Criteria Code in a Local Class:
 * <p>
 * . This method checks each Person_Classes_Objects instance contained in the List
 * parameter roster whether it satisfies the search criteria specified
 * in the CheckPerson_Classes_Objects parameter tester by invoking the method
 * tester.test. If the method tester.test returns a true value, then the
 * method printPerson_Classes_Objectss is invoked on the Person_Classes_Objects instance.
 * <p>
 * . Although this approach is less brittle,you don't have to rewrite
 * methods if you change the structure of the Person_Classes_Objects,you still have
 * additional code: a new interface and a local class for each search
 * you plan to perform in your application. Because UsingLocalClasses
 * implements an interface, you can use an anonymous class instead of a
 * local class and bypass the need to declare a new class for each
 * search.
 * <p>
 * Approach 3 - Specify Search Criteria Code in an Anonymous Class:
 * <p>
 * . This approach reduces the amount of code required because you don't
 * have to create a new class for each search that you want to perform.
 * However, the syntax of anonymous classes is bulky considering that
 * the CheckPerson_Classes_Objects interface contains only one method. In this case, you
 * can use a lambda expression instead of an anonymous class, as
 * described in the next section.
 * <p>
 * Approach 4 - Specify Search Criteria Code with a Lambda Expression:
 * <p>
 * . The CheckPerson_Classes_Objects interface is a functional interface. A functional
 * interface is any interface that contains only one abstract method. (A
 * functional interface may contain one or more default methods or
 * static methods.) Because a functional interface contains only one
 * abstract method, you can omit the name of that method when you
 * implement it. To do this, instead of using an anonymous class
 * expression, you can use a lambda expression, which is highlighted in
 * the following method invocation:
 * <p>
 * Approach 5 - Use Standard Functional Interfaces with Lambda
 * Expressions: . You can use a standard predefined functional interface
 * in place of the interface CheckPerson_Classes_Objects, which reduces even further the
 * amount of code required.
 * <p>
 * . Reconsider the CheckPerson_Classes_Objects interface:
 * <p>
 * interface CheckPerson_Classes_Objects { boolean test(Person_Classes_Objects p); }
 * <p>
 * This is a very simple interface. It's a functional interface because
 * it contains only one abstract method. This method takes one parameter
 * and returns a boolean value. The method is so simple that it might
 * not be worth it to define one in your application. Consequently, the
 * JDK defines several standard functional interfaces, which you can
 * find in the package java.util.function.
 * <p>
 * . For example, you can use the Predicate<T> interface in place of
 * CheckPerson_Classes_Objects. This interface contains the method boolean test(T t):
 * <p>
 * interface Predicate<T> { boolean test(T t); } The interface Predicate
 * <T> is an example of a generic interface. you can use Predicate<T> in
 * place of CheckPerson_Classes_Objects as the below usingStandardFunctionalInterface()
 * demonstrates. As a result, the following method invocation is the
 * same as when you invoked printPerson_Classes_Objectss in Approach 3.
 * <p>
 * Approach 6 - Use Aggregate Operations That Accept Lambda Expressions
 * as Parameters:
 * <p>
 * . The operations filter, map, and forEach are aggregate operations.
 * Aggregate operations process elements from a stream, not directly
 * from a collection (which is the reason why the first method invoked
 * in this example is stream). A stream is a sequence of elements.
 * Unlike a collection, it is not a data structure that stores elements.
 * Instead, a stream carries values from a source, such as collection,
 * through a pipeline. A pipeline is a sequence of stream operations,
 * which in this example is filter- map-forEach. In addition, aggregate
 * operations typically accept lambda expressions as parameters,
 * enabling you to customize how they behave.
 * <p>
 * Syntax of Lambda Expressions:
 * <p>
 * . A lambda expression consists of the following:
 * <p>
 * - A comma-separated list of formal parameters enclosed in
 * parentheses. The CheckPerson_Classes_Objects.test method contains one parameter, p,
 * which represents an instance of the Person_Classes_Objects class.
 * <p>
 * Note: You can omit the data type of the parameters in a lambda
 * expression. In addition, you can omit the parentheses if there is
 * only one parameter. For example, the following lambda expression is
 * also valid:
 * <p>
 * p -> p.getGender() == Person_Classes_Objects.Sex.MALE && p.getAge() >= 18 &&
 * p.getAge() <= 25
 * <p>
 * - The arrow token, ->
 * <p>
 * - A body, which consists of a single expression or a statement block.
 * This example uses the following expression:
 * <p>
 * p.getGender() == Person_Classes_Objects.Sex.MALE && p.getAge() >= 18 && p.getAge() <=
 * 25
 * <p>
 * . If you specify a single expression, then the Java runtime evaluates
 * the expression and then returns its value. Alternatively, you can use
 * a return statement:
 * <p>
 * p -> { return p.getGender() == Person_Classes_Objects.Sex.MALE && p.getAge() >= 18 &&
 * p.getAge() <= 25; }
 * <p>
 * . A return statement is not an expression; in a lambda expression,
 * you must enclose statements in braces ({}). However, you do not have
 * to enclose a void method invocation in braces.
 * <p>
 * . Note that a lambda expression looks a lot like a method
 * declaration; you can consider lambda expressions as anonymous
 * methods,methods without a name.
 * <p>
 * Target Typing:
 * <p>
 * . How do you determine the type of a lambda expression? Recall the
 * lambda expression that selected members who are male and between the
 * ages 18 and 25 years:
 * <p>
 * p -> p.getGender() == Person_Classes_Objects.Sex.MALE && p.getAge() >= 18 &&
 * p.getAge() <= 25
 * <p>
 * This lambda expression was used in the following two methods:
 * <p>
 * public static void printPerson_Classes_Objectss(List<Person_Classes_Objects> roster, CheckPerson_Classes_Objects
 * tester) in Approach 2: Specify Search Criteria Code in a Local Class
 * public void printPerson_Classes_ObjectssWithPredicate(List<Person_Classes_Objects> roster, Predicate
 * <Person_Classes_Objects> tester) in Approach 5: Use Standard Functional Interfaces
 * with Lambda Expressions
 * <p>
 * When the Java runtime invokes the method printPerson_Classes_Objectss, it's expecting
 * a data type of CheckPerson_Classes_Objects, so the lambda expression is of this type.
 * However, when the Java runtime invokes the method
 * printPerson_Classes_ObjectssWithPredicate, it's expecting a data type of Predicate
 * <Person_Classes_Objects>, so the lambda expression is of this type. The data type
 * that these methods expect is called the target type. To determine the
 * type of a lambda expression, the Java compiler uses the target type
 * of the context or situation in which the lambda expression was found.
 * It follows that you can only use lambda expressions in situations in
 * which the Java compiler can determine a target type:
 * <p>
 * . For method arguments, the Java compiler determines the target type
 * with two other language features: overload resolution and type
 * argument inference.
 * <p>
 * Serialization:
 * <p>
 * . You can serialize a lambda expression if its target type and its
 * captured arguments are serializable. However, like inner classes, the
 * serialization of lambda expressions is strongly discouraged.
 */

// Example 1

interface CheckPerson {
    boolean check(Person_Classes_Objects p);
}

class UsingLocalClasses implements CheckPerson {
    public boolean check(Person_Classes_Objects p) {
        return p.getGender() == Person_Classes_Objects.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
    }
}
// end

// Example 2
interface IntegerMath {
    int operation(int a, int b);
}

class Calculator {

    public int execute(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

}
// end

// Main Class
public class B1_LambdaExpressions {

    public static void main(String... args) {
        List<Person_Classes_Objects> persons = new ArrayList<>();

        Person_Classes_Objects person1 = new Person_Classes_Objects("Shaik", LocalDate.of(1985, 06, 05), Person_Classes_Objects.Sex.MALE, "kb");
        Person_Classes_Objects person2 = new Person_Classes_Objects("Khader", LocalDate.of(1995, 06, 05), Person_Classes_Objects.Sex.MALE, "cse234");
        Person_Classes_Objects person3 = new Person_Classes_Objects("Basha", LocalDate.of(1998, 06, 05), Person_Classes_Objects.Sex.MALE, "skb");
        Person_Classes_Objects person4 = new Person_Classes_Objects("Bhai", LocalDate.of(1999, 06, 05), Person_Classes_Objects.Sex.MALE, "cse123");

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

        // Approach 1
        System.out.println("Using usingGeneralizedMethod:");
        usingGeneralizedMethod(persons, 18, 25);

        // Approach 2
        System.out.println("\nUsing usingLocalClasses:");
        printPersons(persons, new UsingLocalClasses());

        // Approach 3
        System.out.println("\nUsing usingAnonymousClasses:");
        printPersons(persons, new CheckPerson() {
            public boolean check(Person_Classes_Objects p) {
                return p.getGender() == Person_Classes_Objects.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
            }
        });

        // Approach 4
        System.out.println("\nUsing Lambda Expressions:");
        final CheckPerson genderAndAgeFilter = (Person_Classes_Objects p) -> p.getGender() == Person_Classes_Objects.Sex.MALE
                && p.getAge() >= 18 && p.getAge() <= 25;
        printPersons(persons, genderAndAgeFilter);

        // Approach 5
        System.out.println("\nUsing Predefined Standard Functional Interface with Lambda Expressions:");
        Predicate<Person_Classes_Objects> genderAndAgePredicate = (Person_Classes_Objects p) -> p.getGender() == Person_Classes_Objects.Sex.MALE
                && p.getAge() >= 18 && p.getAge() <= 25;
        usingPredefinedFunctionalInterface(persons, genderAndAgePredicate);

        // Approach 6
        System.out.println("\nUsing Aggregate Operations That Accept Lambda Expressions as Parameters:");
        persons.stream()
                .filter(p -> p.getGender() == Person_Classes_Objects.Sex.MALE
                        && p.getAge() >= 18  && p.getAge() <= 25)
                .forEach(p -> p.printPerson());

        System.out.println("\nMore Simplified example for Lambda Expressions...");
        IntegerMath anonymousAddition = new IntegerMath() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        };

        // The operation itself is specified by an instance of IntegerMath.
        IntegerMath lambdaAddition = (a, b) -> a + b;
        IntegerMath lambdaSubtraction = (a, b) -> a - b;
        IntegerMath lambdaMultiply = (a, b) -> a * b;
        IntegerMath lambdaDivide = (a, b) -> a / b;

        Calculator cal = new Calculator();
        System.out.println("\nUsing anonymous class");
        System.out.println("20 + 2 = " + cal.execute(20, 2, anonymousAddition));
        System.out.println("\nUsing Lambda Expressions");
        System.out.println("40 + 2 = " + cal.execute(40, 2, lambdaAddition));
        System.out.println("20 - 10 = " + cal.execute(20, 10, lambdaSubtraction));
        System.out.println("30 * 2 = " + cal.execute(30, 2, lambdaMultiply));
        System.out.println("40 / 2 = " + cal.execute(40, 2, lambdaDivide));

    }


    public static void usingGeneralizedMethod(List<Person_Classes_Objects> persons, int low, int high) {
        for (Person_Classes_Objects p : persons) {
            if (p.getAge() >= low && p.getAge() <= high) {
                p.printPerson();
            }
        }
    }

    public static void printPersons(List<Person_Classes_Objects> persons, CheckPerson checkPerson) {
        for (Person_Classes_Objects p : persons) {
            if (checkPerson.check(p)) {
                p.printPerson();
            }
        }
    }

    public static void usingPredefinedFunctionalInterface(List<Person_Classes_Objects> persons, Predicate<Person_Classes_Objects> tester) {
        for (Person_Classes_Objects p : persons) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

}

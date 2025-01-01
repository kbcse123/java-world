package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;

import com.javaworld.A1_Core_Java.z_helperbeans.Person_Classes_Objects;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;

/**
 * @author Shaik Khader
 * <p>
 * . You use lambda expressions to create anonymous methods. Sometimes, however, a lambda expression does nothing
 * 	 but call an existing method. In those cases, it's often clearer to refer to the existing method by name.
 * 	 Method references enable you to do this; they are compact, easy-to-read lambda expressions for methods that
 * 	 already have a name.
 * <p>
 * . Suppose that you want to sort the Person list by age, You could do this by defining a custom comparator like
 * 	 PersonAgeComparator as below.
 * <p>
 * . Notice that the interface Comparator is a functional interface. Therefore, you could use a lambda expression
 * instead of defining and then creating a new instance of a class that implements Comparator.
 * <p>
 * . However, this method to compare the birthdates of two Person instances already exists as Person.compareByAge.
 * You can invoke this method instead in the body of the lambda expression.
 * <p>
 * . Because this lambda expression invokes an existing method, you can use a method reference instead of a lambda expression.
 * <p>
 * . The method reference Person::compareByAge is semantically the same as the lambda expression
 * 	 (a, b) -> Person.compareByAge(a, b). Each has the following characteristics:
 * <p>
 * - Its formal parameter list is copied from Comparator<Person>.compare, which is (Person, Person).
 * - Its body calls the method Person.compareByAge.
 * <p>
 *
 * .There are four kinds of method references:
 *      1. Reference to a static method -
 *          eg: Collections.sort(persons,Person::compareByAge);
 *      2. Reference to an instance method of a particular object	-
 *          eg: Person personObj = new Person();
 *              Collections.sort(persons,personObj::compareByName);
 *      3. Reference to an instance method of an arbitrary object of particular type -
 *          eg: String[] stringArray = {"Barbara","James","Mary","John","Patricia","Robert","Michael","Linda"};
 *          Arrays.sort(stringArray, String::compareToIgnoreCase);
 *      4. Reference to a constructor -
 *          eg: List<Person> methodRef = Person.transferElements(persons, ArrayList::new);
 *
 */

interface GenIf<T> {
    T[] genArrMaker(int size);
}

class PersonAgeComparator implements Comparator<Person_Classes_Objects> {
    public int compare(Person_Classes_Objects a, Person_Classes_Objects b) {
        return a.getBirthday().compareTo(b.getBirthday());
    }
}

public class B2_MethodReferences {
    public static void main(String... args) {
        List<Person_Classes_Objects> persons = getPersons();
        List<Person_Classes_Objects> usingComp = new ArrayList<>(persons);
        List<Person_Classes_Objects> lambdaExp = new ArrayList<>(persons);
        List<Person_Classes_Objects> invokeMehodInLE = new ArrayList<>(persons);
        List<Person_Classes_Objects> methodRef = Person_Classes_Objects.transferElements(persons, ArrayList::new);

        System.out.println("**** Before Sort ****");
        persons.forEach(p -> p.printPerson());

        System.out.println("\n**** Using Comparator ****");
        Collections.sort(usingComp, new PersonAgeComparator());
        usingComp.forEach(p -> p.printPerson());

        System.out.println("\n**** Using Lambda Expressions ****");
        Collections.sort(lambdaExp, (a, b) -> a.getBirthday().compareTo(b.getBirthday())
        );
        lambdaExp.forEach(p -> p.printPerson());

        System.out.println("\n**** Invoking method in the body of the lambda expression ****");
        Collections.sort(invokeMehodInLE, (a, b) -> Person_Classes_Objects.compareByAge(a, b));
        invokeMehodInLE.stream().forEach(p -> p.printPerson());

        System.out.println("\n**** Using Method Reference ****");
        Collections.sort(methodRef, Person_Classes_Objects::compareByAge);
        methodRef.stream().forEach(p -> p.printPerson());

        methodRefExamples();

    }

    private static List<Person_Classes_Objects> getPersons() {
      return  List.of(new Person_Classes_Objects("Shaik", LocalDate.of(1999, 8, 5), Person_Classes_Objects.Sex.MALE, "kb"),
                new Person_Classes_Objects("Khader", LocalDate.of(1995, 9, 4), Person_Classes_Objects.Sex.MALE, "cse234"),
                new Person_Classes_Objects("Basha", LocalDate.of(1998, 4, 3), Person_Classes_Objects.Sex.MALE, "skb"),
                new Person_Classes_Objects("Bhai", LocalDate.of(1985, 1, 7), Person_Classes_Objects.Sex.MALE, "cse123"));
    }

    private static void methodRefExamples() {
        System.out.println("\n**** Other Examples of Method Reference ****");
        //through lambda
        IntFunction<int[]> arrayCreator1 = size -> new int[size];
        int[] intArray1 = arrayCreator1.apply(10);
        System.out.println(Arrays.toString(intArray1));

        //equivalent method Reference
        IntFunction<int[]> arrayCreator2 = int[]::new;
        int[] intArray2 = arrayCreator2.apply(10);
        System.out.println(Arrays.toString(intArray2));

        //Specifying array type in the declaration.
        Function<Integer, int[]> arrayCreator3 = int[]::new;
        int[] integerArray = arrayCreator3.apply(5);
        System.out.println(Arrays.toString(integerArray));

        //String Array
        GenIf<String> gi = String[]::new;
        String[] objArr = gi.genArrMaker(10);
        for (int i = 0; i < objArr.length; i++) {
            objArr[i] = "\"" + i + "\"";
            System.out.print(objArr[i] + ", ");

        }
    }


}

package com.javaworld.A0_Version_Features.versions;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://howtodoinjava.com/java-8-tutorial/
 * @author Shaik Khader
 */

public class A2_Java8 {
    public static void main(String... args) {
        lambdaExpressions();
        functionInterface(a -> {
            int b = a + a;
            System.out.println(b);
            return b;
        }, 5);
        functionalInterfaces();
        streamDemo();
    }


    /**
     * 1. Default methods in Interface
     * Default Methods:
     * . As of the Java SE 8 release, You can define new methods in existing interface as default methods.
     * Default methods enable you to add new functionality to the interfaces and ensure
     * binary compatibility with code written for older versions of those interfaces. Note that you must provide an
     * implementation for default methods.
     * . In particular, default methods enable you to add methods that accept lambda expressions as parameters
     * to existing interfaces.
     *
     * 2. Static Methods in Interface
     * . You could also define new static methods to existing interfaces. Since static method is associated with the
     * class in which it is defined rather than with any object, Every instance of the class shares its static methods.
     * This makes it easier for you to organize helper methods in your libraries; you can keep static methods specific
     * to an interface in the same interface rather than in a separate class.
     * . Users who have classes that implement interfaces enhanced with new default or static methods do not
     * have to modify or recompile them to accommodate the additional methods.
     * <p>
     * So why not keep using Abstract class?
     * <p>
     * Abstract classes are still a way to introduce state, or implement the core
     * Object methods, it's coupled with state. Default methods in interface are for
     * pure behavior. An example of default method is nullLast method in Comparator interface.
     * Comparator<Obj> newComparator = Comparator.nullLast(oldComparator);
     */

    interface Vehicle {
        void start();
        void stop();
        default void defaultMethod() {
            System.out.println("This is default method");
        }
        static void staticMethod() {
            System.out.println("This is default method");
        }
    }

    static class Car implements Vehicle {
        @Override
        public void start() {
        }

        @Override
        public void stop() {
        }
    }

    @Test
    public void defaultAndStatic() {
        Car car = new Car();
        car.defaultMethod();
        Vehicle.staticMethod();
    }


    /**
     *  3. Lambda expression (or function) is an anonymous function, i.e., a function without any name or identifier, and
     *  with a list of formal parameters and a body. An arrow (->) is used to separate the list of parameters and the body.
     *  Syntax:
     *      (parameters) -> expression
     *      (parameters) -> { statements; }
     *      () -> expression
     *  Similar to other types in Java, lambda expression's type is a functional interface type
     *  (represents an instance of a functional interface.)
     *  Advantages of Lambda Expressions:
     *
     */
    private static void lambdaExpressions() {
        //Using anonymous class
        Operator<Integer> addOperation = new Operator<Integer>() {
            @Override
            public Integer process(Integer a, Integer b) {
                return a + b;
            }
        };
        // using lambda expression
        Operator<Integer> operation = (a, b) ->  a + b;
        System.out.println("Add: "+operation.process(3, 3));
        operation = (a, b) ->  a - b;
        System.out.println("Sub: "+operation.process(3, 3));
        Operator<String> concatOperation = (a, b) ->  a + b;
        System.out.println("Concat: "+concatOperation.process("3", "3"));
        // iterate over a List and perform some action on list items
        List<String> pointList = new ArrayList<>();
        pointList.add("1");
        pointList.add("2");
        pointList.forEach( p ->  System.out.println(p)  );
    }

    @FunctionalInterface
    interface Operator<T> {
        T process(T a, T b);
    }

    /**
     * Functional interfaces are also called Single Abstract Method (SAM) interfaces. As the name suggests,
     * a functional interface permits exactly one abstract method in it. Java 8 introduces @FunctionalInterface annotation
     * that we can use for giving compile-time errors if a functional interface violates the contracts. Runnable, Comparator,
     * Comparable are some examples of functional interfaces.
     */
    public static void functionalInterfaces() {
        new Thread(() -> System.out.println("Hello lambda")).start();
    }


    /**
     * Function Interface
     * In Java 8, the java.util.Function<T, R> Interface was introduced. It can store a function which takes one
     * argument and returns an object. The Generic T is the type of the argument and R the type of the object you return.
     */
    public static void functionInterface(Function<Integer, Integer> function, Integer value) {
        function.apply(value);
    }

    /**
     * 7. Streams
     * <p>
     * Streams are a wonderful new way to work with data collections. Almost every Stream method returns the Stream again,
     * so developers can continue to work with it. Streams have the ability to filter, map, and reduce while being
     * traversed.
     * <p>
     * Streams are also immutable and a one-time-use Object. Once it has been traversed, it cannot be traversed again.
     * Every time developers manipulate it, they create a new Stream. The way it supports functional programming is if
     * developers convert a Data Structure into a Stream and work on it, the original data structure won't be changed.
     * So absence of memory aka no side effects!
     */
    public static void streamDemo() {
        // Concat multiple Lists into Stream
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        Stream.of(list1, list2) // Stream<List<Integer>>
                .flatMap(List::stream) // Stream<Integer>
                .forEach(System.out::println); // 1 2 3 4 5 6

        // convert array to stream
        String[] array = {"hello", "world"};
        Stream<String> arrayStream = Arrays.stream(array);
        // Similarly you can also do the same using
        Stream<String> objectStream = Stream.of("Hello", "World");

        // Usage of Filter for conditions
        Stream.of(2, 1, null, 3)
                .filter(Objects::nonNull)
                // without filter, you would�ve got a NullPointerExeception
                .forEach(System.out::println);

        // Usage of Collectors to convert Stream to List
        List<Integer> converted = Stream.of(0, 1, 2, 3).collect(Collectors.toList());
        System.out.println(converted);
        // Performing reducing tasks
        int[] arr = {23, 43, 56, 97, 32};
        Arrays.stream(arr).reduce((x, y) -> x + y).ifPresent(s -> System.out.println(s));
        // Sorting data in Stream
        Stream.of(3, 2, 4, 0).sorted((c1, c2) -> c1 - c2).forEach(System.out::println);

        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println(stats);

    }

}

package com.javaworld;


import java.util.List;
import java.util.stream.Collectors;

public class Testing {


    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,5,4,6,8,9,10);
        List<Integer> even =  numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println(even);
        numbers.stream().sorted().forEach(System.out::println);
    }
}

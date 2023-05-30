package com.example.demo.java8;

import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String... args) {
        Predicate<Integer> lessThanTen = x -> (x < 10);
        System.out.println(lessThanTen.test(8));

        Predicate<Integer> greaterThanTen = (i) -> i > 10;

        // Creating predicate
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
        boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println(result);

        // Calling Predicate method
        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println(result2);
    }
}

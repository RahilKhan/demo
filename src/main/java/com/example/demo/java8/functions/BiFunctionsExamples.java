package com.example.demo.java8.functions;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class BiFunctionsExamples {

    /**
     * BiPredicate
     */
    static BiPredicate<Integer, Integer> isEvenAndDivByInput = (x, y) -> x % 2 == 0 && x % y == 0;
    static BiPredicate<Integer, Integer> isDivBy5 = (x, y) -> x % y == 0 && x % 5 == 0;
    static BiPredicate<Integer, Integer> evenAndDivBy5 = isEvenAndDivByInput.and(isDivBy5);

    /**
     * BiFunctions
     */
    static BiFunction<Integer, Long, Integer> concatNumBiFn = (x, y) -> Math.toIntExact(x + y);
    static Function<Integer, Integer> multiplyBy3 = x -> x * 3;

    public static void testConcatAndMultBy5(Integer intNum, Long numLong) {
        System.out.println("Math.toIntExact(intNum,numLong) : " + Math.toIntExact(intNum + numLong));
        BiFunction<Integer, Long, Integer> concatAndMultBy5 = concatNumBiFn.andThen(multiplyBy3);
        System.out.println("concatAndMultBy5 : " + concatAndMultBy5.apply(5, 7L));
    }

    public static void main(String... args) {

        Boolean result = isEvenAndDivByInput.test(2, 4);
        System.out.println("result : " + result);
        System.out.println("result : " + isEvenAndDivByInput.test(8, 4));
        System.out.println("result : " + isEvenAndDivByInput.test(9, 4));

        result = isEvenAndDivByInput.and(isDivBy5).test(20, 4);
        System.out.println("isEvenAndDivByInput and isDivBy5 : " + result);

        System.out.println("evenAndDivBy5 : " + evenAndDivBy5.test(20, 4));

        testConcatAndMultBy5(5, 7L);


    } 
}

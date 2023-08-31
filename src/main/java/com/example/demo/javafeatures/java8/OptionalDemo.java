package com.example.demo.javafeatures.java8;

import lombok.extern.slf4j.Slf4j;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Rahil_Khan
 * Optional is meant to be used as a return type.
 *    Trying to use it as a field type is not recommended.
 * Additionally, using Optional in a serializable class will result in a NotSerializableException.
 */
@Slf4j
public class OptionalDemo {
    public static void main(String[] args) {
        String[] words = new String[10];
        String testNullStr = null;
        String name = "test";

        /** 1. Creating Optional Objects */
        /*Throws excpetion if value inside option is null. In this case 'checkNullTestStr' */
        try {
            Optional<String> checkNullTestStr = Optional.of(testNullStr);
            if (checkNullTestStr.isPresent()) {
                log.info("checkNullTestStr.isPresent() : checkNullTestStr is not null");
            }
        } catch (NullPointerException npe) {
            log.info("Exception thrown for Optional.of(testStr) where testStr is null");
        }


        /** 2. Checking Value Presence: isPresent() and isEmpty() */
        Optional<String> checkNull = Optional.ofNullable(name);
        if (checkNull.isPresent()) {
            log.info("String '{}' -> checkNull.isPresent() : checkNull is not null", name);
        } else {
            log.info("String '{}' -> checkNull is null", name);
        }

        if (checkNull.isEmpty()) {
            log.info("String '{}' -> checkNull.isEmpty() : checkNull is null", name);
        } else {
            log.info("String '{}' -> checkNull is not null", name);
        }


        /** 3. Conditional Action With ifPresent() */
        checkNull.ifPresent(nm -> log.info("name : {}", nm));

        /** 4. Default Value With orElse() */
        String newName = Optional.ofNullable(name).orElse("John");

        /** 5. Default Value With orElseGet() */
        newName = Optional.ofNullable(name).orElseGet(() -> "John");

        /* Diff: orElse() vs orElseGet() */
        String nm = Optional.ofNullable(name).orElseGet(OptionalDemo::getDefaultName);
        log.info("nm : {}", nm);

        nm = Optional.ofNullable(name).orElse(getDefaultName());
        log.info("nm : {}", nm);
        /**
         * # when the wrapped value is not present, then both orElse() and orElseGet() work exactly the same way.
         * # when using orElse(), whether the wrapped value is present or not, the default object is created.
         *      So in this case, we have one redundant object is created that is never used.
         */

        /** 5. Default Value With orElse() */
        newName = Optional.ofNullable(name).orElseGet(() -> "John");


        /** 6. Exceptions With orElseThrow() */
        try {
            nm = Optional.ofNullable(testNullStr).orElseThrow();
        } catch (NoSuchElementException nsee) {
            log.info("orElseThrow() : NoSuchElementException thrown");
        }

        try {
            nm = Optional.ofNullable(testNullStr).orElseThrow(IllegalArgumentException::new);
        } catch (IllegalArgumentException iae) {
            log.info("orElseThrow(IllegalArgumentException::new) : IllegalArgumentException thrown");
        }

        /**7. Returning Value With get()
         *  unlike previous 3 approaches( orElse(), orElseGet(), orElseThrow()), get() can only return a value if the wrapped object is not null;
         *  otherwise, it throws a no such element exception */
        Optional<String> nameOpt = Optional.ofNullable(name);
        log.info("nameOpt.get() : {}", nameOpt.get());

        /**8. Conditional return with filter */
        Integer year = 2023;
        Optional<Integer> yearOpt = Optional.ofNullable(year);
        boolean is2023 = yearOpt.filter(y -> y == 2023).isPresent();
        log.info("Year is 2023 : {}", is2023);

        boolean is2024 = yearOpt.filter(y -> y == 2024).isPresent();
        log.info("Year is 2024 : {}", is2024);

        /** 9. Returning Value With get() */
        Optional<String> found = Stream.of(getEmpty(), getBye(), getHello() )
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
        log.info("found : {}", found);

        /*
         * Below statment throws exception java.util.NoSuchElementException: No value
         * present As checkNull is empty
         *
         * System.out.print(checkNull.get());
         */

        /* Correct way to handle Optional value */
        Optional<String> checkListForNull = Optional.ofNullable(words[5]); //better choice
        if (checkListForNull.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.print(word);
        } else
            System.out.println("word is null");

        System.out.println("danno : " + changeCase("danno"));
        System.out.println("null  : " + changeCase(null));
    }


    public static String getDefaultName() {
        System.out.println("Getting Default Value");
        return "Wick";
    }

    static Optional<String> changeCase(String word) {

//		Optional<String> nameChk = Optional.ofNullable(word);
//		return nameChk.isPresent() ? Optional.of(word.toUpperCase()) : Optional.ofNullable(word);
        return Optional.ofNullable(word).isPresent() ? Optional.of(word.toUpperCase()) : Optional.ofNullable(word);

    }

    private static Optional<String> getEmpty() {
        return Optional.empty();
    }

    private static Optional<String> getHello() {
        return Optional.of("hello");
    }

    private static Optional<String> getBye() {
        return Optional.of("bye");
    }

    private Optional<String> createOptional(String input) {
        if (input == null || "".equals(input) || "empty".equals(input)) {
            return Optional.empty();
        }
        return Optional.of(input);
    }

}

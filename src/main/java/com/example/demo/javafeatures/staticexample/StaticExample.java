package com.example.demo.javafeatures.staticexample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StaticExample {

    public static void main(String... args) {
        String name1 = StaticExample.getName("Awesome ");
        String name2 = StaticExample.getName("Legendary ");
        String name3 = StaticExample.getName("Idea of ");

        log.info("name1 : {}", name1);
        log.info("name2 : {}", name2);
        log.info("name3 : {}", name3);
    }

    public static String getName(String title) {
        return title + "John Wick ";
    }


}

package com.example.demo.java8;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;


/**
 * Java program to demonstrate toMap() method
 */
public class CollectorsToMapExample {

    public static void main(String... args) {

        // Create a String to be converted
        Stream<String[]>
                Ss1 = Stream
                .of(new String[][]{{"GFG", "GeeksForGeeks"},
                        {"g", "geeks"},
                        {"GFG", "Geeks"}});

        // Get Map from String
        // using toMap() method
        LinkedHashMap<String, String>
                map2 = Ss1
                .collect(Collectors
                        .toMap(p -> p[0], p -> p[1], (s, a) -> s + ", " + a, LinkedHashMap::new));

        // Print the Map
        System.out.println("Map:" + map2);

        Stream<int[]> int1 = Stream.of(new int[][]{{9, 10}, {9, 7}, {10, 13}});
        HashMap<Integer, String> map3 = int1.collect(Collectors.toMap(p -> p[0], p -> String.valueOf(p[1]), (a, b) -> a + "," + b, HashMap::new));
        System.out.println("map3:" + map3);

        int1 = Stream.of(new int[][]{{9, 10}, {9, 7}, {10, 13}});
        Map<Integer, String> map4 = int1.collect(Collectors.toMap(p -> p[0], p -> String.valueOf(p[1]), (a, b) -> a + "," + b, HashMap::new));
        System.out.println("map4:" + map4);

    }
}

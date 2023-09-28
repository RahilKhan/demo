package com.example.demo.javafeatures.java8.collectionConversion;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;


/**
 * Java program to demonstrate toMap() method
 */
public class CollectorsToMapExample {

    public static void main(String... args) {

        // Create a String to be converted
        Stream<String[]> Ss1 = Stream.of(new String[][]{{"GFG", "GeeksForGeeks"}, {"g", "geeks"}, {"GFG", "Geeks"}});

        // Get Map from String
        // using toMap() method
        LinkedHashMap<String, String> map2 = Ss1.collect(Collectors.toMap(p -> p[0], p -> p[1], (s, a) -> s + ", " + a, LinkedHashMap::new));
        System.out.println("Map:" + map2);

        /**
         * Example of mergeFunc in toMap
         * toMap -> BinaryOperator<U> mergeFunction
         * Defines how multiple value with same key will be stored in value.
         */
        Stream<int[]> int1 = Stream.of(new int[][]{{9, 10}, {9, 7}, {10, 13}});
        HashMap<Integer, String> map3 = int1.collect(Collectors.toMap(p -> p[0], p -> String.valueOf(p[1]), (a, b) -> a + "," + b, HashMap::new));
        System.out.println("map3:" + map3);

        int1 = Stream.of(new int[][]{{9, 10}, {9, 7}, {10, 13}});
        Map<Integer, String> map4 = int1.collect(Collectors.toMap(p -> p[0], p -> String.valueOf(p[1]), (a, b) -> a + "," + b, HashMap::new));
        System.out.println("map4:" + map4);

        int1 = Stream.of(new int[][]{{9, 10}, {9, 7}, {10, 13}});
        Map<Integer, List<int[]>> map5 = int1.collect(Collectors.groupingBy(
                array -> array[0],    // Key: value at index 0
                Collectors.toList()  // Value: List of arrays
        ));
        System.out.println("map5" + map5);
        System.out.println("map5.get(9) : ");
        Arrays.stream(map5.get(9).get(0)).boxed().forEach(System.out::println);

//        int1 = Stream.of(new int[][]{{9, 10}, {9, 7}, {10, 13}});
//        Map<String, List<String>> resultMap = int1.collect(Collectors.toMap(
//                        // Key Mapper: Use the value as the key
//                        key -> key[0],
//                        // Value Mapper: Wrap the value in a list
////                        value -> Collections.singletonList(value[1]),
//                        value -> value[1],
//                        // Merge Function: Merge two lists into one
//                        (list1, list2) -> {
//                            List<Integer> mergedList = new ArrayList<>(list1);
//                            mergedList.addAll(list2);
//                            return mergedList;
//                        }
//                ));

        intListToMap();
    }

    public static void intListToMap() {
        List<Integer> myList = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);

        Map<Integer, Long> numberCountMap = myList.stream()
                .collect(Collectors.groupingBy(
                        i -> i,
                        Collectors.counting()
                ));

        System.out.println("numberCountMap : " + numberCountMap);
        // Print the resulting map
        numberCountMap.forEach((number, count) ->
                System.out.println("Number: " + number + ", Count: " + count));
    }

}

package com.example.demo.coding;

import java.util.*;
import java.util.stream.Collectors;

public class ListOperations {

    public static void main(String... args) {
        Random rand = new Random();
        ArrayList noList = new ArrayList();

        for (int i = 0; i < 10; i++) {
            noList.add(rand.nextInt(100));
        }

        highestAndLowestNumberInList(noList);

    }

    public static void highestAndLowestNumberInList(ArrayList noList) {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = noList.stream().mapToInt(x -> (int) x).summaryStatistics();
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Count in List : " + stats.getCount());
        System.out.println("Sum of List : " + stats.getSum());


        IntSummaryStatistics stats2 = (IntSummaryStatistics) noList.stream().collect(Collectors.summarizingInt(x -> (int) x));
        System.out.println("Lowest number in List : " + stats2.getMin());
        System.out.println("Highest number in List : " + stats2.getMax());
        stats2.combine(stats);
        System.out.println("Count in List2 : " + stats2.getCount());
        System.out.println("Sum of List2 : " + stats2.getSum());

    }

}

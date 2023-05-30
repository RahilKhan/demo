package com.example.demo.coding;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class DuplicateInList {

    public static void main(String... args) {

        Random rand = new Random();
        ArrayList<Integer> noList = new ArrayList();
        noList.add(10);
        noList.add(5);
        noList.add(3);
        noList.add(5);
        noList.add(2);
        noList.add(7);
        noList.add(4);
        noList.add(4);
        noList.add(6);
        noList.add(9);
        noList.add(10);

        listWdDuplicatesAtEnd(noList);
    }

    public static void listWdDuplicatesAtEnd(ArrayList<Integer> numList) {
        log.info(" numList.size() : {}", numList.size());

        Set numSet = new HashSet();
        LinkedList numLL = new LinkedList();

        for (Integer num : numList) {
            if (!numSet.contains(num)) {
                numSet.add(num);
                numLL.addFirst(num);
                continue;
            }
            numLL.addLast(num);
            log.info("-------------------- numLL : {} --------------------", numLL);
        }

        ArrayList<Integer> arrayList = new ArrayList<>(numLL);
        log.info(" arrayLuist.size() : {}", arrayList.size());

        arrayList.forEach(x -> System.out.println(x));

    }
}

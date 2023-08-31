package com.example.demo.coding;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Slf4j
public class DuplicateNumber {

    public static  void main(String...args){

        List<Integer> integerList = Arrays.asList(3, 3, 1, 2, 1, 3);
        log.info("integerList : {}", integerList);

        List<Integer> intList = Stream.of(3, 3, 1, 2, 1, 3).toList();

        Set<Integer> tempSet = new HashSet<>();
        Set<Integer> dupSet = new HashSet<>();
        for(int num: intList){
            if(tempSet.contains(num)){
                dupSet.add(num);
            }
            tempSet.add(num);
        }
        log.info("dupSet : {}", dupSet);

        Set<Integer> tempSteamSet = new HashSet<>();
        Set<Integer> dupSteamSet = new HashSet<>();
        intList.stream().map(x-> {
            if(tempSteamSet.contains(x)){
                dupSteamSet.add(x);
            }
            tempSteamSet.add(x);
            return null;
        }).toList();

        log.info("dupSteamSet : {}", dupSteamSet);

    }

}

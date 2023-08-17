package com.example.demo.java8.recordtest;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class RecordTest {

    public static void main(String... args) {

        UniqueRecords uniqueRecords = new UniqueRecords("cluster", "sku", "countryCode");

        List unqRecList = new ArrayList<>();
        unqRecList.add(uniqueRecords);
        unqRecList.add(uniqueRecords);
        unqRecList.add(uniqueRecords);
        unqRecList.add(uniqueRecords);

        uniqueRecords = new UniqueRecords("cluster1", "sku1", "countryCode1");
        unqRecList.add(uniqueRecords);
        unqRecList.add(uniqueRecords);
        unqRecList.add(uniqueRecords);

        uniqueRecords = new UniqueRecords("cluster2", "sku2", "countryCode2");
        unqRecList.add(uniqueRecords);
        unqRecList.add(uniqueRecords);
        unqRecList.add(uniqueRecords);

        uniqueRecords = new UniqueRecords("cluster2", "sku2", "countryCode2");
        unqRecList.add(uniqueRecords);
        unqRecList.add(uniqueRecords);
        unqRecList.add(uniqueRecords);

        var idList = unqRecList.stream().collect(Collectors.toList());
        var idSet = unqRecList.stream().collect(Collectors.toSet());

        log.info("idList : {} ", idList);
        log.info("idSet : {} ", idSet);

    }

}

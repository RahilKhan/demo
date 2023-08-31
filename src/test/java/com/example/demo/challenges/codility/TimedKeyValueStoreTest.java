package com.example.demo.challenges.codility;

public class TimedKeyValueStoreTest {

    TimedKeyValueStore<String, Integer> store = new TimedKeyValueStore<>(3, 1000);
    /*
    store.put("a",1,500);
    store.put("b",2,750);
    store.put("c",3,400);
    store.put("d",4,600);
    // now the store has capacity of 3 and contains ("a", 1), ("b", 2), ("d", 4)

    store.get("a"); // returns 1
    store.get("b"); // returns 2
    store.get("c"); // returns null, because it has expired
    store.get("d"); // returns 4

    Thread.sleep(1000); // wait for entries to expire

    store.get("a"); // returns null, because it has expired
    store.get("b"); // returns null, because it has expired
    store.get("c"); // returns null, because it has expired
    store.get("d"); // returns null, because it has expired

    store.put("e",5,3000);
    // now the store contains ("e", 5), because it has the latest expire time
    */
}

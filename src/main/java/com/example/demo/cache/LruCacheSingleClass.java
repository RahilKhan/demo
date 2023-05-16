package com.example.demo.cache;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LruCacheSingleClass {

    /*Store keys*/
    private LinkedList cacheList = new LinkedList<>();

    /*Stores key and value*/
    private Map<Integer, String> cacheMap;

    private int capacity;

    public LruCacheSingleClass(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>(capacity);
    }

    public void put(Integer key, String value) {
        if (cacheList.size() >= capacity) {
            int keyRemoved = (int) cacheList.removeLast();
            cacheMap.remove(keyRemoved);
        }
        cacheList.addFirst(key);
        cacheMap.put(key, value);
    }

    public Integer delete(Integer key) {
        if (!cacheMap.containsKey(key)) {
            return null;
        }
        int keyRemoved = (int) cacheList.removeLast();
        cacheMap.remove(keyRemoved);
        return key;
    }

    public String search(Integer key) {
        if (!cacheMap.containsKey(key)) {
            return null;
        }

        cacheList.remove(key);
        cacheList.addFirst(key);

        return cacheMap.get(key);
    }

    public void display() {
        System.out.println("\n----------------------------------");
        cacheList.forEach((key) -> System.out.println(cacheMap.get(key)));
    }

}

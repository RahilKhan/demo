package com.example.demo.cache;

public class CacheMain {

    public static void main(String... args) {
        LruCacheSingleClass lruCacheSingleClass = new LruCacheSingleClass(6);
        lruCacheSingleClass.put(1, "Manha");
        lruCacheSingleClass.put(2, "Daneen");
        lruCacheSingleClass.put(3, "Aayana");
        lruCacheSingleClass.display();
        lruCacheSingleClass.put(5, "Zubi");
        lruCacheSingleClass.put(6, "Aanu");
        lruCacheSingleClass.display();
        lruCacheSingleClass.put(4, "Antu");

        lruCacheSingleClass.display();

        lruCacheSingleClass.put(4, "xxx");
        lruCacheSingleClass.put(5, "yyy");
        lruCacheSingleClass.display();

        lruCacheSingleClass.delete(4);
        lruCacheSingleClass.display();


    }
}


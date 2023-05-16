package com.example.demo.cache;

/**
 * https://medium.com/analytics-vidhya/how-to-implement-cache-in-java-d9aa5e9577f2
 *
 * @param <K>
 * @param <V>
 */
public class LruCacheNode<K, V> {
    private K key;
    private V value;
    private LruCacheNode prev, next;
    private int hitCount = 0; /* LFU require this */

    public LruCacheNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void incrementCount() {
        this.hitCount++;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public LruCacheNode getPrev() {
        return prev;
    }

    public void setPrev(LruCacheNode prev) {
        this.prev = prev;
    }

    public LruCacheNode getNext() {
        return next;
    }

    public void setNext(LruCacheNode next) {
        this.next = next;
    }

    public int getHitCount() {
        return hitCount;
    }

}

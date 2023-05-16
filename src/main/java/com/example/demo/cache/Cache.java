package com.example.demo.cache;

import java.util.HashMap;
import java.util.Map;


public class Cache<K, V> {

    private Map<K, LruCacheNode> map;
    private LruCacheNode first, last;
    private int size;
    private final int CAPACITY;
    private int hitCount = 0;
    private int mistCount = 0;

    public Cache(int capacity) {
        CAPACITY = capacity;
        this.map = new HashMap<>(CAPACITY);
    }

    public int size() {
        return size;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getMistCount() {
        return mistCount;
    }

    /**
     * Get data from map
     * Increment the counter for that item. ( Useful for lease frequently used )
     * Reorder the linked list.
     *
     * @param key
     * @return
     */
    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        LruCacheNode node = (LruCacheNode) map.get(key);
        node.incrementCount();
        reorder(node);
        return (V) node.getValue();

    }

    /**
     * The latest accessed node will be at the last end along with newly added items.
     * In this way, we can delete from the first easily.
     *
     * @param node
     */
    private void reorder(LruCacheNode node) {
        if (last == node) {
            return;
        }
        if (first == node) {
            first = node.getNext();
        } else {
            /* Adjusting pointer for the node in the middle */
            node.getPrev().setNext(node.getNext());
        }
        last.setNext(node);
        node.setPrev(last);
        node.setNext(null);
        last = node;
    }

    /**
     * 1. If key already exists, update the value
     * 2. Otherwise, If size exceeds capacity
     * 3. Delete existing node using appropriate strategy
     * 4. Add new node in the top
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        LruCacheNode node = new LruCacheNode(key, value);

        if (!map.containsKey(key)) {
            if (size() >= CAPACITY) {
                deleteNode(first);
            }
            addNodeToLast(node);
        }
        map.put(key, node);
    }

    public void delete(K key) {
        deleteNode(map.get(key));
    }

    /**
     * Remove node from map
     * Delete all references associated with that node.
     *
     * @param node
     */
    private void deleteNode(LruCacheNode node) {
//        if (node == null) {
//            return;
//        }
        if (last == node) {
            last = node.getPrev();
        }
        if (first == node) {
            first = node.getNext();
        }
        map.remove(node.getKey());
        node = null;
        size--;
    }

    /**
     * Add node to the top.
     * The last pointer will reference to the last inserted node.
     *
     * @param node
     */
    private void addNodeToLast(LruCacheNode node) {
        if (last != null) {
            last.setNext(node);
            node.setPrev(last);
        }

        last = node;
        if (first == null) {
            first = node;
        }
        size++;
    }

    /*Extra handling*/

    /**
     * Least Frequently Used (LFU)
     * Delete candidate is the least accessed entry.
     * We have to sort items based on the frequency the nodes being accessed.
     * To avoid getting deleted, for each accessed items needs to reach top based on their frequency.
     * <p>
     * Iterated a loop, which swaps the node if the frequency is greater than it’s next node frequency.
     *
     * @param node
     */
    private void reorder1(LruCacheNode node) {
        if (last == node) {
            return;
        }
        LruCacheNode nextNode = node.getNext();
        while (nextNode != null) {
            if (nextNode.getHitCount() > node.getHitCount()) {
                break;
            }
            if (first == node) {
                first = nextNode;
            }
            if (node.getPrev() != null) {
                node.getPrev().setNext(nextNode);
            }
            nextNode.setPrev(node.getPrev());
            node.setPrev(nextNode);
            node.setNext(nextNode.getNext());
            if (nextNode.getNext() != null) {
                nextNode.getNext().setPrev(node);
            }
            nextNode.setNext(node);
            nextNode = node.getNext();
        }
        if (node.getNext() == null) {
            last = node;
        }
    }

    /**
     * This way, there is an edge case where, after adding items that require delete from the start can
     * cause deletion of the high frequency node.
     * To solve this issue, we need to add nodes pointing our first node for least frequently accessed.
     *
     * @param node
     */
    private void addNodeToFirst(LruCacheNode node) {
        if (first != null) {
            node.setNext(first);
            first.setPrev(node);
        }
        first = node;

        if (last == null) {
            last = node;
        }
        size++;
    }
}

package com.example.demo;

import java.util.Queue;

public class Consumer implements Runnable {
    public Queue queue;

    public void Consumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        queue.stream().forEach(System.out::println);
    }
}

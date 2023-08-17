package com.example.demo;

import java.util.Queue;

public class Producer implements Runnable {


    public Queue queue;

    @Override
    public void run() {
        queue.add(Integer.parseInt(String.valueOf(Math.random())));
    }

    //    public Queue queue;
//    public int[] intProducer() {
//        int[] intArray = new int[20];
//        queue.add(Integer.parseInt(String.valueOf(Math.random())));
//
//        for (int i = 0; i < 20; i++) {
////            queue.add(Integer.parseInt(String.valueOf(Math.random())));
//        }
//        return intArray;
//    }


}


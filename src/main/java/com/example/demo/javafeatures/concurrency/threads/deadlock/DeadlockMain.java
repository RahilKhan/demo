package com.example.demo.javafeatures.concurrency.threads.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import com.example.demo.concurrency.threads.deadlock.RsrcA;
import com.example.demo.concurrency.threads.deadlock.RsrcB;

public class DeadlockMain {

    public static void main(String... args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(new Service1(new RsrcA(), new RsrcB()));
        executor.submit(new Service1(new RsrcA(), new RsrcB()));

        executor.shutdown();
        System.out.println("Done");

        Future<String> future = (Future<String>) executor.submit(new Service1(new RsrcA(), new RsrcB()));
        future.isDone();
    }
}

package com.example.demo.javafeatures.concurrency.threads;

public class ThreadLocalExample {

    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        ThreadLocal<String> threadLocalString = new ThreadLocal<>();

        Thread thread1 = new Thread(() -> {
            threadLocal.set((int) (Math.random() * 100D));
            threadLocalString.set("Hello");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 1: " + threadLocalString.get() + " : " + threadLocal.get());
            threadLocal.remove();
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set((int) (Math.random() * 100D));
            threadLocalString.set("World");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2: " + threadLocalString.get() + " : " + threadLocal.get());
            threadLocal.remove();
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
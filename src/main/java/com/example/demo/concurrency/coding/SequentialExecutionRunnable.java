package com.example.demo.concurrency.coding;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SequentialExecutionRunnable implements Runnable {

    String semaphore;

    public SequentialExecutionRunnable(String semaphore) {
        this.semaphore = semaphore;
    }


    @Override
    public void run() {
        if (Thread.currentThread().getName().equals(semaphore)) {
            log.info(Thread.currentThread().getName() + " : " + semaphore);
        }
    }


}

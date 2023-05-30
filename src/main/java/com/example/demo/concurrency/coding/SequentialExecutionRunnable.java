package com.example.demo.concurrency.coding;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SequentialExecutionRunnable implements Runnable {

    @Override
    public void run() {
        log.info("Thread{} : semaphore-{}", Thread.currentThread().getId(), SequentialExeMain.semaphore);
        if (Thread.currentThread().getId() == SequentialExeMain.semaphore) {
            log.info("Match found Thread{} : semaphore-{}", Thread.currentThread().getId(), SequentialExeMain.semaphore);
            SequentialExeMain.semaphore++;
        } else {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}

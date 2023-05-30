package com.example.demo.concurrency.coding;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SequentialExeMain {

    public volatile static long semaphore;
    public static long threadLowestId = 0;

    public static void main(String... args) {

        Thread thread = null;
        SequentialExecutionRunnable sequentialExecutionRunnable = null;
        for (int i = 0; i < 10; i++) {
            sequentialExecutionRunnable = new SequentialExecutionRunnable();
            thread = new Thread(sequentialExecutionRunnable);
            if (threadLowestId == 0 || threadLowestId > thread.getId())
                threadLowestId = thread.getId();
            //log.info("index({}) - Creating thread-{} - threadLowestId({})", i, thread.getId(), threadLowestId);
            thread.start();
        }

        SequentialExeMain.semaphore = threadLowestId;
        log.info("semaphore-{} - threadLowestId({})", SequentialExeMain.semaphore, threadLowestId);
    }

}

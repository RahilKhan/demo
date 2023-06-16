package com.example.demo.javafeatures.concurrency.threads.exeution.simultaneous;

import java.time.Instant;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch example.
 * We use a CountDownLatch to block threads until other threads have completed their tasks.
 * 
 * @author Rahil_Khan
 */
public class WorkerWithCountDownLatch extends Thread {
	private CountDownLatch latch;

	public WorkerWithCountDownLatch(String name, CountDownLatch latch) {
		this.latch = latch;
		setName(name);
	}

	@Override
	public void run() {
		try {
			System.out.printf("[ %s ] created, blocked by the latch...\n", getName());
			latch.await();
			System.out.printf("[ %s ] starts at: %s\n", getName(), Instant.now());
			// do actual work here...
		} catch (InterruptedException e) {
			System.out.printf("WorkerWithCountDownLatch.run() exception " + e.getMessage());
		}
	}

}

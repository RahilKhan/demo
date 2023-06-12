package com.example.demo.concurrency.threads.exeution.simultaneous;

import java.time.Instant;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier example.
 * CyclicBarrier allows fixed number of threads to wait for each other  
 * to reach a common point before continuing execution.
 * @author Rahil_Khan
 *
 */
public class WorkerWithCyclicBarrier extends Thread{

	CyclicBarrier cyclicBarrier;
	
	public WorkerWithCyclicBarrier(String name, CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
		this.setName(name);
	}
	
	@Override
	public void run() {
		try {
			System.out.printf("[ %s ] created, blocked by the latch...\n", getName());
			cyclicBarrier.await();
			System.out.printf("[ %s ] starts at: %s\n", getName(), Instant.now());
			// do actual work here...
		} catch (InterruptedException | BrokenBarrierException e) {
			System.out.printf("WorkerWithCyclicBarrier.run() exception " + e.getMessage());
		}
	}
	
}

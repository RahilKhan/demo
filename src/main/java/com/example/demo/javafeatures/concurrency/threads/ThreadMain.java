/**
 * 
 */
package com.example.demo.javafeatures.concurrency.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;

import com.example.demo.javafeatures.concurrency.threads.exeution.simultaneous.WorkerWithCountDownLatch;
import com.example.demo.javafeatures.concurrency.threads.exeution.simultaneous.WorkerWithCyclicBarrier;
import com.example.demo.javafeatures.concurrency.threads.exeution.simultaneous.WorkerWithPhaser;

/**
 * @author Rahil_Khan
 *
 */
public class ThreadMain {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws BrokenBarrierException 
	 */
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		usingCountDownLatch();
		usingCyclicBarrier();
		usingPhaser();

	}

	private static void usingCountDownLatch() throws InterruptedException {
	    System.out.println("===============================================");
	    System.out.println("        >>> Using CountDownLatch <<<<");
	    System.out.println("===============================================");

	    CountDownLatch latch = new CountDownLatch(1);

	    WorkerWithCountDownLatch worker1 = new WorkerWithCountDownLatch("Worker with latch 1", latch);
	    WorkerWithCountDownLatch worker2 = new WorkerWithCountDownLatch("Worker with latch 2", latch);

	    worker1.start();
	    worker2.start();

	    Thread.sleep(10);//simulation of some actual work

	    System.out.println("-----------------------------------------------");
	    System.out.println(" Now release the latch:");
	    System.out.println("-----------------------------------------------");
	    latch.countDown();
	}
	
	private static void usingCyclicBarrier() throws InterruptedException, BrokenBarrierException {
	    System.out.println("\n===============================================");
	    System.out.println("        >>> Using CyclicBarrier <<<");
	    System.out.println("===============================================");

	    CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

	    WorkerWithCyclicBarrier worker1 = new WorkerWithCyclicBarrier("Worker with CyclicBarrier 1", cyclicBarrier);
	    WorkerWithCyclicBarrier worker2 = new WorkerWithCyclicBarrier("Worker with CyclicBarrier 2", cyclicBarrier);

	    worker1.start();
	    worker2.start();

	    Thread.sleep(10);//simulation of some actual work

	    System.out.println("-----------------------------------------------");
	    System.out.println(" Now open the phaser barrier:");
	    System.out.println("-----------------------------------------------");
	    cyclicBarrier.await();
	}
	
	private static void usingPhaser() throws InterruptedException {
	    System.out.println("\n===============================================");
	    System.out.println("        >>> Using Phaser <<<");
	    System.out.println("===============================================");

	    Phaser phaser = new Phaser();
	    phaser.register();

	    WorkerWithPhaser worker1 = new WorkerWithPhaser("Worker with phaser 1", phaser);
	    WorkerWithPhaser worker2 = new WorkerWithPhaser("Worker with phaser 2", phaser);

	    worker1.start();
	    worker2.start();

	    Thread.sleep(10);//simulation of some actual work

	    System.out.println("-----------------------------------------------");
	    System.out.println(" Now open the phaser barrier:");
	    System.out.println("-----------------------------------------------");
	    phaser.arriveAndAwaitAdvance();
	}
}

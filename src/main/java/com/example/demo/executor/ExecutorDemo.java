/**
 * 
 */
package com.example.demo.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.cantire.tetris.log.TetrisLogger;
import com.example.demo.service.CalculationService;

/**
 * @author Rahil_Khan
 *
 */
public class ExecutorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);

		// Runnable, return void, nothing, submit and run the task async
		executor.submit(() -> TetrisLogger.info("I'm Runnable task."));
		// Callable, return a future, submit and run the task async
		Future<Integer> futureTask1 = executor.submit(() -> {
			TetrisLogger.info("I am Callable task.");
			return 1 + 1;
		});

		TetrisLogger.info("I am Callable task: futureCalcSrvc");
		CalculationService calSrvc = new CalculationService();
//		for (Integer i = 0; i < 4; i++) {
//			TetrisLogger.info("------------------------" + i + "--------------------------");
			Future<Double> futureMultiply = executor.submit(() -> {
				return calSrvc.multiply(10, 2);
			});

			Future<Double> futurePow = executor.submit(() -> {
				return calSrvc.pow(10, 0);
			});

			Future<Double> futureAreaOfCircle = executor.submit(() -> {
				return calSrvc.areaOfCircle(3);
			});

			try {

				otherTask("Before Future Result");

				// block until future returned a result,
				// timeout if the future takes more than 5 seconds to return the result
				Integer result = futureTask1.get(5, TimeUnit.SECONDS);
				TetrisLogger.info("Get future result : " + result);

				Double futureMultipleResult = futureMultiply.get();
				TetrisLogger.info("futureMultipleResult : " + futureMultipleResult);

				Double futurePowResult = futurePow.get();
				TetrisLogger.info("futurePowResult : " + futurePowResult);

				Double futureAreaOfCircleResult = futureAreaOfCircle.get();
				TetrisLogger.info("futureAreaOfCircleResult : " + futureAreaOfCircleResult);

				otherTask("After Future Result");

			} catch (InterruptedException e) {// thread was interrupted
				e.printStackTrace();
			} catch (ExecutionException e) {// thread threw an exception
				e.printStackTrace();
			} catch (TimeoutException e) {// timeout before the future task is complete
				e.printStackTrace();
			} finally {

				// shut down the executor manually
				executor.shutdown();

			}
		}
//	}

	private static void otherTask(String name) {
		TetrisLogger.info("I'm other task! " + name);
	}

	private static void threadTask(String name) {
		TetrisLogger.info("I'm thread task! " + name);
	}

}

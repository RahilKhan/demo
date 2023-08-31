package com.example.demo.javafeatures.concurrency.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.example.demo.service.CalculationService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rahil_Khan
 */
@Slf4j
public class ExecutorDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Runnable, return void, nothing, submit and run the task async
        executor.submit(() -> log.info("I'm Runnable task."));
        // Callable, return a future, submit and run the task async
        Future<Integer> futureTask1 = executor.submit(() -> {
            log.info("I am Callable task.");
            return 1 + 1;
        });

        log.info("I am Callable task: futureCalcSrvc");
        CalculationService calSrvc = new CalculationService();
//		for (Integer i = 0; i < 4; i++) {
//			log.info("------------------------" + i + "--------------------------");
        Future<Double> futureMultiply = executor.submit(() -> calSrvc.multiply(10, 2));

        Future<Double> futurePow = executor.submit(() -> calSrvc.pow(10, 0));

        Future<Double> futureAreaOfCircle = executor.submit(() -> calSrvc.areaOfCircle(3));

        try {

            otherTask("Before Future Result");

            // block until future returned a result,
            // timeout if the future takes more than 5 seconds to return the result
            Integer result = futureTask1.get(5, TimeUnit.SECONDS);
            log.info("Get future result : " + result);

            Double futureMultipleResult = futureMultiply.get();
            log.info("futureMultipleResult : " + futureMultipleResult);

            Double futurePowResult = futurePow.get();
            log.info("futurePowResult : " + futurePowResult);

            Double futureAreaOfCircleResult = futureAreaOfCircle.get();
            log.info("futureAreaOfCircleResult : " + futureAreaOfCircleResult);

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
        log.info("I'm other task! " + name);
    }

    private static void threadTask(String name) {
        log.info("I'm thread task! " + name);
    }

}

package com.javaworld.concurrent;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ConcurrentExamples {


    @Test
    public void executorServiceExample() throws InterruptedException {
        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {
            // Submit multiple tasks
            List<Future<Integer>> futures = new ArrayList<>();
            futures.add(executor.submit(() -> task(1, 1500)));
            futures.add(executor.submit(() -> task(2, 1000)));
            futures.add(executor.submit(() -> task(3, 2000)));
            while(!futures.isEmpty()) {
                futures.removeIf(future -> {
                    try {
                        return isDone(future);
                    } catch (ExecutionException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
                Thread.sleep(200);
            }
        }
    }


    private boolean isDone(Future<Integer> future) throws ExecutionException, InterruptedException {
        if (future.isDone()) {
            //blocking call
            System.out.println("Task " + future.get() + " completed");
            return true;
        }
        return false;
    }

    private int task(int id, int sleepTime) throws InterruptedException {
        System.out.println("Starting task " + id);
        Thread.sleep(sleepTime);
        return id;
    }

    @Test
    public void completableFutureExample() {
        // Chain multiple async operations
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApplyAsync(s -> s + " World")
                .thenAcceptAsync(System.out::println);

        // Combine multiple futures
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);

        future1.thenCombine(future2, Integer::sum)
                .thenAccept(sum -> System.out.println("Sum: " + sum));
    }

    @Test
    public void parallelStreamsExample() {
        long startTime = System.currentTimeMillis();

        // Sequential stream
        IntStream.range(1, 6)
                .forEach(i -> System.out.println("Sequential: " + i));

        // Parallel stream
        IntStream.range(1, 6)
                .parallel()
                .forEach(i -> System.out.println("Parallel: " + i));

        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    @Test
    public void countDownLatchExample() {
        final int THREAD_COUNT = 3;
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        IntStream.range(0, THREAD_COUNT).forEach(i ->
                executor.execute(() -> {
                    try {
                        System.out.println("Thread " + i + " is working...");
                        Thread.sleep(1000 * (i + 1));
                        System.out.println("Thread " + i + " completed");
                        latch.countDown();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                })
        );

        try {
            latch.await();
            System.out.println("All threads have completed their work!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        executor.shutdown();
    }

    @Test
    public void intStreamExample() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = IntStream.of(numbers).sum();
        System.out.println("Sum: " + sum);
    }


}

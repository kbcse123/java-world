package com.javaworld.A4_Advanced_Java._2_Concurrency.A0_Introduction;

import com.javaworld.AppUtil;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * virtual threads (JEP-425) are JVM-managed lightweight threads that help in writing high-throughput
 * concurrent applications (throughput means how many units of information a system can process in a
 * given amount of time).
 *
 * In contrast to platform threads, the virtual threads are not wrappers of OS threads. They are
 * lightweight Java entities (with their own stack memory with a small footprint – only a few hundred
 * bytes) that are cheap to create, block, and destroy. We can create many of them at the same time
 * (millions) so they sustain a massive throughput.
 *
 * Virtual threads are stored in the JVM heap (and they take advantage of Garbage Collector) instead
 * of the OS stack. Moreover, virtual threads are scheduled by the JVM via a work-stealing
 * ForkJoinPool scheduler. Practically, JVM schedules and orchestrates virtual threads to run on
 * platform threads in such a way that a platform thread executes only one virtual thread at a time.
 *
 */
public class A8_VirtualThreads {
    public static void main(String[] args) {
        long startMemory = AppUtil.startMemory();
        System.out.println("Available Processors: "+Runtime.getRuntime().availableProcessors());
        final AtomicInteger counter = new AtomicInteger();
        //usingPlatformOrNativeThreads(counter);
        usingVirtualThreads(counter);
        System.out.println("Memory utilized so far:"+AppUtil.memoryConsumed(startMemory));
    }

    private static void usingPlatformOrNativeThreads(AtomicInteger counter) {
        System.out.println("******* usingPlatformThreads *******");
        Instant start = Instant.now();
        try (var executor = Executors.newFixedThreadPool(1000)) {  //newWorkStealingPool()
            for(int i = 0; i < 1000; i++) {
                executor.submit(task(counter));
            }
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Total elapsed time : " + timeElapsed+" ms");
    }

    private static void usingVirtualThreads(AtomicInteger counter) {
        System.out.println("\n******* usingVirtualThreads *******");
        Instant start = Instant.now();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for(int i = 0; i < 1000; i++) {
                executor.submit(task(counter));
            }
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Total elapsed time : " + timeElapsed+" ms");
    }

    private static Runnable task(AtomicInteger counter) {

        Runnable runnable = () -> {
            try {
                Thread.sleep(Duration.ofMillis(200));
            } catch(Exception e) {
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName() + ": Work Done - " + counter.incrementAndGet());
        };
        return runnable;
    }
}

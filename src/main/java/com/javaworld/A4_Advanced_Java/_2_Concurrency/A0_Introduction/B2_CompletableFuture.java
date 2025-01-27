package com.javaworld.A4_Advanced_Java._2_Concurrency.A0_Introduction;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture is a powerful feature introduced in Java 8. we can write asynchronous, non-blocking
 * code, to manage difficult operations that could function simultaneously.It is particularly useful in
 * scenarios where:
 *   .Multiple tasks need to be performed asynchronously and possibly combined later.
 *   .Long-running tasks can be run in parallel without blocking the main thread.
 *   .Handling IO-bound processes like database requests, file handing out, or website service
 *    callings.
 * Methods in CompletableFuture:
 *  1) thenApply() - this method is used to process and transform the result of a CompletableFuture once
 *                   it is completed.
 *
 *  2) thenAccept() - a terminal operation in the CompletableFuture pipeline that consumes the
 *                    result of a CompletableFuture once it is completed.It simply processes the result
 *                    without returning any value. This method is particularly useful when you need to
 *                    perform an action based on the result, such as logging, printing, or updating a
 *                    UI component, but do not need to pass the result down the chain. The primary
 *                    purpose of thenAccept() is to perform side effects, such as interacting with
 *                    external systems, updating state, or triggering events.
 *
 *  3) thenCombine() - is used to combine the results of two CompletableFuture instances once both are
 *                    completed. Once both CompletableFuture instances complete, the BiFunction is
 *                    executed with the results of both futures, producing a new result. This mutual
 *                    result is later closedd in a new CompletableFuture, which is further bound or
 *                    administered.
 *
 *  4) exceptionally() - The primary purpose of exceptionally() is to handle exceptions that occur
 *                   during the asynchronous computation. It provides a fallback mechanism that ensures
 *                   the CompletableFuture can still complete successfully, albeit with an alternative
 *                   result.
 *
 *
 *
 *
 *
 *
 */
public class B2_CompletableFuture {

    @Test
    public void thenApplyTest(){
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> "then")
                .thenApply(result -> result + " Apply");
        System.out.println(future.join()); // Output: Hello World
    }

    @Test
    public void thenAcceptTest(){
         CompletableFuture.supplyAsync(() -> "thenAccept")
                .thenAccept(result -> System.out.println("Result: " + result));
    }

    @Test
    public void thenCombineTest(){
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");
        CompletableFuture<String> combinedFuture = future1.
                thenCombine(future2, (result1, result2) -> result1 + " " + result2);
        System.out.println(combinedFuture.join()); // Output: Hello World
    }

    @Test
    public void exceptionallyTest(){
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("Invalid Condition");
            }
            return "Result";
        }).exceptionally(ex -> "Exception Occurred: " + ex.getMessage());
        System.out.println(future.join()); // Output: Handled Exception: Exception occurred!
    }

}

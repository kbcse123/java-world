package com.javaworld.A4_Advanced_Java._2_Concurrency.A0_Introduction;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * CompletableFuture is a powerful feature introduced in Java 8. we can write asynchronous, non-blocking
 * code, to manage difficult operations that could function simultaneously. It is particularly useful in
 * scenarios where:
 *   .Multiple tasks need to be performed asynchronously and possibly combined later.
 *   .Long-running tasks can be run in parallel without blocking the main thread.
 *   .Handling IO-bound processes like database requests, file handing out, or website service
 *    callings.
 * Methods in CompletableFuture:
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
 *  4) join()   -   CompletableFuture API exposes the join() method as a way of retrieving the value of
 *                  the Future object by blocking the thread until the execution is completed.
 *
 * Exception handling in CompletableFuture can be done using methods like exceptionally(), handle(), and
 * whenComplete(). These methods allow you to recover from exceptions or handle them gracefully without
 * disrupting the workflow.
 *
 *  1) exceptionally() - The primary purpose of exceptionally() is to handle exceptions that occur
 *                   during the asynchronous computation. It provides a fallback mechanism that ensures
 *                   the CompletableFuture can still complete successfully, albeit with an alternative
 *                   result. used for individual task exception handling
 *
 *  2) handle() - allows you to process the result or handle an exception. used for global exception
 *                handling
 *
 *  3) whenComplete() - method allows you to perform an action after the CompletableFuture is complete,
 *                  regardless of whether it completed successfully or exceptionally.
 *
 *
 */
public class B2_CompletableFuture {

    /**
     * thenApply() is used to process and transform the result of a CompletableFuture once it is completed.
     */
    @Test
    public void thenApplyTest(){
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> "then")
                .thenApply(result -> result + " Apply");
        System.out.println(future.join()); // Output: Hello World
    }

    /**
     * thenAccept() is used to process and transform the result of a CompletableFuture once it is completed.
     */
    @Test
    public void thenAcceptTest(){
         CompletableFuture.supplyAsync(() -> "thenAccept")
                .thenAccept(result -> System.out.println("Result: " + result));
    }

    /**
     * thenCombine() is used to combine the results of two CompletableFuture instances once both are completed.
     * It returns a new CompletableFuture that holds the result of the given BiFunction.
     */
    @Test
    public void thenCombineTest(){
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");
        CompletableFuture<String> combinedFuture = future1.
                thenCombine(future2, (result1, result2) -> result1 + " " + result2);
        System.out.println(combinedFuture.join()); // Output: Hello World
    }

    /**
     *
     */
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

    /**
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void handleTest() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            if (false) {
                throw new RuntimeException("Error occurred in future1 !");
            }
            return "Success in future1";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("Error occurred in future2 !");
            }
            return "Success in future2";
        });
        CompletableFuture<String> combinedFuture = future1
                .thenCombine(future2, (result1, result2) -> result1 + " " + result2)
                .handle((result, ex) -> {
                    if (ex != null) {
                        return "Handled Error: " + ex.getMessage();
                    }
                    return result;
                });

        System.out.println(combinedFuture.get()); // Output: Handled Error: Error occurred!
    }

    /**
     *
     */
    @Test
    public void whenCompleteTest(){
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("Exception occurred!");
            }
            return "Success";
        }).whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("Exception: " + ex.getMessage());
            } else {
                System.out.println("Result: " + result);
            }
        });

        future.join(); // Output: Exception: Exception occurred!
    }

    /**
     *  The static method allOff() allows us to combine multiple CompletableFuture instances and returns a
     *  CompletableFuture<Void>. The completion of the resulting objects is dependent on the completion of all
     *  subsequent Futures. Moreover, if any of the subsequent Futures completes exceptionally, the overall result will
     *  also be considered a failure. It’s important to understand that allOf() is not a blocking method, which means
     *  that it will be executed instantly:
     *
     *  However, in order to extract the values, we’ll need to call additional methods of the API. For example, if we
     *  call join() on the resulting CompletableFuture<Void>, the thread will wait for the two composing
     *  CompletableFuture objects to complete
     */
    @Test
    public void allOfTest()  {

        CompletableFuture<String> f1 = waitAndReturn(1_000, "Harry");
        CompletableFuture<String> f2 = waitAndReturn(2_000, "Ron");

        CompletableFuture.allOf(f1, f2)
                .thenAccept(justVoid -> {
                    System.out.println("Doing other tasks...");
                });
        System.out.println("Doing other tasks...");

        /*List<String> messages = Arrays.asList("Msg1", "Msg2", "Msg3", "Msg4", "Msg5", "Msg6",
                "Msg7", "Msg8", "Msg9", "Msg10", "Msg11", "Msg12");
        List<String> mapResult = new ArrayList<>();
        CompletableFuture<?>[] fanoutRequestList = new CompletableFuture[messages.size()];
        int count = 0;
        for (String msg : messages) {
            CompletableFuture<?> future = CompletableFuture
                    .supplyAsync(() -> "Processed " + msg)
                    .exceptionally(ex -> "Error")
                    .thenAccept(mapResult::add);
            fanoutRequestList[count++] = future;
        }
        CompletableFuture.allOf(fanoutRequestList)
                .thenAccept(justVoid -> {
                    List<String> list = mapResult.stream()
                            .filter(s -> !s.equalsIgnoreCase("Error"))
                            .toList();
                    System.out.println(list);
                });

        System.out.println("Operation done...");*/
    }

    /**
     * CompletableFuture API exposes the join() method as a way of retrieving the value of the Future object by
     * blocking the thread until the execution is completed. We should notice that the caller thread will be blocked
     * even if the execution of the CompletableFuture is happening on a different thread:
     *
     * Furthermore, if the CompletableFuture completes with an error,  join() will throw it as a RuntimeException:
     */
    @Test
    public void joinTest() {
        CompletableFuture<String> future = waitAndReturn(1_000, "Harry");
        assertEquals("Harry", future.join());

        CompletableFuture<String> futureError = waitAndThrow(1_000);
        assertThrows(RuntimeException.class, futureError::join);
    }


    private CompletableFuture waitAndReturn(long millis, String value) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(millis);
                return value;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private CompletableFuture waitAndThrow(long millis) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(millis);
            } finally {
                throw new RuntimeException();
            }
        });
    }

}

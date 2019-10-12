package learning.java.core.multithreading.BnexLevel.completableFuture.firstSimplest;

import learning.java.core.multithreading.BnexLevel.completableFuture.common.UtilsCompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * first example
 */
public class CompletableFutureMain {
    public static void main(String[] args) {
        doItAsync();
    }

    private static void doItAsync() {
        long started = System.currentTimeMillis();

        // configure CompletableFuture
        CompletableFuture<Integer> futureCount = UtilsCompletableFuture.createCompletableFuture(5000L);
        CompletableFuture<Integer> futureCount2 = UtilsCompletableFuture.createCompletableFuture(2000L);

        // continue to do other work
        System.out.println("Took " + (started - System.currentTimeMillis()) + " milliseconds");

        // now its time to get the result
        try {

            int count = futureCount.get();
            System.out.println("CompletableFuture took " + (started - System.currentTimeMillis()) + " milliseconds");

            System.out.println("Result " + count);

            int count2 = futureCount2.get();
            System.out.println("CompletableFuture2 took " + (started - System.currentTimeMillis()) + " milliseconds");
            System.out.println("Result " + count2);

        } catch (InterruptedException | ExecutionException ex) {
            // Exceptions from the future should be handled here
        }
    }


}
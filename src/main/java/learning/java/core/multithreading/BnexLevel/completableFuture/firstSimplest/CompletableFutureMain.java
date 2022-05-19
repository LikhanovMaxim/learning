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
        CompletableFuture<Long> futureCount = UtilsCompletableFuture.createCompletableFuture(5_000L);
        CompletableFuture<Long> futureCount2 = UtilsCompletableFuture.createCompletableFuture(2_000L);

        // continue to do other work
        logCurrentTime("Took ", started);

        // now its time to get the result
        try {
            Long count = futureCount.get();
            logCurrentTime("CompletableFuture took ", started);
            System.out.println("Result " + count);

            Long count2 = futureCount2.get();
            logCurrentTime("CompletableFuture2 took ", started);
            System.out.println("Result " + count2);
        } catch (InterruptedException | ExecutionException ex) {
            // Exceptions from the future should be handled here
        }
    }

    private static void logCurrentTime(String message, long started) {
        System.out.println(message + (System.currentTimeMillis() - started) + " milliseconds");
    }


}

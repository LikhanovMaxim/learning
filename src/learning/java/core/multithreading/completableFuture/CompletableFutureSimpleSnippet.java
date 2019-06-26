package learning.java.core.multithreading.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSimpleSnippet {
    public static void main(String[] args) {
        long started = System.currentTimeMillis();

        // configure CompletableFuture
        CompletableFuture<Integer> futureCount = createCompletableFuture(5000L);
        CompletableFuture<Integer> futureCount2 = createCompletableFuture(2000L);

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

    private static CompletableFuture<Integer> createCompletableFuture(Long millis) {
        CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        // simulate long running task
                        Thread.sleep(millis);
                    } catch (InterruptedException e) {
                    }
                    return 20;
                });
        return futureCount;
    }


}
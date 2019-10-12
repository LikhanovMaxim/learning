package learning.java.core.multithreading.BnexLevel.completableFuture.common;

import java.util.concurrent.CompletableFuture;

public class UtilsCompletableFuture {

    public static CompletableFuture<Integer> createCompletableFuture(Long millis) {
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

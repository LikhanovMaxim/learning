package learning.java.core.multithreading.BnexLevel.completableFuture.common;

import java.util.concurrent.CompletableFuture;

public class UtilsCompletableFuture {

    public static CompletableFuture<Long> createCompletableFuture(Long millis) {
        System.out.println(Thread.currentThread() + " createCompletableFuture " + millis);
        CompletableFuture<Long> futureCount = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        // simulate long running task
                        System.out.println(Thread.currentThread() + " createCompletableFuture sleep " + millis + "...");
                        Thread.sleep(millis);
                    } catch (InterruptedException ignored) {
                    }
                    return millis/1000;
                });
        return futureCount;
    }
}

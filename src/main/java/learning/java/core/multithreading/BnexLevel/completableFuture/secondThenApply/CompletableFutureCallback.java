package learning.java.core.multithreading.BnexLevel.completableFuture.secondThenApply;

import learning.java.core.multithreading.BnexLevel.completableFuture.common.UtilsCompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCallback {

    private static final long SLEEP = 2000L;

    public static void main(String[] args) {
        System.out.println("\nExample with thenApply");
        example1ThenApply();
        System.out.println("\nExample with thenApply & accept");
        example1_2_ThenApplyAndAccept();
        System.out.println("\nExample with exception");
        example1_3_Exception();
        System.out.println("\nExample with exception [2]");
        example1_4_Exception();
//        example_2_Async();
    }

    private static void example1_4_Exception() {
        long started = System.currentTimeMillis();

        CompletableFuture<String> data = getStringCompletableFuture()
                .thenApply((string) -> getObject())
                .exceptionally(e -> {
                    System.out.println(e);
                    return null;
                });

        getDataAndLog(started, data);
    }

    private static void example1_3_Exception() {
        long started = System.currentTimeMillis();

        CompletableFuture<String> data = getStringCompletableFuture()
                .thenApply((string) -> getObject())
                .exceptionally((Throwable::getMessage));

        getDataAndLog(started, data);
    }

    private static String getObject() {
        if (true)
            throw new RuntimeException("happens exception");
        return "sd";
    }

    private static void example1_2_ThenApplyAndAccept() {
        long started = System.currentTimeMillis();

        CompletableFuture<Void> data = getStringCompletableFuture().thenAccept(System.out::println);
        try {
            data.get();
        } catch (InterruptedException | ExecutionException e) {
        }
        System.out.println("CompletableFuture took " + (System.currentTimeMillis() - started) + " milliseconds");
    }

    private static void example1ThenApply() {
        long started = System.currentTimeMillis();

        CompletableFuture<String> data = getStringCompletableFuture();

        getDataAndLog(started, data);
    }

    private static CompletableFuture<String> getStringCompletableFuture() {
        return UtilsCompletableFuture.createCompletableFuture(SLEEP)
                .thenApply((Long count) -> count * 10)
                .thenApply(transformed -> "Finally creates a string: " + transformed);
    }


    private static void getDataAndLog(long started, CompletableFuture<String> data) {
        try {
            System.out.println(data.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getStackTrace());
        }
        System.out.println("CompletableFuture took " + (System.currentTimeMillis() - started) + " milliseconds");
    }

    /**
     * TODO what is the diff?
     */
    private static void example_2_Async() {
        long started = System.currentTimeMillis();

        CompletableFuture<String> data = UtilsCompletableFuture.createCompletableFuture(SLEEP)
                .thenApplyAsync((Long count) -> count * 10)
                .thenApplyAsync(transformed -> "Finally creates a string: " + transformed);

        getDataAndLog(started, data);
    }


}

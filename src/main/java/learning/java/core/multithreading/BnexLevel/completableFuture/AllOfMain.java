package learning.java.core.multithreading.BnexLevel.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllOfMain {
    public static void main(String[] args) {

        example2();
//        example_1();
    }

    private static void example2() {
        CompletableFuture<String> what = CompletableFuture.supplyAsync(() -> "What");
        CompletableFuture<String> the = CompletableFuture.supplyAsync(() -> "the");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "future");
        CompletableFuture<String> holds = CompletableFuture.supplyAsync(() -> "holds?");

        String result = Stream.of(what, the, future, holds)
                .map(m -> m.join())
                .collect(Collectors.joining(" "));

        System.out.println(result); //output: What the future holds?
    }

    private static void example_1() {
        CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 65.0;
        });
        CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 177.8;
        });
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(weightInKgFuture, heightInCmFuture);
//        CompletableFuture<Double> all = allFutures.thenApply((a, b)-> {
//            return a.;
//        })
    }
}

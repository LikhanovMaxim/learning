package learning.java.core.multithreading.completableFuture;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCallback {
    public static void main(String[] args) {
        smth();
//        smth2();
//        example_1();
    }

    private static void smth2() {
        List<String> list = new ArrayList<String>(Arrays.asList("one", "two", "three"));
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        unmodifiableList.add("four");
    }

    private static void example_1() {
        long started = System.currentTimeMillis();

        CompletableFuture<String> data = createCompletableFuture()
                .thenApply((Integer count) -> {
                    int transformedValue = count * 10;
                    return transformedValue;
                }).thenApply(transformed -> "Finally creates a string: " + transformed);

        try {
            System.out.println(data.get());
        } catch (InterruptedException | ExecutionException e) {

        }
    }

    public static CompletableFuture<Integer> createCompletableFuture() {
        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(() -> {
            try {
                // simulate long running task
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            return 20;
        });
        return result;
    }

    public static void smth() {
        List<String> list = new ArrayList<String>(Arrays.asList("one", "two", "three"));
        List<String> unmodifiableList = ImmutableList.copyOf(list);
        unmodifiableList.add("four");
    }
}
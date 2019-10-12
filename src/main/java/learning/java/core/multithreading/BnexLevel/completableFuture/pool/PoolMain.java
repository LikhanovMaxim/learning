package learning.java.core.multithreading.BnexLevel.completableFuture.pool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PoolMain {

    public static final int N_THREADS = 4;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(N_THREADS);
        List<CompletableFuture<String>> futures = new LinkedList<>();
        for (int i = 0; i < N_THREADS + 1; i++) {
            CompletableFuture<String> future = getStringCompletableFuture(executor);
            futures.add(future);
//            System.out.println(future.get());
        }
        for (CompletableFuture<String> future : futures) {
            System.out.println(future.get());
        }
        executor.shutdown();
    }

    private static CompletableFuture<String> getStringCompletableFuture(Executor executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Результат асинхронной задачи";
        }, executor);
    }
}

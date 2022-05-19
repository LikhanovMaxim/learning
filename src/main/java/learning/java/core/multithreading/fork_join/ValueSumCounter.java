package learning.java.core.multithreading.fork_join;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ValueSumCounter extends RecursiveTask<Integer> {
    int[] array;

    public ValueSumCounter(int[] array) {
        this.array = array;
    }

    @SneakyThrows
    @Override
    protected Integer compute() {
        if (array.length <= 2) {
            System.out.println(Thread.currentThread());
            Thread.sleep(1);
            return Arrays.stream(array).sum();
        }
        ValueSumCounter firstHalfArrayValueSumCounter = new ValueSumCounter(Arrays.copyOfRange(array, 0, array.length/2));
        ValueSumCounter secondHalfArrayValueSumCounter = new ValueSumCounter(Arrays.copyOfRange(array, array.length/2, array.length));
        firstHalfArrayValueSumCounter.fork();
        secondHalfArrayValueSumCounter.fork();
        return firstHalfArrayValueSumCounter.join() + secondHalfArrayValueSumCounter.join();
    }
}

package learning.java.core.multithreading.fork_join;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;

import static org.junit.jupiter.api.Assertions.*;

class ValueSumCounterTest {
    @Test
    public void invokeFromThePool() {
        int capacity = 10_000;
        int[] array = getInitArr(capacity);
        ValueSumCounter counter = new ValueSumCounter(array);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Integer result = forkJoinPool.invoke(counter);
        System.out.println(result);
        assertEquals(3*capacity, result);
    }

    private int[] getInitArr(int i) {
        int[] array = new int[i];
        for (int j = 0; j < i; j++) {
            array[j] = 3;
        }
        return array;
    }
}

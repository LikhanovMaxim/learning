package learning.java.core.multithreading.fork_join;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;

import static org.junit.jupiter.api.Assertions.*;

class SimpleClassTest {
    @Test
    public void invokeFromThePool() {
        SimpleClass simpleClass = new SimpleClass();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println(forkJoinPool.invoke(simpleClass));
    }

    @Test
    public void invokeByFork() {
        SimpleClass simpleClass = new SimpleClass();
        simpleClass.fork();
        System.out.println(simpleClass.join());
    }
}

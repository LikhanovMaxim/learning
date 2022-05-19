package learning.java.core.multithreading.fork_join;

import java.util.concurrent.RecursiveTask;

public class SimpleClass extends RecursiveTask<String> {
    @Override
    protected String compute() {
        System.out.println("I am work in thread: " + Thread.currentThread().getName());
        return "I am just innocent simple class";
    }
}

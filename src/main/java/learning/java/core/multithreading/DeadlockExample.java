package learning.java.core.multithreading;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    @SneakyThrows
    public static void main(String[] args) {
        ExampleLock example = new ExampleLock();
        Thread t1 = new Thread(example::first);
        Thread t2 = new Thread(example::second);

//        ExampleSync example = new ExampleSync();
//        val t1 = new Thread(() -> example.first(1));
//        val t2 = new Thread(() -> example.first(2));

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("done");
        System.out.println(example.set);
        System.out.println(example.strings);
    }


}

class ExampleSync {
    //todo Can use simpler?
    static String string = "";
    static Set<String> set = new HashSet<>();

    /*
    deadlock
    t1 block strings wait set
    t2 block set     wait string
     */
    @SneakyThrows
    void first(int number) {
        System.out.println(number);
        if (number % 2 == 0) {
            synchronized (string) {
//                string.add(String.valueOf(number));
                string += number;
                Thread.sleep(1000);
                synchronized (set) {
                    set.add(String.valueOf(number));
                }
            }
        } else {
            synchronized (set) {
                set.add(String.valueOf(number));
                Thread.sleep(1000);
                synchronized (string) {
//                    string.add(String.valueOf(number));
                    string += number;
                }
            }
        }
    }
}

class ExampleLock {
    List<String> strings = new ArrayList<>();
    Set<String> set = new HashSet<>();
    Lock lock = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    @SneakyThrows
    void first() {
        lock.lock();
        strings.add("a");
        Thread.sleep(1000);
        boolean f = lock2.tryLock(5000, TimeUnit.MILLISECONDS);
//        lock2.lock();
        set.add("a");
        lock.unlock();
        if (f) {
            lock2.unlock();
        }
    }

    @SneakyThrows
    void second() {
        lock2.lock();
        set.add("b");
        Thread.sleep(1000);
        boolean f = lock.tryLock(5000, TimeUnit.MILLISECONDS);
//        lock.lock();
        strings.add("b");
        lock2.unlock();
        if (f) {
            lock.unlock();
        }
    }
}
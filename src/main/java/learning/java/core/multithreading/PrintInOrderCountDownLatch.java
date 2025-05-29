package learning.java.core.multithreading;

import learning.java.core.classLoader.example1.C;
import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrderCountDownLatch {
    @SneakyThrows
    public static void main(String[] args) {
        Foo2 foo = new Foo2();
        Thread t1 = new Thread(()-> {
            try {
                foo.first(()-> System.out.println("first"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread t2 = new Thread(()-> {
            try {
                foo.second(()-> System.out.println("second"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(()-> {
            try {
                foo.third(()-> System.out.println("third"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t3.start();
        Thread.sleep(1000);
        t1.start();
        Thread.sleep(1000);
        t2.start();

        t1.join();
        t2.join();
        t3.join();
    }
}

class Foo2 {
    Semaphore s2 = new Semaphore(0);
    CountDownLatch first;
    CountDownLatch second;
    public Foo2() {
        System.out.println("Consrtruct");
        first = new CountDownLatch(1);
        second = new CountDownLatch(1);
        s2.release();
    }

    /*
    first - free to print
    second - wait to print
    third -
    */
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        first.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        second.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

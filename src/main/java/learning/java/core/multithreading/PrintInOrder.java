package learning.java.core.multithreading;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrder {
    @SneakyThrows
    public static void main(String[] args) {
        Foo foo = new Foo();
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

class Foo {
    Lock first = new ReentrantLock();
    Lock second = new ReentrantLock();
    public Foo() {
        System.out.println("Consrtruct");
//        first.lock();
//        second.lock();
    }

    /*
    first - free to print
    second - wait to print
    third -
    */
    public void first(Runnable printFirst) throws InterruptedException {
         first.lock();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        first.lock();
        second.lock();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        first.unlock();
        second.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        second.lock();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        second.unlock();
    }


    public int romanToInt(String s) {
        int sum = 0;
        for (int i=0; i< s.length(); i++) {
            switch(s.charAt(i)) {
                case 'I': {
                    if (i+1>=s.length() || s.charAt(i+1) == 'I'){
                        sum+=1;
                        continue;
                    }
                    sum-=1;
                    break;
                }
                case 'V': sum+=5;
                    break;
                case 'X': {
                    if (i+1 < s.length()) {
                        char next = s.charAt(i+1);
                        if(next == 'L' || next == 'C') {
                            sum-=10;
                            continue;
                        }
                    }
                    sum+=10;
                    break;
                }
                case 'L': sum+=50;
                case 'C': {
                    if (i+1 < s.length()) {
                        char next = s.charAt(i+1);
                        if(next == 'D' || next == 'M') {
                            sum-=100;
                            continue;
                        }
                    }
                    sum+=100;
                }
                case 'D': sum+=500;
                case 'M': sum+=1000;
                    // default
            }
        }
        return sum;
    }
}

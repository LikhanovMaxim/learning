package learning.java.core.multithreading.jmm;

/**
 * java memory model
 * https://habr.com/ru/post/440590/
 *
 *  another example https://www.geeksforgeeks.org/happens-before-relationship-in-java/
 */
public class HappensBefore {
    public static int x = 0, y = 0;
    public static int a = 0, b = 0;

    String example() throws InterruptedException {
        synchronized (this) {
            a = 0;
            b = 0;
            x = 0;
            y = 0;
        }
        Thread p = new Thread(() -> {
            a = 1;
            x = b;
        });

        Thread q = new Thread(() -> {
            b = 1;
            y = a;
        });

        p.start();
        q.start();
        p.join();
        q.join();

        System.out.println("x=" + x + ", y=" + y);
        return ((Integer) x).toString() + ((Integer) y);
    }

}

package learning.memoryManagment;

import java.util.LinkedList;
import java.util.List;

/**
 * VM options
 * 1) -Xmx256m -XX:+UseG1GC
 *     30 iterations
 * 2) -Xmx256m -XX:+UseG1GC -XX:+UseStringDeduplication -XX:+PrintStringDeduplicationStatistics
 *     50 iterations. It happens because strings duplicate and we delete duplicate strings.
 */
public class StringDeduplicationSample {

    private static final List<String> objects = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        int iteration = 0;

        while (true) {
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 1000; j++) {
                    objects.add(new String("String " + j));
                }
            }
            iteration++;
            System.out.println("Iteration: " + iteration);
            Thread.sleep(100);
        }
    }
}

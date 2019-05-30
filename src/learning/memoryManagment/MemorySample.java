package learning.memoryManagment;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

/**VM options
 * 1) -Xmx1024m -Xms512m -XX:+HeapDumpOnOutOfMemoryError
 */
public class MemorySample {

    public static void main(String[] args) {
        int mb = 1024 * 1024;
        int takeMemory = 100;
        byte[][] arr = new byte[mb][takeMemory];

        Runtime runtime = Runtime.getRuntime();

        long total = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        System.out.println("Used memory " + (total - freeMemory) / mb);
        System.out.println("Free memory " + freeMemory / mb);
        System.out.println("Total memory " + total / mb);
        /** when takeMemory=100, then total~433
         *  when takeMemory=500, then total~900
         */
        System.out.println("Max memory " + runtime.maxMemory() / mb);
        /** Max memory = 3614
         *  when takeMemory > Max memory, then java.lang.OutOfMemoryError: Java heap space
         *
         *   Formula for Java 7: Max memory = [-Xmx] + [-XX:MaxPermSize] + number_of_threads* [-Xss]
         */

        System.out.println(takeRAMSizeInCurOS() / mb);
    }

    /**
     * Use it when you know that OS is popular and impl is existed
     * @return
     */
    private static long takeRAMSizeInCurOS() {
        OperatingSystemMXBean os = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        return os.getTotalPhysicalMemorySize();
    }
}

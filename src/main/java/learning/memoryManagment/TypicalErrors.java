package learning.memoryManagment;

public class TypicalErrors {

    public static void main(String[] args) {
        throwOutOfMemoryHeapSpace();
        throwOutOfMemoryMetaspace();
        factorial(100000);
        executeSubTask4();
    }

    /**
     * 1.	java.lang.OutOfMemoryError: Java heap space. Create big objects continuously and make them stay in memory. Do not use arrays or collections.
     */
    private static void throwOutOfMemoryHeapSpace() {
        StringBuilder outOfMemory = new StringBuilder("out");
        while (true) {
            outOfMemory.append(outOfMemory);
        }
    }

    /**
     * 2.	java.lang.OutOfMemoryError: Metaspace. Load classes continuously and make them stay in memory.
     */
    private static void throwOutOfMemoryMetaspace() {
//		Add the argument to "VM options":
//		-XX:MaxMetaspaceSize=1m
    }

    /**
     * 3.	java.lang.StackOverflowError. Use recursive methods
     */
    private static int factorial(int factorial) {
        if (factorial == 1) {
            return 1;
        } else {
            return factorial * factorial(factorial - 1);
        }
    }

    /**
     * 4.	java.lang.StackOverflowError. Do not use recursive methods.
     */
    private static void executeSubTask4() {
        doExecuteSubTask4();
        //or analogously for classes:
        //Something something = new Something();
    }

    private static void doExecuteSubTask4() {
        executeSubTask4();
    }

}

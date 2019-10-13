package learning.java.core.finalizeAndClose;

import java.io.IOException;

/**
 * https://www.baeldung.com/java-finalize
 */
public class Finalizable extends WorkWithText {

    /**
     * Invoke before destruct object.
     * <p> Cons: <ul>
     * <li>- We don't know when it happens
     * <li>- We can run out all resources before GC
     * <li>- Performance. For JVM better destroy a non-empty finalizer
     * <li> If a finalizer throws an exception, finalization process is canceled, and the exception is ignored, leaving the object in a corrupted state without any notification.
     * <li> One critical point to notice is that finalize has been deprecated starting with Java 9 – and will eventually be removed.
     * </ul>
     * </p>
     */
    @Override
    public void finalize() {
        try {
            reader.close();
            System.out.println("Closed BufferedReader in the finalizer");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            // ...
        }
    }
}

package learning.java.core.finalizeAndClose;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinalizableTest {


    /**
     * In reality, the time at which the garbage collector calls finalizers is dependent on the JVM's
     * implementation and the system's conditions, which are out of our control.
     * @throws IOException
     */
    @Test
    public void whenGC_thenFinalizerExecuted() throws IOException {
        String firstLine = new Finalizable().readFirstLine();
        assertEquals("baeldung.com", firstLine);
        //To make garbage collection happen on the spot, we'll take advantage of the System.gc method.
        // In real-world systems, we should never invoke that explicitly, for a number of reasons:
        //
        //- It's costly
        //- It doesn't trigger the garbage collection immediately – it's just a hint for the JVM to start GC
        //- JVM knows better when GC needs to be called
        System.gc();
        //If we need to force GC, we can use jconsole for that.
    }
}
package learning.java.core.finalizeAndClose;

import java.io.IOException;

public class CloseableResource extends WorkWithText implements AutoCloseable {

    @Override
    public void close() {
        try {
            reader.close();
            System.out.println("Closed BufferedReader in the close method");
        } catch (IOException e) {
            // handle exception
        }
    }
}
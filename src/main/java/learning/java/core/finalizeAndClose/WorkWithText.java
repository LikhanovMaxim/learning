package learning.java.core.finalizeAndClose;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WorkWithText {
    protected BufferedReader reader;

    WorkWithText() {
        InputStream input = this.getClass()
                .getClassLoader()
                .getResourceAsStream("file.txt");
        reader = new BufferedReader(new InputStreamReader(input));
    }

    String readFirstLine() throws IOException {
        String firstLine = reader.readLine();
        return firstLine;
    }
}

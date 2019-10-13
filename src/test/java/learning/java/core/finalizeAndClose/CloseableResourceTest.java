package learning.java.core.finalizeAndClose;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CloseableResourceTest {

    @Test
    public void whenTryWResourcesExits_thenResourceClosed() throws IOException {
        try (CloseableResource resource = new CloseableResource()) {
            String firstLine = resource.readFirstLine();
            assertEquals("baeldung.com", firstLine);
        }
    }
}
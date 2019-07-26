package learning.java.core.keywords._final;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppStringsTest {

    @Test
    void name() {
        final List<String> strings = new ArrayList<>();
        assertEquals(0, strings.size());
        strings.add("baeldung");
        assertEquals(1, strings.size());
        //because adding an element to the list changes its size, therefore,
        // it isn’t an immutable object.
    }
}
package learning.java.core.multithreading.jmm;

import org.junit.jupiter.api.Test;

class HappensBeforeTest {


    @Test
    void shouldg() throws InterruptedException {
        HappensBefore happensBefore = new HappensBefore();
        happensBefore.example();
    }

    @Test
    void shouldBeDiffOutput() throws InterruptedException {
        HappensBefore happensBefore = new HappensBefore();
        for (int i = 0; i < 100; i++)
            happensBefore.example();
    }
}

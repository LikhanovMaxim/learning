package learning.java.core.multithreading.jmm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class HappensBeforeTest {


    @Test
    void shouldg() throws InterruptedException {
        HappensBefore happensBefore = new HappensBefore();
        happensBefore.example();
    }

    @Test
    void shouldBeDiffOutput() throws InterruptedException {
        HappensBefore happensBefore = new HappensBefore();
        for (int i = 0; i < 100; i++) {
            String example = happensBefore.example();
            System.out.println(example);
//            assertEquals("", example);
        }
    }
}

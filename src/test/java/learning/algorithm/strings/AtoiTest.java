package learning.algorithm.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AtoiTest {

    @Test
    void myAtoi2() {
        Atoi s = new Atoi();
        int result = s.myAtoi2("--asdaxv23dasf");
        assertEquals(23, result);
    }

    @Test
    void myAtoi22() {
        Atoi s = new Atoi();
        int result = s.myAtoi2("42");
        assertEquals(42, result);
    }

    @Test
    void myAtoi23() {
        Atoi s = new Atoi();
        int result = s.myAtoi2("-91283472332");
        assertEquals(-2147483648, result);
    }
}
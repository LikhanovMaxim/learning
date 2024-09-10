package learning.algorithm.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringExampleTest {

    @Test
    void myAtoi() {
        StringExample s = new StringExample();
        int result = s.myAtoi("--asdaxv23dasf");
        assertEquals(23, result);
    }

    @Test
    void myAtoi2() {
        StringExample s = new StringExample();
        int result = s.myAtoi("42");
        assertEquals(42, result);
    }

    @Test
    void myAtoi3() {
        StringExample s = new StringExample();
        int result = s.myAtoi("-91283472332");
        assertEquals(-2147483648, result);
    }
}
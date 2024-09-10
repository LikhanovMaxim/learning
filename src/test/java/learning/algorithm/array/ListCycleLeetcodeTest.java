package learning.algorithm.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListCycleLeetcodeTest {
    ListCycleLeetcode leetcode = new ListCycleLeetcode();

    @Test
    void cycle() {
        assertEquals(true, leetcode.hasCycle(leetcode.testData()));
    }

    @Test
    void cycleNo() {
        assertEquals(false, leetcode.hasCycle(leetcode.testData2()));
    }

}
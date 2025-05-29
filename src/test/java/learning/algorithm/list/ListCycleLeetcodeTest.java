package learning.algorithm.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListCycleLeetcodeTest {
    ListCycleLeetcode leetcode = new ListCycleLeetcode();

    @Test
    void cycle() {
        assertTrue(leetcode.hasCycle(leetcode.testData()));
    }

    @Test
    void cycleNo() {
        assertFalse(leetcode.hasCycle(leetcode.testData2()));
    }

}
package learning.algorithm.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReverseListLeetcodeTest {
    ReverseListLeetcode leetcode = new ReverseListLeetcode();

    @Test
    void cycle() {
        ReverseListLeetcode.ListNode listNode = leetcode.reverseList(leetcode.testData());
        assertEquals(5, listNode.val);
        assertNotNull(listNode.next);
    }

}
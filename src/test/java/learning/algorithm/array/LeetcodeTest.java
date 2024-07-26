package learning.algorithm.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetcodeTest {

    Leetcode leetcode = new Leetcode();

    @Test
    void removeDuplicates() {
        int[] nums = {1, 1, 2};
        int actual = leetcode.removeDuplicates2(nums);
        assertEquals(2, actual);
    }

    @Test
    void removeDuplicatesBig() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int actual = leetcode.removeDuplicates2(nums);
        assertEquals(5, actual);
    }

    //2
    @Test
    void maxProfit() {
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(4, leetcode.maxProfit(nums));
    }

    //
    @Test
    void can() {
        assertEquals(4, leetcode.canCompleteCircuit2(
                new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}
        ));
    }

    @Test
    void can2() {
        assertEquals(-1, leetcode.canCompleteCircuit2(
                new int[]{2, 3, 4}, new int[]{3, 4, 3}
        ));
    }
}
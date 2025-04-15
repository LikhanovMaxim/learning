package learning.algorithm.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GasStationLeetcodeTest {

    GasStationLeetcode leetcode = new GasStationLeetcode();
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
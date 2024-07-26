package learning.algorithm.array;

import learning.algorithm.dynamic.PartSum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartSumTest {

    PartSum partSum = new PartSum();

    //Output: 2 (т.е. [1,2] и [3])
    @Test
    void sum() {
        assertEquals(2, partSum.sumSubstring2(new int[]{1, 2, 3}, 3));
    }

    @Test
    void sumNothing() {
        assertEquals(0, partSum.sumSubstring2(new int[]{1, 2, 3}, 4));
    }

//    Output: 1 (т.е. [2,3])
    @Test
    void sumSubstring2() {
        assertEquals(1, partSum.sumSubstring2(new int[]{1, 2, 3}, 5));
    }

}
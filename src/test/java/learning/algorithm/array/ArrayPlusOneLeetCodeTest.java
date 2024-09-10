package learning.algorithm.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayPlusOneLeetCodeTest {

    @Test
    void plusOne() {
        ArrayPlusOneLeetCode arrayPlusOneLeetCode = new ArrayPlusOneLeetCode();
        int[] digits = {9};
        int[] expected = {1, 0};
        assertArrayEquals(expected, arrayPlusOneLeetCode.plusOne(digits));
    }

    @Test
    void plusOne2() {
        ArrayPlusOneLeetCode arrayPlusOneLeetCode = new ArrayPlusOneLeetCode();
        int[] digits = {1, 9};
        int[] expected = {2, 0};
        assertArrayEquals(expected, arrayPlusOneLeetCode.plusOne(digits));
    }

    @Test
    void plusOneSimple() {
        ArrayPlusOneLeetCode arrayPlusOneLeetCode = new ArrayPlusOneLeetCode();
        int[] digits = {1, 2, 3};
        int[] expected = {1, 2, 4};
        assertArrayEquals(expected, arrayPlusOneLeetCode.plusOne(digits));
    }
}
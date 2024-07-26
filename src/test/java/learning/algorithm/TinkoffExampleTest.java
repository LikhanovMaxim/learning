package learning.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TinkoffExampleTest {

    @Test
    public void shouldFindCommonWhenExist() {
        TinkoffExample example = new TinkoffExample();
        int[] p = {1, 2, 4, 5};
        int[] q = {3, 3, 4};
        int[] r = {2, 3, 4, 5, 6};
        int commonNumber = example.findCommonNumber(p, q, r);
        assertEquals(4, commonNumber);
    }

    @Test
    public void shouldFindNothing() {
        TinkoffExample example = new TinkoffExample();
        int[] p = {1};
        int[] q = {3};
        int[] r = {2};
        assertNull(example.findCommonNumber(p, q, r));
    }

    @Test
    public void shouldFindWhenOneElement() {
        TinkoffExample example = new TinkoffExample();
        int[] p = {1};
        int[] q = {1};
        int[] r = {1};
        assertEquals(1, example.findCommonNumber(p, q, r));
    }


    @Test
    public void shouldFindWhenTwoElement() {
        TinkoffExample example = new TinkoffExample();
        int[] p = {-2, 0, 0, 1};
        int[] q = {1};
        int[] r = {1};
        assertEquals(1, example.findCommonNumber(p, q, r));
    }
}

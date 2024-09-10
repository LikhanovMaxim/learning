package learning.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMedianTest {

    @Test
    public void first() {
        FindMedian findMedian = new FindMedian();
        int[] arr = {1, 2, 3};
        assertEquals(2, findMedian.find(arr));
    }

    @Test
    public void firstNotSorted() {
        FindMedian findMedian = new FindMedian();
        int[] arr = {3, 1, 2};
        assertEquals(2, findMedian.find(arr));
    }
}
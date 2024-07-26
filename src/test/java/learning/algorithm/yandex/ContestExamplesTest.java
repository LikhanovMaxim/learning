package learning.algorithm.yandex;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContestExamplesTest {
    @Test
    public void findMax() {
        boolean[] arr = new boolean[3];
        arr[1] = true;
        assertEquals(1, ContestExamples.findMaxSequenceTrue(arr));
    }

    @Test
    public void findMaxInTheEnd() {
        boolean[] arr = new boolean[5];
        arr[0] = true;
        arr[3] = true;
        arr[4] = true;
        assertEquals(2, ContestExamples.findMaxSequenceTrue(arr));
    }

    @Test
    public void removeDuplicates() {
        int[] arr = new int[3];
        arr[0] = 2;
        arr[1] = 2;
        arr[2] = 3;
        assertEquals(List.of(2, 3), ContestExamples.removeDuplicates(arr));
    }

    @Test
    public void removeDuplicatesWhenInTheEnd() {
        int[] arr = new int[5];
        arr[0] = 2;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 3;
        arr[4] = 3;
        assertEquals(List.of(2, 3), ContestExamples.removeDuplicates(arr));
    }

    @Test
    public void removeDuplicatesWithoutMemory() {
        List<Integer> arr = new LinkedList<>(List.of(2, 2, 3));
        assertEquals(List.of(2, 3), ContestExamples.removeDuplicates2(arr));
    }

    @Test
    public void removeDuplicatesEndWithoutMemory() {
        List<Integer> arr = new LinkedList<>(List.of(2, 2, 3, 3, 3));
        assertEquals(List.of(2, 3), ContestExamples.removeDuplicates2(arr));
    }
}

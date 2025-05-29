package learning.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Exercise1 {
    // Sorted in ascending order
    private final List<Integer> data = new ArrayList<>();

    /**
     * Example:
     * data = [1,4,7,10]
     * add(6) => [1,4,6,7,10]
     * add(4) => [1,4,4,6,7,10]
     * <p>
     * edge cases: 11 []
     *
     * O(N)
     *
     * O(logN)
     *  i = size/2
     *  if x > a[i]
     *      i = size/2
     *      j = size
     *  else
     *
     *
     */
    public void add(int x) {
        // todo: add x to data so that data remained sorted
        for (int i = 0; i < data.size(); i++) {
            if (x < data.get(i)) {
                data.add(i, x);
                break;
            }
        }
    }
}


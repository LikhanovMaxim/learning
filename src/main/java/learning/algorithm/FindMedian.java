package learning.algorithm;

import java.util.Arrays;

public class FindMedian {


    /**
     * Set {3, 1, 2}
     * LinkedList - {1, 2, 3,}
     * 1 , 2, 3
     * <p>
     * LinkedList var 1
     * LinkedList var 3
     * remove
     * l
     * <p>
     * local Max = 3
     * local Min = 1
     * start for three
     * median = 2
     * <p>
     * 1, 2, 3, 4, 5
     * 4, 3, 1, 5, 2
     * Stack {}
     * <p>
     * <p>
     * <p>
     * findMin. for I for Max
     * findMax.
     *
     * @param arr
     * @return
     */
    public double find(int[] arr) {
        //first sort & find
        Arrays.sort(arr);
        int length = arr.length;
        if (length % 2 == 1) {
            return arr[length / 2];
        } else {
            return 0.5 * (arr[length / 2 - 1] + arr[length / 2]);
        }
    }


}

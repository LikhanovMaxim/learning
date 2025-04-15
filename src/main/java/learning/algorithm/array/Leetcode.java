package learning.algorithm.array;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode {
    /**
     * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        Set<Integer> unique = new LinkedHashSet<>();
        for (int num : nums) {
            unique.add(num);
        }
        int i = 0;
        for (Integer e : unique) {
            nums[i] = e;
            i++;
        }
        return unique.size();
    }

    /**
     * by index
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (j == 0 || nums[i] > nums[j - 1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/
    //[1,2,3] => 2
    //[1,2,3,4,5] => 4
    // 4 1 3 1 => 2
    // 7,1,5,3,6,4 = > 4 + 3 = 7
    // 7,6,4,3,1 => 0
    //[]
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < min) {
                min = price;
            }
            if (price - min > 0) {
                profit += price - min;
                min = price;
            }
        }
        return profit;
    }

}

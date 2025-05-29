package learning.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/
 */
public class LeetcodeContainsDuplicate {

    /**
     * Input: nums = [1,2,3,1]
     * Output: true
     * <p>
     * Input: nums = [1,2,3,4]
     * Output: false
     * <p>
     * edge cases:
     * - [1] false
     * - 10_000
     * 1 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * fori
     * if exist in Set
     * return true
     * add to Set<Int>
     * time O(N)
     * space O(N)
     * <p>
     * if we want to not use Space:
     * - sort Array
     * - fori
     * if prev = cur
     * return true
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

}

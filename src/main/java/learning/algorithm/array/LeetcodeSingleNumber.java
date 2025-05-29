package learning.algorithm.array;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/
 */
public class LeetcodeSingleNumber {
    /**
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     * ideas:
     * sort - no. N log N
     * brutforce -no N*N
     * Set - no.
     * sum 5
     * multiply 4
     * bit operation & ^
     * Example 1:
     * Input: nums = [2,2,1]
     * Output: 1
     * <p>
     * Example 2:
     * sum = 10
     * lastNum 4,1,2
     * Input: nums = [4,1,2,1,2]
     * Output: 4
     * <p>
     * Example 3:
     * Input: nums = [1]
     * Output: 1
     * <p>
     * v =
     * [1, 2, 1, 2, 4] -> 4
     * [-1, -2, 7, -1, -2] 7
     * <p>
     * Constraints:
     * 1 <= nums.length <= 3 * 104
     * -3 * 104 <= nums[i] <= 3 * 104
     * Each element in the array appears twice except for one element which appears only once.
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

}

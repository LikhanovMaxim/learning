package learning.algorithm.array;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
 */
public class LeetcodeMoveZeroes {
    /**
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * Note that you must do this in-place without making a copy of the array.
     * Example 1:
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * <p>
     * Example 2:
     * Input: nums = [0]
     * Output: [0]
     * <p>
     * [1,2,3] -> [1,2,3]
     * [0,1,2,3] -> [1,2,3,0]
     * [1,0,0,0,2,0] -> [1,2,0,0]
     * ideas:
     * - create new array and skip 0 fori. space O(N). time O(N)
     * - bubble 0 swap to right. O(N) space 0(1)
     * <p>
     */
    /*
     firstZero=0
     correctIndex=0
     [1,3,12,0,0]
     [0,1,2,3] -> [1,2,3,0]
     fistZero=1
     correctIndex=1
     [1,0,0,0,2,0]
     [0,0,0,0]
     fori =
        if indexZero=-1
        return
     fori i=correctIndex
        if a[i] != 0
             swap a[i] and a[correctIndex]
            correctIndex++
        else
            nothing
     */
    public void moveZeroes(int[] nums) {
        int firstZero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                firstZero = i;
                break;
            }
        }
        if (firstZero == -1)
            return;

        int correctIndex = firstZero;
        for (int i = correctIndex + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[correctIndex] = nums[i];
                nums[i] = 0;
                correctIndex++;
            }
        }
    }

}

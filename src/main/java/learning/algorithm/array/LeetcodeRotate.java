package learning.algorithm.array;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
 *
  */
public class LeetcodeRotate {
    /**
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output:       [5,6,7,1,2,3,4]
     * <p>
     * length = 7
     * for i
     * res[i] = nums[(i+k)%length]
     * space O(N)
     * time O(N)
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[(nums.length + i - k) % nums.length];
        }
        System.arraycopy(res, 0, nums, 0, nums.length);
    }

    /**
     * int c;
     * for i = 0; i < length; i++
     * swap nums[i] with nums[(nums.length + i - k) % nums.length];
     * space O(1)
     * time O(N)
     * <p>
     * <p>
     * fori until k
     * forj until length
     * swap nums[i] with nums[(i+1)%length]
     * time O(k*N)
     * space O(1)
     * <p>
     * Input: nums = [-1,-100,3,99], k = 2
     * Output: [3,99,-1,-100]
     * Explanation:
     * rotate 1 steps to the right: [99,-1,-100,3]
     * rotate 2 steps to the right: [3,99,-1,-100]
     * <p>
     * prev 99 -1 -100 3
     * cur  -1 -100
     * arr  99 -1 -100 3
     * time O(K * N)
     */
    public void rotate2(int[] nums, int k) {
        // tests failed. time O(K * N) too much
        int length = nums.length;
        k = k % length;
        if (k == 0) return;
        for (int j = 0; j < k; j++) {
            int previuos = nums[length - 1];
            for (int i = 0; i < length; i++) {
                int cur = nums[i];
                nums[i] = previuos;
                previuos = cur;
            }
        }
    }

    /**
     * todo use hints and solve this by using O(1) space
     * 1) variable ?
     * previous 3   -1,
     * cur      -1
     *         [3,-100,3,99]
     *
     * Input: nums = [-1,-100,3,99], k = 2
     * Output:       [3,99,-1,-100]
     *
     *
     * 2) swapping?
     * prev 5 1
     * cur  1
     * arr  [5,2,3,4,5,6,7]
     *      [5,6,7,4,1,2,3]
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output:       [5,6,7,1,2,3,4]
     *          [5,6,7,4,1,2,3]
     *          [4,5,6,1,2,3,7]
     * 3) reverse array
     * swap? []
     *
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * rev     [7,6,5,4,3,2,1]
     * rev     [7,6,5,1,2,3,4]
     * arr     [7,6,5,1,1,2,3]
     *
     * Input: nums = [1,2,3,4,5,6,7], k = 2
     * Output: [6,7,1,2,3,4,5]
     * rev     [7,6,5,4,3,2,1]
     *
     * Input: nums = [-1,-100,3,99], k = 2
     * Output: [3,99,-1,-100]
     * reverse [99,3,-100,-1]
     *
     * Input [1,2,3] k=1
     * Output[3,2,1]
     * rev [3,2,1]
     *
     * [1,2,3,4] k=1
     * [4,1,2,3]
     * rev [4,3,2,1]
     *
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        if (k == 0) return;
        int[] res = new int[length];
        int previuos = nums[length - k];
        for (int i = 0; i < length; i++) {
            res[i] = nums[(length + i - k) % length];
        }
    }
//        for (int i = 0; i < nums.length; i++) {
//            int c = nums[i];
//            int swapIndex = (nums.length + i - k) % nums.length;
//            nums[i] = nums[swapIndex];
//            nums[swapIndex] = c;
//        }

}

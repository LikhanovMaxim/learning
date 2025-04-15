package learning.algorithm.array;

//https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/559/
public class ArrayPlusOneLeetCode {
    /**
     * @param digits
     * @return
     * time: O(n)
     * space: O(N). in bad case(2*O(N))
     * todo use digits instead of creating res?
     */
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length];
        boolean incement = true;
        for (int i = res.length - 1; i >= 0; i--) {
            if (incement) {
                res[i] = (digits[i] + 1) % 10;
                if (res[i] != 0) {
                    incement = false;
                }
            } else res[i] = digits[i];
        }
        if (res[0] == 0) {
            int[] result = new int[res.length + 1];
            result[0] = 1;
            return result;
        } else return res;
    }
}

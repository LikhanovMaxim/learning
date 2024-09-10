package learning.algorithm.array;

//https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/559/
public class ArrayPlusOneLeetCode {
    /**
     * @param digits
     * @return
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
            int[] ints = new int[res.length + 1];
            ints[0] = 1;
            System.arraycopy(res, 0, ints, 1, res.length);
            return ints;
        } else return res;
    }
}

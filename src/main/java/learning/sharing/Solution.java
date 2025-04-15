package learning.sharing;

import java.math.BigInteger;

public class Solution {

    /**
     * task 1
     *
     * @param A
     * @param B
     * @return find count of 1 in binary string of A * B.
     */
    public int solution(int A, int B) {
        // write your code in Java SE 8
        BigInteger multiply = multiplyBigInt(A, B);
        String bits = multiply.toString(2);
        int countBits = 0;
        for (int i = 0; i < bits.length(); i++) {
            if (bits.charAt(i) == '1') {
                countBits++;
            }
        }
        return countBits;
    }

    private BigInteger multiplyBigInt(int A, int B) {
        BigInteger a = new BigInteger(String.valueOf(A));
        BigInteger b = new BigInteger(String.valueOf(B));
        return a.multiply(b);
    }


    /**
     * task 2
     * create max palindrome with string of digits "90988" -> "98089"
     */
    public String solution(String S) {
        int[] countDigits = calculateCountDigits(S);
        boolean isZeroExist = countDigits[0] > 0;
        StringBuilder partPalindrome = findPartPalindrome(countDigits);
        String maxSingle = "";
        if (partPalindrome.toString().equals("") && isZeroExist) {
            maxSingle = "0";
        }
        maxSingle = maxDigit(countDigits, maxSingle);
        String firstPart = partPalindrome.toString();
        return firstPart + maxSingle + partPalindrome.reverse();
    }

    private StringBuilder findPartPalindrome(int[] countDigits) {
        StringBuilder partPalindrome = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (countDigits[i] > 1) {//todo it can be divide?
                countDigits[i] -= 2;
                if (i != 0 || !partPalindrome.toString().equals("")) {
                    partPalindrome.append(i);
                }
            }
        }
        return partPalindrome;
    }

    private String maxDigit(int[] countDigits, String maxSingle) {
        for (int i = 9; i >= 0; i--) {
            if (countDigits[i] > 0) {
                maxSingle = String.valueOf(i);
                break;
            }
        }
        return maxSingle;
    }

    private int[] calculateCountDigits(String S) {
        int[] countDigits = new int[10];
        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - '0';
            countDigits[index]++;
        }
        return countDigits;
    }


}

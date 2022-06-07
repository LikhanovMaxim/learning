package learning.codility;

/**
 * https://app.codility.com/programmers/trainings/5/parity_degree/
 */
class SolutionPositiveDigree {

    /**
     * <p>
     * A positive integer N is given. The goal is to find the highest power of 2 that divides N. In other words, we have to find the maximum K for which N modulo 2^K is 0.
     * <p>
     * For example, given integer N = 24 the answer is 3, because 2^3 = 8 is the highest power of 2 that divides N.
     * <p>
     * Write a function:
     * <p>
     * class Solution { public int solution(int N); }
     * <p>
     * that, given a positive integer N, returns the highest power of 2 that divides N.
     * <p>
     * For example, given integer N = 24, the function should return 3, as explained above.
     * <p>
     * Assume that:
     * <p>
     * N is an integer within the range [1..1,000,000,000].
     * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
     * <p>
     * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
     */
    public int solution(int N) {
        int res = 0;
        for (int a = N; a > 1; ) {
            if (a % 2 == 0) {
                a /= 2;
                res++;
            } else {
                break;
            }
        }
        Tree tree ;
        return res;
    }
}

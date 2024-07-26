package learning.algorithm.array;

/**
 * https://app.codility.com/programmers/trainings/4/array_inversion_count/
 */
public class SolutionCodility {


    //todo need to change to A[P]>A[Q]
    public int solution(int[] A) {
        // write your code in Java SE 8
//        Arrays.sort(A);
        int[] top = new int[A.length];
        int max = -Integer.MAX_VALUE;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] > max) max = A[i];
            top[i] = max;
        }
        //

        int best = 0;
        for (int i = 0; i < A.length; i++) {
            int c = find(top, A[i]) - i;
            if (c > best) best = c;
//            if (best >= A.length - i) return best;
        }

        return best;
//        return 0;
    }


    int find(int[] top, int min) {
        int e = top.length - 1;
        if (top[e] >= min) return e;

        int s = 0;
        while (true) {
            int x = (s + e) / 2;
            if (x == top.length - 1) return top.length - 1;
            if (top[x] >= min && top[x + 1] < min) return x;

            if (top[x] < min) e = x;
            else s = x;
        }
    }

    public int solutionBadPerf(int[] A) {
        // write your code in Java SE 8
        int sumInverse = 0;
        for (int p = 0; p < A.length - 1; p++) {
            for (int q = p + 1; q < A.length; q++) {
                if (A[q] < A[p]) {
//                    System.out.println("(" + p + ", " + q + ")");
                    sumInverse++;
                }
            }
        }
        System.out.println(Integer.MAX_VALUE);
        return sumInverse;
    }


}

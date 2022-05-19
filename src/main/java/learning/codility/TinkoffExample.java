package learning.codility;

/**
 * https://github.com/Tinkoff/career/blob/main/interview/sections/programming.md
 */
public class TinkoffExample {

    /**
     * @param p
     * @param q
     * @param r
     * @return example:
     * int[] p = {1, 2, 4, 5};
     * int[] q = {3, 3, 4};
     * int[] r = {2, 3, 4, 5, 6};
     * i, j, k;
     * tryCommon = 1
     */
    public Integer findCommonNumber(int[] p, int[] q, int[] r) {
        Integer commonNumber = null;
        for (int i = 0, j = 0, k = 0; i < p.length && j < q.length && k < r.length; ) {
            int first = p[i];
            int second = q[j];
            int third = r[k];
            if (first == second && second == third) {
                commonNumber = first;
                break;
            }
            if (first < second || first < third) {
                i++;
            }
            if (second < first || second < third) {
                j++;
            }
            if (third < first || third < second) {
                k++;
            }
        }
        return commonNumber;
    }
}

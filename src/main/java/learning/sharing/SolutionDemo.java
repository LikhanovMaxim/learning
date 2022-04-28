package learning.sharing;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionDemo {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> collect = IntStream.of(A).filter((x) -> x > 0).boxed().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        int res = 1;
        for (Integer d : collect) {
            if (d == res) {
                res = res + 1;
            } else {
                break;
            }
        }
        return res;
    }

    public int solution(int N) {
        // write your code in Java SE 8
        String s = Integer.toBinaryString(N);
        int max = 0;
        int current = 0;
        System.out.println(s);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                current++;
            } else {
                if (current > max) {
                    max = current;
                }
                current = 0;
            }
        }
        return max;
    }


}

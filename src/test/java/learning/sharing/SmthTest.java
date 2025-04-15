package learning.sharing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SmthTest {

    @Test
    public void test2() {
        SolutionDemo smth = new SolutionDemo();
        int[] ints = {1, 3};
        int solution = smth.solution(ints);
        System.out.println(solution);
    }


    @Test
    public void test3() {
        Solution solution = new Solution();
        int a = 100_000_000;
        int solution1 = solution.solution(a, a);
        System.out.println(solution1);
    }

    @Test
    public void test5() {
        Solution solution = new Solution();
        String solution1 = solution.solution("39878");
        System.out.println(solution1);
        assertEquals("898", solution1);
    }


    @Test
    public void test6() {
        Solution solution = new Solution();
        String solution1 = solution.solution("00900");
        System.out.println(solution1);
        assertEquals("9", solution1);
    }

    @Test
    public void test7() {
        Solution solution = new Solution();
        String solution1 = solution.solution("0000");
        System.out.println(solution1);
        assertEquals("0", solution1);
    }

    @Test
    public void test8() {
        Solution solution = new Solution();
        String solution1 = solution.solution("110000");
        System.out.println(solution1);
        assertEquals("100001", solution1);
    }

}

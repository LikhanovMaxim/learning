package learning.codility.algorithmic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    public void shouldBe4WhenInversePerf() {
        int solution = new Solution().solution(new int[]{-1, 6, 3, 4, 7, 4});
        assertEquals(4, solution);
    }

    @Test
    public void shouldBe1WhenInverse() {
        int solution = new Solution().solutionBadPerf(new int[]{2, 1});
        assertEquals(1, solution);
    }

    @Test
    public void shouldBe4WhenInverse() {
        int solution = new Solution().solutionBadPerf(new int[]{-1, 6, 3, 4, 7, 4});
        assertEquals(4, solution);
    }
}

package learning.algorithm.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionCodilityTest {

    @Test
    public void shouldBe4WhenInversePerf() {
        int solution = new SolutionCodility().solution(new int[]{-1, 6, 3, 4, 7, 4});
        assertEquals(4, solution);
    }

    @Test
    public void shouldBe1WhenInverse() {
        int solution = new SolutionCodility().solutionBadPerf(new int[]{2, 1});
        assertEquals(1, solution);
    }

    @Test
    public void shouldBe4WhenInverse() {
        int solution = new SolutionCodility().solutionBadPerf(new int[]{-1, 6, 3, 4, 7, 4});
        assertEquals(4, solution);
    }
}

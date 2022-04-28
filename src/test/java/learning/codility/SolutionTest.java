package learning.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void shouldBe1WhenHasBinaryTreeWith2leafs() {
        Tree root = new Tree(1, new Tree(2, null, null), new Tree(3, null, null));
        Solution solution = new Solution();
        int highTree = solution.solution(root);
        assertEquals(1, highTree);
    }
}

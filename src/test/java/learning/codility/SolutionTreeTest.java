package learning.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTreeTest {

    @Test
    public void shouldBe1WhenHasBinaryTreeWith2leafs() {
        Tree root = new Tree(1, new Tree(2, null, null), new Tree(3, null, null));
        SolutionTree solution = new SolutionTree();
        int highTree = solution.solution(root);
        assertEquals(1, highTree);
    }
    @Test
    public void shouldBe2WhenHasBinaryTree2DeepInLeft() {
        Tree root = new Tree(1, new Tree(2, new Tree(5, null, null), null), new Tree(3, null, null));
        SolutionTree solution = new SolutionTree();
        int highTree = solution.solution(root);
        assertEquals(2, highTree);
    }
}

package learning.algorithm.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxDepthLeetcodeTest {
    MaxDepthLeetcode max = new MaxDepthLeetcode();

    @Test
    public void shouldBe1WhenHasBinaryTreeWith2leafs() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(3, null, null));
        assertEquals(2, max.maxDepth(root));
    }

    @Test
    public void shoulbe3() {
        TreeNode root =
                new TreeNode(3,
                        new TreeNode(9),
                        new TreeNode(20,
                                new TreeNode(15), new TreeNode(7)));
        assertEquals(3, max.maxDepth(root));
    }
}
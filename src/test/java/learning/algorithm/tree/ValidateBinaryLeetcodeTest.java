package learning.algorithm.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateBinaryLeetcodeTest {
    ValidateBinaryLeetcode max = new ValidateBinaryLeetcode();

    @Test
    public void shouldBeTrue() {
        TreeNode root = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3));
        assertEquals(true, max.isValidBST(root));
    }

    @Test
    public void shouldBeFalse() {
        TreeNode root = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4,
                        new TreeNode(3),
                        new TreeNode(6)));
        assertEquals(false, max.isValidBST(root));
    }

}
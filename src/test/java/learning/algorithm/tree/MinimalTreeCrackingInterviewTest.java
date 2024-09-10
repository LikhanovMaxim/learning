package learning.algorithm.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class MinimalTreeCrackingInterviewTest {
    MinimalTreeCrackingInterview max = new MinimalTreeCrackingInterview();

    @Test
    public void shouldBe1() {
        TreeNode root = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3));
        TreeNode binarySearchTree = max.sortedArrayToBST(new int[]{1, 2, 3});
        System.out.println(binarySearchTree);
        assertEquals(2, binarySearchTree.val);
        assertEquals(1, binarySearchTree.left.val);
        assertEquals(3, binarySearchTree.right.val);
    }

    @Test
    public void shouldBe() {
        TreeNode binarySearchTree = max.sortedArrayToBST(new int[]{1, 3});
        System.out.println(binarySearchTree);

        assertEquals(1, binarySearchTree.val);
        assertNotNull(binarySearchTree.right);
        assertEquals(3, binarySearchTree.right.val);
        assertNull(binarySearchTree.left);

    }

}
package learning.algorithm.tree;

/**
 * Minimal Tree: Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height.
 * <p>
 * and also leetcode https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/631/
 */
public class MinimalTreeCrackingInterview {

    public TreeNode sortedArrayToBST(int[] nums) {
        return create(nums, 0, nums.length - 1);
    }

    private TreeNode create(int[] list, int left, int right) {
        int middle = (left + right) / 2;
        TreeNode root = new TreeNode(list[middle]);
        if (left <= middle - 1) {
            root.left = create(list, left, middle - 1);
        }
        if (middle + 1 <= right) {
            root.right = create(list, middle + 1, right);
        }
        return root;
    }
}

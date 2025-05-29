package learning.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/

public class MaxDepthLeetcode {


    //recursive
//    time O(N)
//    space. стек вызовов надо хранить. В худшем O(N),
//    для обычного дерева O(h - высота дерева)
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);

        if (lDepth > rDepth) {
            return lDepth + 1;
        } else {
            return rDepth + 1;
        }
    }

    /**
     * recursive.
     * idea: count i++ by step in tree;
     * return Math.max()
     * time O(N)
     * space stack O(N)
     */
    public int maxDepth3(TreeNode root) {
        if (root != null) {
            return deep(1, root);
        }
        return 0;
    }

    public int deep(int count, TreeNode root) {
        if (root.left == null && root.right == null) {
            return count;
        }
        int left = 0, right = 0;
        if (root.left != null) {
            left = deep(count + 1, root.left);
        }
        if (root.right != null) {
            right = deep(count + 1, root.right);
        }
        return Math.max(left, right);
    }

    // Map<Node, Integer=Deep>
    // with hashMap
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        recursive(root, map);
        return map.values().stream()
                .max(Integer::compare)
                .orElse(0);
    }

    private void recursive(TreeNode root, Map<TreeNode, Integer> map) {
//        System.out.println(root.val);
        if (root.left != null) {
            map.put(root.left, map.get(root) + 1);
            recursive(root.left, map);
        }
        if (root.right != null) {
            map.put(root.right, map.get(root) + 1);
            recursive(root.right, map);
        }
    }


}

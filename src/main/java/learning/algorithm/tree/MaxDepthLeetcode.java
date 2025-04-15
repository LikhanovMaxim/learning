package learning.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

public class MaxDepthLeetcode {


    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);

        if (lDepth> rDepth){
            return lDepth +1;
        } else {
            return rDepth +1;
        }
    }



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

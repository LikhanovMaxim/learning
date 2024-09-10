package learning.algorithm.tree;


import java.util.ArrayList;
import java.util.List;

public class ValidateBinaryLeetcode {

    //    https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/
    //with memory
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        inDepth(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inDepth(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            inDepth(root.left, list);
        }
//        System.out.println(root.val);
        list.add(root.val);
        if (root.right != null) {
            inDepth(root.right, list);
        }
    }

    //try without memory
    // todo ??????
    //
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
//        int left = inDepthFlag(root.left);
//        int right = inDepthFlag(root.right);
        return true;
    }
    private boolean inDepthFlag(TreeNode root) {
        boolean left = true, right = true;
        if (root.left != null) {
//            max = inDepthFlag(root.left);
        }
        boolean flag = true;
        if (root.left != null && root.left.val >= root.val) {
            flag = false;
        }
        if (root.right != null && root.right.val <= root.val) {
            flag = false;
        }
        System.out.println(root.val);
        if (root.right != null) {
            right = inDepthFlag(root.right);
        }
        return left && right && flag;
    }


    //smth old
    public boolean isValidBST22(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isLeft = isValidBST22(root.left);
        boolean isRight = isValidBST22(root.right);

        boolean flag = true;
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            flag = false;
        }
        return isLeft && isRight && flag;
    }

}


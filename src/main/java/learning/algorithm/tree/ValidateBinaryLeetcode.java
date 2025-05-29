package learning.algorithm.tree;


import java.util.ArrayList;
import java.util.List;
//    https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/

public class ValidateBinaryLeetcode {


    /*
    idea: передавать лефт и правую границу
          5 (MIN, MAX)
       1(MIN, 5)      6 (5, MAX)
         3 (1, 5)   3(5, 6)  7 (5, MAX)


                               50(MIN, MAX)
       10(MIN, 50)                         60(50, MAX)
     0(MIN, 10)    30(10, 50)         30(50, 60)  70 (50, MAX)
        11(0,10)   20(10,30)

        time O(N)
        space stack O(N)
     */
    public boolean isValidBST2(TreeNode root) {
        return isValidBSTRecursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTRecursive(TreeNode root, long min, long max) {
        if (!(root.val > min && root.val < max)) {
            return false;
        }
        boolean right = true, left = true;
        if (root.right != null) {
            right = isValidBSTRecursive(root.right, root.val, max);
        }
        if (root.left != null) {
            left = isValidBSTRecursive(root.left, min, root.val);
        }
        return right && left;
    }


    /*
    with memory and recursive
    idea: DFS and add element to List.
    check that List is sorted.
    time O(N + N)
    space O(N) + stack
     */
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
        System.out.println(root.val);
        if (root.left != null) {
            inDepth(root.left, list);
        }
//        System.out.println(root.val);
        list.add(root.val);
        if (root.right != null) {
            inDepth(root.right, list);
        }
//        System.out.println(root.val);
    }

}


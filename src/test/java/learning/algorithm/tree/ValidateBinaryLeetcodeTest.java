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

    /*
            5
         1      4
               3  6
     */
    @Test
    public void shouldBeFalse() {
        TreeNode root =
                new TreeNode(5,
                        new TreeNode(1),
                        new TreeNode(4,
                                new TreeNode(3),
                                new TreeNode(6)));
        assertEquals(false, max.isValidBST(root));
    }

    /*
                   1
        2                  9
    3     4         // 10         11
  5  6  7  8        //12 13     14  15


     */
    @Test
    public void justLookDiffAtSout() {
        TreeNode root =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3,
                                        new TreeNode(5) ,
                                        new TreeNode(6)),
                                new TreeNode(4,
                                        new TreeNode(7),
                                        new TreeNode(8)
                                )),
                        new TreeNode(9)
                        );
        max.isValidBST(root);
    }

}
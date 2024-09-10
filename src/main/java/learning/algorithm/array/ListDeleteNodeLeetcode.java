package learning.algorithm.array;

public class ListDeleteNodeLeetcode {

    /**
     * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/
     * Input: head = [4,5,1,9], node = 5
     * Output: [4,1,9]
     * <p>
     * 4, 1, 1, 9
     *
     * Input: head = [4,5,1,9], node = 1
     * Output: [4,5,9]
     *
     * Easy solution:
     * @param node
     */
    public void deleteNode2(ListNode node) {
        ListNode preLast = node;
        while (node.next != null) {
            ListNode next = node.next;
            node.val = next.val;
            preLast = node;
            node = next;
        }
        preLast.next = null;
    }


    //Better solution:
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}

/**
 * Definition for singly-linked list.
 * <p>
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
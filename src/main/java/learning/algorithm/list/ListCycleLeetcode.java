package learning.algorithm.list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/773/
 */
public class ListCycleLeetcode {

    //1 -> 2 -->1
    //with memory. space O(N)
    //time O(N)
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null && head.next != null) {
            nodes.add(head);
            if (nodes.contains(head.next)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * time O(N)
     * space O(1)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        while (head != null && head.next != null) {
            head.val = Integer.MAX_VALUE;
            if (head.next.val == Integer.MAX_VALUE) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode testData() {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;
        return a;
    }

    public ListNode testData2() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        return a;
    }

    class ExampleForSet{
        String a;
        List<Integer> b;
        ExampleForSet c;
    }
}


/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
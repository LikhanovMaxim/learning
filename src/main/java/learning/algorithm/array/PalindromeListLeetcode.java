package learning.algorithm.array;

import java.util.LinkedList;
import java.util.List;

public class PalindromeListLeetcode {

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/
    // List 1 2 3 2 1
    public boolean isPalindrome1(ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0, j = list.size() - 1; i < list.size() / 2; i++, j--) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
        }
        return true;
    }

    // List 1 -> 2 -> 2 -> 1
    // List 1 <- 2 <- 2 <- 1
    //
    // - find the center.
    // - reverse from center to end change direction.
    // - from end and start equals
    // first  1 1
    // second 2 2
    //without memory
    public boolean isPalindrome(ListNode head) {
        //todo
        ListNode headTrue = head;
        ListNode faster = head.next;
        while (head != null && head.next != null && faster.next != null) {
            head = head.next;
            //todo check
            faster = faster.next.next;
        }
        ListNode a = head.next;
        head.next = null;
        head = a;
//        while (head.next!=null){
//            head.next =
//        }

        return true;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

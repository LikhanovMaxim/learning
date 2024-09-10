package learning.algorithm.array;

public class ReverseListLeetcode {

    // https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/
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

    // 1 -> 2
    // 1 <- 2
    // 1 -> 2 -> 3
    // 1 -> 2 -> 3 -> 4 -> 5
    // 1 <-> 2 - 3 -> 4 -> 5
//     head next afterNext
    public ListNode reverseList1(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode nextAfter = next.next;
        next.next = head;
        if (next.next.equals(head)) {
            head.next = null;
        }
        if (nextAfter != null) {
            return reverseList(nextAfter);
        } else {
            return next;
        }
    }

    // 1 -> 2
    // 1 <- 2
    // 1 -> 2 -> 3
    // 1 -> 2 -> 3 -> 4 -> 5
    // 1 <-> 2 - 3 -> 4 -> 5
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode nextAfter = next.next;
        return reverseListRec(head, next, nextAfter);
    }

    private ListNode reverseListRec(ListNode prev, ListNode next, ListNode nextAfter) {
        next.next = prev;
        if (nextAfter == null) {
            return next;
        }
        ListNode newNext = nextAfter.next;
        nextAfter.next = next;
        return reverseListRec(next, nextAfter, newNext);
    }

    public ListNode testData() {
        ListNode e = new ListNode(5);
        ListNode d = new ListNode(4, e);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        return a;
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
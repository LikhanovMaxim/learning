package learning.algorithm.list;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/
public class ReverseListLeetcode {

    /**
     * Without recursive
     * Input: head = [1,2,3,4,5]
     * Output: [5,4,3,2,1]
     * <p>
     * Input: head = [1->null,2]
     * Output: [2,1]
     * [1,2,3] -> [3,2,1]
     * head
     * next
     * prev=null
     * while (head.next!=null)
     * next=head.next;
     * head.next=null/prev
     * prev=head;
     * head=next;
     *
     * [1,2,3]
     * [3,2,1]
     *
     * [1,2]
     * head 1, 2
     * prev null, 1
     * next 2
     * [1->null,
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode nextNode;
        while (head != null) {
            nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }

    //рекурсивно
    public ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return reverseListRec2(null, head);
    }

    public ListNode reverseListRec2(ListNode prev, ListNode head) {
        if (head == null) {
            return prev;
        }
        ListNode next = head.next;
        head.next = prev;
        return reverseListRec2(head, next);
    }

    //на каждом этапе переворачиваем связь. Рекурсивно.
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


    // 1 -> 2
    // 1 <- 2
    // 1 -> 2 -> 3
    // 1 -> 2 -> 3 -> 4 -> 5
    // 1 <-> 2 - 3 -> 4 -> 5
//     head next afterNext
    // recursive is wrong.
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
            return reverseList1(nextAfter);
        } else {
            return next;
        }
    }
}

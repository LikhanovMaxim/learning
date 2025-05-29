package learning.algorithm.list;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/
public class PalindromeListLeetcode {

/*
first pointer go
second double speed

from head and middle(first) go and check equality
todo make this
 */
    public boolean isPalindrome2(ListNode head) {
        return true;
    }

    /*
      Ideas:
      first pointer reverse
      second pointer double speed.
      in the middle go to both directions and compare equality
      <p>
      list: [1->null,2->1,2,1]
      prev: null,1
      head: 1,2
      second: 2, null
      prev = null
      while(second pointer!null)
          next = head.next
          head = prev
          prev = head
          head = next
          second = next.next; //checking null
      prev, head,
      while(head.next!=null)
          if(head.val != prev.val){
            return false
          }
      return true
      <p>
        Input: head = [1,2,2,1]
        Output: true
        Input: head = [1,2]
        Output: false
        edge cases: [1,2,1] true
        [1] true
        [1,2,3] false

        time O(N)
     * space O(1)
        // list [1->null,2,1]
        // doubleSpeed 1-1,1-3,
        // prev   null 1
        // head   1,   2    1
        //list [1->null,2->1,2,1]
        // double 1-1  2-3  null
        // prev   null 1    2
        // head   1,   2    2-3
     */
    public boolean isPalindrome(ListNode head) {
        ListNode doubleSpeed = head;
        ListNode prev = null;
        ListNode nextNode;
        while (doubleSpeed != null && head.next != null) {
            if (doubleSpeed.next != null) {
                doubleSpeed = doubleSpeed.next.next;
            } else {
                head = head.next;
                break;
            }
            nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        if (prev == null) {
            return true;
        }
        while (head != null) {
            if (head.val != prev.val) {
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        return true;
    }

    /*
    idea with memory
    time O(N) space O(N)
    while second
        first pointer add to stack
        second go double faster
    while first pointer
        check cur value != stack value
            return false
    return true
     */


    // List 1 2 3 2 1
    // space O(N) time O(2*N)
    // !!! Time Limit Exceeded
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
    public boolean isPalindromeWithoutMemory(ListNode head) {
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

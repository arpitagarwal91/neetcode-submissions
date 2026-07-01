/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

public class Solution {
    public void ReorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode second = slow.next;
        slow.next = null;

        while(second!=null){
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }
        second = prev;
        ListNode first = head;
        while(second!=null){
            ListNode f1 = first.next;
            ListNode s1 = second.next;
            first.next = second;
            second.next = f1;
            first = f1;
            second = s1;
        }

    }
}

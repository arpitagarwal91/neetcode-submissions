/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
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

        while(first!=null && second!=null){
            ListNode tmp1 = first.next;
            first.next = second;
            ListNode tmp2 = second.next;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}

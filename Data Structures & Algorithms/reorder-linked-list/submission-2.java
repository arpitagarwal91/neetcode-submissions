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
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        ListNode prev = null;
        ListNode cur = second;
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        slow.next = null;
        ListNode first = head;
        second = prev;
        while(first!=null && second!=null){
            ListNode tmp = first.next;
            first.next = second;
            ListNode tmp2 = second.next;
            second.next = tmp;
            second = tmp2;
            first = tmp;
        }
    }
}

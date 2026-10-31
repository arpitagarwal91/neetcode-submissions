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
        ListNode dummy = new ListNode(0, head);
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        ListNode second = prev;
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

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while(n>0){
            cur = cur.next;
            n--;
        }
        ListNode nth = head;
        ListNode prev = dummy;
        while(cur!=null && cur.next!=null){
            prev = prev.next;
            nth = nth.next;
            cur = cur.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}

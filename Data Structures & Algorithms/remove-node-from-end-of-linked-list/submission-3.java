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
        ListNode cur = dummy.next;
        while(n>0){
            cur = cur.next;
            n--;
        }
        ListNode prev = dummy;
        ListNode nth = dummy.next;
        while(cur!=null){
            cur = cur.next;
            prev = nth;
            nth = nth.next;
        }
        prev.next = nth.next;
        return dummy.next;
    }
}

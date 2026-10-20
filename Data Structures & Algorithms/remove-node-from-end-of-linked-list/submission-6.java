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
       ListNode nth = cur.next;
       while(n!=0){
        cur = cur.next;
        n--;
       }
       ListNode p1 = dummy;
       ListNode p2 = head;
       while(cur!=null && cur.next!=null){
        p1 = p1.next;
        p2 = p2.next;
        cur = cur.next;
       }
       p1.next = p1.next.next;
       return dummy.next;
    }
}

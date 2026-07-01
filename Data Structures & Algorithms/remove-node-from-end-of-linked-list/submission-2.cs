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
    public ListNode RemoveNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode prev = dummy;
        while(n>0){
            cur = cur.next;
            n--;
        }
        while(cur.next!=null){
            prev = prev.next;
            cur = cur.next;
        }
        ListNode tmp = prev.next;
        prev.next = prev.next.next;
        tmp.next = null;
        return dummy.next;
    }
}

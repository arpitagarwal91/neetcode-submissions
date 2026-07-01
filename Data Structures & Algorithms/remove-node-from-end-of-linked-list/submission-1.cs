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
        ListNode nth = dummy;
        ListNode last = dummy;
        while(n>0){
            last = last.next;
            n--;
        }
        while(last.next!=null){
            nth = nth.next;
            last = last.next;
        }
        nth.next = nth.next.next;
        return dummy.next;
    }
}

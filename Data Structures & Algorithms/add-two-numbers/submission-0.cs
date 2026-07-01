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
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1!=null && l2!=null){
            int sum = carry + l1.val + l2.val;
            carry = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int sum = carry + l1.val;
            carry = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int sum = carry + l2.val;
            carry = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            l2 = l2.next;
        }
        if(carry>0) cur.next = new ListNode(carry);
        return dummy.next;
    }
}

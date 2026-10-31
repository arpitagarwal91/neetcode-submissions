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
        ListNode prev = dummy;
        ListNode right = cur;
        ListNode left = dummy;
        System.out.println(right.val);
        while(right!=null){
            right = right.next;
            prev = left;
            left = left.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}

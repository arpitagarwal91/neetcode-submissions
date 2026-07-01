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
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode first = root;
        ListNode second = root;
        while(n>0){
            second = second.next;
            n--;
        }
        while(first.next != null && second.next != null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return root.next;
    }
}

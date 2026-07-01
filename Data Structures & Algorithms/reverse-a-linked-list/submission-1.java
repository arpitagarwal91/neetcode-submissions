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
    public ListNode reverseList(ListNode head) {
        ListNode newNext = null;
        ListNode currHead = head;
        while(head!=null){
            currHead = head.next;
            head.next = newNext;
            newNext = head;
            head = currHead;
        }
        return newNext;
    }
}

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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;
        while(true){
            ListNode kth = getKthNode(groupPrev, k);
            if(kth==null) break;
            ListNode groupNext = kth.next;
            ListNode prev = kth.next;
            ListNode cur = groupPrev.next;
            while(cur!=groupNext){
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }
            //Didn't understand below 3 lines
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
            
        }
        return dummy.next;
    }

    private ListNode getKthNode(ListNode node, int k){
        while(k>0 && node!=null){
            node = node.next;
            k--;
        }
        return node;
    }
}

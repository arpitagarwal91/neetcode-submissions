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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        while(lists.length>1){
            List<ListNode> ls = new ArrayList<>();
            for(int i=0;i<lists.length;i=i+2){
                ListNode l1 = lists[i];
                ListNode l2 = i+1<lists.length ? lists[i+1] : null;
                ListNode res = mergeLists(l1, l2);
                ls.add(res);
            }
            lists = ls.toArray(ListNode[]::new);
        }
        return lists[0];
    }

    public ListNode mergeLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1!=null){
            cur.next = l1;
        }
        if(l2!=null){
            cur.next = l2;
        }
        return dummy.next;
    }
}

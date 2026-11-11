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
        List<ListNode> ls = Arrays.stream(lists).collect(Collectors.toList());
        while(ls.size()>1){
            List<ListNode> updated = new ArrayList<>();
            for(int i=0;i<ls.size();i=i+2){
                ListNode l1 = ls.get(i);
                ListNode l2 = i+1<ls.size() ? ls.get(i+1) : null;
                updated.add(mergeLists(l1, l2));
            }
            ls = updated;
        }
        return ls.size()==0 ? null : ls.get(0);
    }

    private ListNode mergeLists(ListNode l1, ListNode l2){
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
        if(l1!=null) cur.next = l1;
        if(l2!=null) cur.next = l2;
        return dummy.next;
    }
}

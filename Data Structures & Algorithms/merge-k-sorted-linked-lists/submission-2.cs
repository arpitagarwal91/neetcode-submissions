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
    public ListNode MergeKLists(ListNode[] lists) {
        if(lists==null||lists.Length==0) return null;
        
        while(lists.Length>1){
            
            List<ListNode> ans = new();
            for(int i=0;i<lists.Length;i=i+2){
                ListNode l1 = lists[i];
                ListNode l2 = (i+1)<lists.Length ? lists[i+1] : null;
                ans.Add(Merge2Lists(l1, l2)); 
            }
            lists = ans.ToArray();
        }
        return lists[0];
    }

    public ListNode Merge2Lists(ListNode l1, ListNode l2){
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

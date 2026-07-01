/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while(q.size()>0){
            int len = q.size();
            for(int i=0;i<len;i++){
                TreeNode ele = q.poll();
                if(ele!=null){
                    if(ele.left!=null) q.add(ele.left);
                    if(ele.right!=null) q.add(ele.right);
                }
                if(i==len-1){
                    res.add(ele.val);
                }
            }
        }
        return res;
    }
}

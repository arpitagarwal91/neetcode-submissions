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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> ls = new ArrayList<>();
            int len = q.size();
            for(int i=0;i<len;i++){
                TreeNode ele = q.poll();
                if(ele.left!=null) q.add(ele.left);
                if(ele.right!=null) q.add(ele.right);
                ls.add(ele.val);
            }
            res.add(ls);
        }
        return res;
    }
}

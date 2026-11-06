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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int res = getMaxDepth(root);
        return res>0 ? true : false;
    }

    private int getMaxDepth(TreeNode node){
        if(node==null) return 0;
        int leftH = getMaxDepth(node.left);
        if(leftH==-1) return -1;
        int rightH = getMaxDepth(node.right);
        if(rightH==-1) return -1;
        if(Math.abs(leftH-rightH)>1) return -1;
        return 1 + Math.max(leftH, rightH);
    }
}

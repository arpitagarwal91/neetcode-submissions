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
    public boolean isValidBST(TreeNode root) {
        return isValidBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBst(TreeNode node, int min, int max){
        if(node==null) return true;
        if(node.val>min && node.val<max){
            return isValidBst(node.left, min, node.val) && isValidBst(node.right, node.val, max);
        }
        else return false;
    }
}

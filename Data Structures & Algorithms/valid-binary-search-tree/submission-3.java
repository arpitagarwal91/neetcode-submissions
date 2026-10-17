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
        return isValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean isValid(TreeNode node, int max, int min){
        if(node==null) return true;
        if(node.val<=min || node.val>=max) return false;
        boolean isLeftValid = isValid(node.left, node.val, min);
        boolean isRightValid = isValid(node.right, max, node.val);
        return isLeftValid && isRightValid;
    }
}

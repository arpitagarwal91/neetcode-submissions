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
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, int mini, int maxi){
        if(node==null) return true;
        if(node.val<=mini || node.val>=maxi) return false;
        boolean isLeft = isValid(node.left, mini, node.val);
        boolean isRight = isValid(node.right, node.val, maxi);
        return isLeft && isRight;
    }
}

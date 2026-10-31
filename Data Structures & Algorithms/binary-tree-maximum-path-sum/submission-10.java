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
    public int maxPathSum(TreeNode root) {
        int res[] = {Integer.MIN_VALUE}; //Used 0 as minimum value instead without looking at constraints.
        getMaxPathSum(root, res);
        return res[0];
    }

    private int getMaxPathSum(TreeNode node, int res[]){
        if(node==null) return 0;
        int leftSum = Math.max(0, getMaxPathSum(node.left, res));
        int rightSum = Math.max(0, getMaxPathSum(node.right, res));
        res[0] = Math.max(res[0], node.val+leftSum+rightSum);
        return node.val+Math.max(leftSum, rightSum);
    }
}

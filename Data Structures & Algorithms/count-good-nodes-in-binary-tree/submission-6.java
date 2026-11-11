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
    public int goodNodes(TreeNode root) {
        int res[] = {0};
        countGoodNodes(root, res, -101);
        return res[0];
    }

    private void countGoodNodes(TreeNode node, int res[], int prevMax){
        if(node==null) return;
        if(node.val>=prevMax) res[0]++;
        countGoodNodes(node.left, res, Math.max(prevMax, node.val));
        countGoodNodes(node.right, res, Math.max(prevMax, node.val));
    }
}

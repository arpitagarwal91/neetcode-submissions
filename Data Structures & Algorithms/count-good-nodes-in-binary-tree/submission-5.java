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
        return countGoodNode(root, -101);
    }

    private int countGoodNode(TreeNode node, int prevMax){
        if(node==null) return 0;
        int count = (node.val>=prevMax) ? 1 : 0;
        return count + countGoodNode(node.left, Math.max(prevMax, node.val)) + countGoodNode(node.right, Math.max(prevMax, node.val));
    }
}

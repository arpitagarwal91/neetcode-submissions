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
        getGoodNodesCount(root, root.val, res);
        return res[0];
    }

    private void getGoodNodesCount(TreeNode node, int prevVal, int res[]){
        if(node==null) return;
        if(node.val>=prevVal) res[0]++;
        int max = Math.max(prevVal, node.val);
        getGoodNodesCount(node.left, max, res);
        getGoodNodesCount(node.right, max, res);
    }
}

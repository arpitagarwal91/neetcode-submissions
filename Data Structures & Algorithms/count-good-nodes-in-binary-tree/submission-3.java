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
        if(root==null) return 0;
        int maxSeen = -101;
        int res[] = {0};
        getGoodNodes(root, maxSeen, res);
        return res[0];
    }

    private void getGoodNodes(TreeNode node, int maxSeen, int res[]){
        if(node.val>=maxSeen) res[0]++;
        if(node.left!=null) getGoodNodes(node.left, Math.max(node.val, maxSeen), res);
        if(node.right!=null) getGoodNodes(node.right, Math.max(node.val, maxSeen), res);
    }
}

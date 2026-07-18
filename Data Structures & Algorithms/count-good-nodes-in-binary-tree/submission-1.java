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
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxSeen){
        if(node==null) return 0;
        if(node.val>=maxSeen){
            return 1+dfs(node.left, node.val)+dfs(node.right, node.val);
        }
        return dfs(node.left, maxSeen)+dfs(node.right, maxSeen);

    }
}

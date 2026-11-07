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
        int res[] = {Integer.MIN_VALUE};
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode node, int res[]){
        if(node==null) return 0;
        int leftH = Math.max(0, dfs(node.left, res));
        int rightH = Math.max(0, dfs(node.right, res));
        res[0] = Math.max(res[0], node.val+leftH+rightH);
        return node.val+Math.max(leftH, rightH);
    }
}

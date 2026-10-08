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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null) return true;
        if(root==null) return false;
        return isEqualTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isEqualTree(TreeNode t1, TreeNode t2){
        if(t1==null && t2==null) return true;
        if(t1==null||t2==null) return false;
        return t1.val==t2.val && isEqualTree(t1.left, t2.left) && isEqualTree(t1.right, t2.right);
    }
}

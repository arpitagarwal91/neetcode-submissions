/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Solution {    
    public bool IsSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null) return true;
        if(root==null) return false;
        if(root.val==subRoot.val && IsSameTree(root.left,subRoot.left) && IsSameTree(root.right, subRoot.right)){
            return true;
        }
        else{
            return IsSubtree(root.left, subRoot)||IsSubtree(root.right, subRoot);
        }
    }

    public bool IsSameTree(TreeNode t1, TreeNode t2){
        if(t1==null && t2==null) return true;
        if(t1!=null && t2==null) return false;
        if(t1==null && t2!=null) return false;
        return (t1.val==t2.val && IsSameTree(t1.left,t2.left) && IsSameTree(t1.right,t2.right));
    }
}

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

    //Forgot that Inorder traversal of BST
    // will help get the Kth Smallest element
    public int kthSmallest(TreeNode root, int k) {
        int n = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur!=null || stack.size()>0){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            n++;
            if(n==k) return cur.val;
            cur = cur.right;
        }
        return -1;
    }
}

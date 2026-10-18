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
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(true){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                if(stack.isEmpty()) break;
                count++;
                cur = stack.pop();
                if(count==k) return cur.val;
                cur = cur.right;
            }
        }
        return -1;
    }
}

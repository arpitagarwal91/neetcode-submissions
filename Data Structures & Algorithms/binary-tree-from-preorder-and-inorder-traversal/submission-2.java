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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++) inorderMap.put(inorder[i], i);
        return buildTree(0, preorder.length-1, preorder, 0, inorder.length-1, inorder, inorderMap);
    }

    public TreeNode buildTree(int ps, int pe, int[] preorder, int is, int ie, int[] inorder, Map<Integer, Integer> inorderMap){
        if(ps>pe || is>ie) return null;
        TreeNode node = new TreeNode(preorder[ps]);
        int idx = inorderMap.get(node.val);
        int leftElements = idx-is;
        node.left = buildTree(ps+1, ps+leftElements, preorder, is, idx-1, inorder, inorderMap);
        node.right = buildTree(ps+leftElements+1, pe, preorder, idx+1, ie, inorder, inorderMap);
        return node;
    }
}

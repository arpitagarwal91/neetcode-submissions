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
        int count = 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, Integer.MIN_VALUE));

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                Pair<TreeNode, Integer> ele = q.poll();
                TreeNode node = ele.getKey();
                int maxSeen = ele.getValue();
                if(node.val>=maxSeen) count++;
                maxSeen = Math.max(maxSeen, node.val);
                if(node.left!=null) q.add(new Pair<>(node.left, maxSeen));
                if(node.right!=null) q.add(new Pair<>(node.right, maxSeen));
            }
        }
        return count;
    }
}

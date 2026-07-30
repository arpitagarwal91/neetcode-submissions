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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> ls = new ArrayList();
        dfs(root, ls);
        return String.join(",", ls);
    }

    public void dfs(TreeNode node, List<String> ls){
        if(node==null) {
            ls.add("N");
            return;
        }
        ls.add(String.valueOf(node.val));
        dfs(node.left, ls);
        dfs(node.right, ls);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return dfs(new int[]{0}, data);
    }

    public TreeNode dfs(int[] i, String data){
        String arr[] = data.split(",");
        String s = arr[i[0]];
        if(s.equals("N")){
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s));
        i[0]++;
        node.left = dfs(i, data);
        node.right = dfs(i, data);
        return node;
    }
}

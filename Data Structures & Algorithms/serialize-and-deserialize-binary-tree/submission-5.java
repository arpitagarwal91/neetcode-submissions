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
        if(root==null) return "";
        List<String> ls = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null){
                ls.add("N");
                continue;
            }
            else {
                ls.add(node.val+"");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return String.join(",", ls);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String arr[] = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i=1;i<arr.length;i++){
            TreeNode node = q.poll();
            if(!arr[i].equals("N")){
                node.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(node.left);
            }
            if(!arr[++i].equals("N")){
                node.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(node.right);
            }
        }
        return root;
    }
}

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> mp = new HashMap<>();
        return dfs(head, mp);
    }

    public Node dfs(Node node, Map<Node, Node> mp){
        if(node==null) return null;
        if(mp.containsKey(node)) return mp.get(node);
        Node copy = new Node(node.val);
        mp.put(node, copy);
        copy.next = dfs(node.next, mp);
        copy.random = mp.get(node.random);
        return mp.get(node);
    }
}

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
        Map<Node, Node> cache = new HashMap<>();
        return dfs(head, cache);
    }

    private Node dfs(Node node, Map<Node, Node> cache){
        if(node==null) return null;
        if(cache.containsKey(node)) return cache.get(node);
        Node copy = new Node(node.val);
        cache.put(node, copy);
        copy.next = dfs(node.next, cache);
        copy.random = dfs(node.random, cache);
        return copy;
    }
}

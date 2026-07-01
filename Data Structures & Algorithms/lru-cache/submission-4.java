class LRUCache {

    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> mp;

    class Node {

        Node prev;
        Node next;
        int key;
        int val;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public void addNode(Node node){
        Node lastNode = this.tail.prev;
        lastNode.next = node;
        node.prev = lastNode;
        node.next = this.tail;
        this.tail.prev = node;
    }

    public void removeNode(Node node){
        Node prv = node.prev;
        Node nxt = node.next;
        prv.next = nxt;
        nxt.prev = prv;
    }

    public LRUCache(int capacity) {
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.mp = new HashMap<>();
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;
        Node node = mp.get(key);
        removeNode(node);
        addNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)) {
            Node existingNode = mp.get(key);
            removeNode(existingNode);
        }
        Node node = new Node(key, value);
        addNode(node);
        mp.put(key, node);
        if(mp.size()>capacity){
            Node top = this.head.next;
            removeNode(top);
            mp.remove(top.key);
        }
    }
}

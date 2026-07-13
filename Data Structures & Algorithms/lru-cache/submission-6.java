class LRUCache {

    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.capacity = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if(this.map.containsKey(key)){
            Node node = this.map.get(key);
            remove(node);
            addLast(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = null;
        if(this.map.containsKey(key)){
            node = this.map.get(key);
            remove(node);
        }
        node = new Node(key, value);
        addLast(node);
        this.map.put(key, node);
        if(this.map.keySet().size()>capacity){
            this.map.remove(this.head.next.key);
            remove(this.head.next);
        }
    }

    public void remove(Node node){
        Node prv = node.prev;
        Node nxt = node.next;
        prv.next = nxt;
        nxt.prev = prv;
    }

    public void addLast(Node node){
        Node last = this.tail.prev;
        last.next = node;
        node.prev = last;
        node.next = this.tail;
        this.tail.prev = node;
    }

    class Node {
        Node prev;
        Node next;
        int val;
        int key;

        public Node(int key, int val){
            this.val = val;
            this.key = key;
            this.prev = prev;
            this.next = next;
        }
    }
}

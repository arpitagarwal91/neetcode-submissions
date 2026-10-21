class LRUCache {

    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.cache = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!this.cache.containsKey(key)) return -1;
        Node node = this.cache.get(key);
        removeNode(node);
        addNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(this.cache.containsKey(key)){
            Node node = this.cache.get(key);
            removeNode(node);
        }
        Node node = new Node(key, value);
        addNode(node);
        this.cache.put(key, node);
        if(this.cache.keySet().size()>this.capacity){
            Node toBeRemoved = this.head.next;
            removeNode(toBeRemoved);
            this.cache.remove(toBeRemoved.key);
        }
    }

    private void addNode(Node node){
        Node last = this.tail.prev;
        last.next = node;
        node.prev = last;
        node.next = this.tail;
        this.tail.prev = node;
    }

    private void removeNode(Node node){
        Node prv = node.prev;
        Node nxt = node.next;
        prv.next = nxt;
        nxt.prev = prv;
        node.prev = null;
        node.next = null;
    }
}

class Node {
    Node prev;
    Node next;
    int key;
    int value;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

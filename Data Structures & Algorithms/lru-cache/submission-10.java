class LRUCache {

    Node head;
    Node tail;
    Map<Integer, Node> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.cache = new HashMap<>();
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

    private void removeNode(Node node){
        Node nxt = node.next;
        Node prv = node.prev;
        nxt.prev = prv;
        prv.next = nxt;
        node.next = null;
        node.prev = null;
    }

    private void addNode(Node node){
        Node last = this.tail.prev;
        last.next = node;
        node.prev = last;
        node.next = this.tail;
        this.tail.prev = node;
    }
}

class Node {
    Node next;
    Node prev;
    int key;
    int value;

    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

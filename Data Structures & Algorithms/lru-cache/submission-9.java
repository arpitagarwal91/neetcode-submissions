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
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }
    
    public int get(int key) {
        if(!this.cache.containsKey(key)) return -1;
        Node node = this.cache.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(this.cache.containsKey(key)){
            Node node = this.cache.get(key);
            remove(node);
        }
        Node node = new Node(key, value);
        this.cache.put(key, node);
        add(node);
        if(this.cache.keySet().size()>this.capacity){
            Node toBeRemoved = this.head.next;
            remove(toBeRemoved);
            this.cache.remove(toBeRemoved.key);
        }
    }

    private void add(Node node){
        Node last = this.tail.prev;
        last.next = node;
        node.prev = last;
        node.next = this.tail;
        this.tail.prev = node;
    }

    private void remove(Node node){
        Node prv = node.prev;
        Node nxt = node.next;
        prv.next = nxt;
        nxt.prev = prv;
        node.next = null;
        node.prev = null;
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

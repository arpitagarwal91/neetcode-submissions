class LRUCache {

    int capacity;
    Map<Integer, Node> mp;
    Node head;
    Node tail;
    List<Node> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.mp = new HashMap();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node node){
        Node nxt = node.next;
        Node pre = node.prev;
        pre.next = nxt;
        nxt.prev = pre;
    }

    public void insert(Node node){
        Node last = tail.prev;
        last.next = node;
        node.prev = last;
        node.next = tail;
        tail.prev = node;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;
        Node node = mp.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)) remove(mp.get(key));
        Node node = new Node(key, value);
        insert(node);
        mp.put(key, node);
        if(mp.size()>capacity){
            Node lru = head.next;
            remove(lru);
            mp.remove(lru.key);
        }
    }
}

class Node {
    Node prev;
    Node next;
    int key;
    int val;
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

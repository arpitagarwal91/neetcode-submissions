class LFUCache {

    Map<Integer, Node> keyNode;
    Map<Integer, LRUCache> freqMap;
    int capacity;
    int minFreq;
    int curSize;

    public LFUCache(int capacity) {
        this.keyNode = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
        this.curSize = 0;
    }
    
    public int get(int key) {
        if(!this.keyNode.containsKey(key)) return -1;
        Node node = this.keyNode.get(key);
        updateNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;

        if(this.keyNode.containsKey(key)){
            Node node = this.keyNode.get(key);
            node.value = value;
            updateNode(node);
        }
        else{
            this.curSize++;
            if(this.curSize>capacity){
                LRUCache cache = this.freqMap.get(minFreq);
                Node nodeToBeRemoved = cache.head.next;
                cache.removeNode(nodeToBeRemoved);
                this.keyNode.remove(nodeToBeRemoved.key);
                this.curSize--;
            }
            Node node = new Node(key, value);
            minFreq = 1;
            this.keyNode.put(key, node);
            LRUCache cache = this.freqMap.getOrDefault(minFreq, new LRUCache());
            cache.addNode(node);
            this.freqMap.put(minFreq, cache);
        }
    }

    private void updateNode(Node node){
        LRUCache lastFreqCache = this.freqMap.get(node.freq);
        lastFreqCache.removeNode(node);
        if(node.freq==minFreq && lastFreqCache.size==0){
            minFreq++;
        }
        node.freq++;
        LRUCache newFreqCache = this.freqMap.getOrDefault(node.freq, new LRUCache());
        newFreqCache.addNode(node);
        this.freqMap.put(node.freq, newFreqCache);
    }
}

class LRUCache {

    Node head;
    Node tail;
    int size;

    public LRUCache(){
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node node){
        Node last = this.tail.prev;
        last.next = node;
        node.prev = last;
        node.next = this.tail;
        this.tail.prev = node;
        this.size++;
    }

    public void removeNode(Node node){
        Node prv = node.prev;
        Node nxt = node.next;
        prv.next = nxt;
        nxt.prev = prv;
        node.next = null;
        node.prev = null;
        this.size--;
    }
}

class Node {
    int key;
    int value;
    Node prev;
    Node next;
    int freq;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
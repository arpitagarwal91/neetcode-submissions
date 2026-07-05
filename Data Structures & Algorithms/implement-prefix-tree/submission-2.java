class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = this.root;
        for(char c:word.toCharArray()){
            if(!cur.neighbors.containsKey(c)) cur.neighbors.put(c, new TrieNode());
            cur = cur.neighbors.get(c);
        }
        cur.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = this.root;
        for(char c:word.toCharArray()){
            if(!cur.neighbors.containsKey(c)) return false;
            cur = cur.neighbors.get(c);
        }
        return cur.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = this.root;
        for(char c:prefix.toCharArray()){
            if(!cur.neighbors.containsKey(c)) return false;
            cur = cur.neighbors.get(c);
        }
        return true;
    }

    class TrieNode {

        Map<Character, TrieNode> neighbors;
        boolean isEndOfWord = false;

        public TrieNode(){
            this.neighbors = new HashMap<>();
        }
    }
}

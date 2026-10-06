class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = this.root;
        for(char c:word.toCharArray()){
            if(!cur.neighbors.containsKey(c)) cur.neighbors.put(c, new TrieNode());
            cur = cur.neighbors.get(c);
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = this.root;
        return search(word, 0, cur);
    }

    private boolean search(String word, int k, TrieNode node){
        if(k==word.length()) return node.endOfWord;
        for(int i=k;i<word.length();i++){
            char c = word.charAt(i);
            if(c=='.'){
                for(char ch:node.neighbors.keySet()){
                    if(search(word, i+1, node.neighbors.get(ch))) return true;
                }
                return false;
            }
            else if(!node.neighbors.containsKey(c)) return false;
            else node = node.neighbors.get(c);
        }
        return node.endOfWord;
    }
}

class TrieNode {
    boolean endOfWord;
    Map<Character, TrieNode> neighbors = new HashMap<>();
}

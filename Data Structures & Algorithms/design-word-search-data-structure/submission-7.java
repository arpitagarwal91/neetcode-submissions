class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = this.root;
        for(char c:word.toCharArray()){
            if(!cur.children.containsKey(c)) cur.children.put(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(0, word, this.root);
    }

    private boolean dfs(int idx, String word, TrieNode node){
        if(idx==word.length()) return node.endOfWord;
        if(word.charAt(idx)!='.'){
            if(!node.children.containsKey(word.charAt(idx))) return false;
            node = node.children.get(word.charAt(idx));
            return dfs(idx+1, word, node);
        }
        else{
            for(char c:node.children.keySet()){
                TrieNode nei = node.children.get(c);
                if(dfs(idx+1, word, nei)) return true;
            }
            return false;
        }
    }
}

class TrieNode {
    boolean endOfWord;
    Map<Character, TrieNode> children = new HashMap<>();
}

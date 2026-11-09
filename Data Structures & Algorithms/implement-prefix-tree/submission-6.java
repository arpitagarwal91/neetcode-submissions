class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = this.root;
        for(char c:word.toCharArray()){
            if(cur.child[c-'a']==null) cur.child[c-'a'] = new TrieNode();
            cur = cur.child[c-'a'];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = this.root;
        for(char c:word.toCharArray()){
            if(cur.child[c-'a']==null) return false;
            cur = cur.child[c-'a'];
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = this.root;
        for(char c:prefix.toCharArray()){
            if(cur.child[c-'a']==null) return false;
            cur = cur.child[c-'a'];
        }
        return true;
    }
}

class TrieNode {
    boolean endOfWord;
    TrieNode child[] = new TrieNode[26];
}

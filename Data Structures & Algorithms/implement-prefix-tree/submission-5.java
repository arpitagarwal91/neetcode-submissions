class PrefixTree {

    TrieNode root;

    public PrefixTree() {
         this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = this.root;
        for(char c:word.toCharArray()){
            if(cur.children[c-'a']==null) cur.children[c-'a'] = new TrieNode();
            cur = cur.children[c-'a'];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = this.root;
        for(char c:word.toCharArray()){
            if(cur.children[c-'a']==null) return false;
            cur = cur.children[c-'a'];
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = this.root;
        for(char c:prefix.toCharArray()){
            if(cur.children[c-'a']==null) return false;
            cur = cur.children[c-'a'];
        }
        return true;
    }
}

class TrieNode {

    boolean endOfWord;
    TrieNode[] children;

    public TrieNode(){
        this.endOfWord = false;
        this.children = new TrieNode[26];
    }
}

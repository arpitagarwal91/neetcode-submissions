class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = this.root;
        for(char c:word.toCharArray()){
            if(cur.child[c-'a']==null) cur.child[c-'a'] = new TrieNode();
            cur = cur.child[c-'a'];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(0, word, this.root);
    }

    private boolean dfs(int idx, String word, TrieNode node){
        if(node==null) return false;
        if(idx==word.length()) return node.endOfWord; //Forgot to use endOfWord and directly returned true.
        char c = word.charAt(idx);
        if(c!='.'){
            if(node.child[c-'a']==null) return false;
            return dfs(idx+1, word, node.child[c-'a']);
        }
        else{
            for(TrieNode nei:node.child){
                if(dfs(idx+1, word, nei)) return true;
            }
            return false;
        }
    }
}

class TrieNode {
    boolean endOfWord;
    TrieNode child[];

    public TrieNode(){
        this.child = new TrieNode[26];
        this.endOfWord = false;
    }
}

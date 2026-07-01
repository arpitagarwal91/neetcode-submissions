class WordDictionary {

    TrieNode root;

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap();
        boolean endOfWord = false;
    }

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = this.root;
        for(Character c:word.toCharArray()){
            if(!cur.children.containsKey(c)){
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(0,word,root);
    }

    public boolean dfs(int i, String word, TrieNode node){
        TrieNode cur = node;
        for(int k=i;k<word.length();k++){
            char c = word.charAt(k);
            if(c!='.'){
                if(!cur.children.containsKey(c)){
                    return false;
                }
                cur = cur.children.get(c);
            }
            else{
                for(TrieNode child:cur.children.values()){
                    if(dfs(k+1,word,child)) return true;
                }
                return false;
            }
        }
        return cur.endOfWord;
    }
}

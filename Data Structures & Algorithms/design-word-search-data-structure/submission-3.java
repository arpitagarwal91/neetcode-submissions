class WordDictionary {

    TrieNode root;

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();;
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

    public boolean dfs(int k, String word, TrieNode node){
        TrieNode cur = node;
        for(int i=k;i<word.length();i++){
            char c = word.charAt(i);
            if(c!='.'){
                if(!cur.children.containsKey(c)){
                    return false;
                }
                cur = cur.children.get(c);
            }
            else{
                for(TrieNode child:cur.children.values()){
                    if(dfs(i+1, word, child)){ //Used k+1 instaed of i+1 here.
                        return true;
                    }
                }
                return false; //Forgot to add this line.
            }
        }
        return cur.endOfWord;
    }
}

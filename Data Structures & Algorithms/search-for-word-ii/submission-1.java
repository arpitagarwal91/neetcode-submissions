class Solution {
    
    TrieNode root;

    class TrieNode{
        Map<Character, TrieNode> children = new HashMap();
        boolean isEndOfWord = false;
    }

    public void addWord(String word){
        TrieNode cur = this.root;
        for(Character c:word.toCharArray()){
            if(!cur.children.containsKey(c)){
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isEndOfWord = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.root = new TrieNode();
        for(String word:words){
            addWord(word);
        }
        Set<String> res = new HashSet();
        boolean visit[][] = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(i,j,"",board,this.root,visit,res);
            }
        }
        return new ArrayList(res);
    }

    public void dfs(int r, int c, String word, char board[][],
     TrieNode node, boolean visit[][], Set<String> res){
        if(r<0||c<0||r==board.length||c==board[0].length
        ||visit[r][c]||!node.children.containsKey(board[r][c])) return;

        visit[r][c] = true;
        node = node.children.get(board[r][c]);
        word+=board[r][c];
        if(node.isEndOfWord) res.add(word);
        dfs(r+1,c,word,board,node,visit,res);
        dfs(r-1,c,word,board,node,visit,res);
        dfs(r,c+1,word,board,node,visit,res);
        dfs(r,c-1,word,board,node,visit,res);
        visit[r][c] = false;
    }
}

class Solution {

    TrieNode root;

    class TrieNode{
        Map<Character, TrieNode> children = new HashMap();
        boolean isWord = false;
    }

    public void addWord(String word){
        TrieNode cur = this.root;
        for(Character c:word.toCharArray()){
            if(!cur.children.containsKey(c)){
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
    Set<String> res = new HashSet();

    public List<String> findWords(char[][] board, String[] words) {
        this.root = new TrieNode();
        for(String word:words){
            addWord(word);
        }
        boolean[][] visit = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(i,j,"",this.root,board,visit);
            }
        }
        return new ArrayList(res);
    }

    public void dfs(int r, int c, String word, TrieNode node, char board[][], boolean[][] visit){
        if(r<0||c<0||r==board.length||c==board[0].length||visit[r][c]||!node.children.containsKey(board[r][c])) return;
        visit[r][c] = true;
        node = node.children.get(board[r][c]);
        word+=board[r][c];
        if(node.isWord) res.add(word);
        dfs(r+1,c,word,node,board,visit);
        dfs(r-1,c,word,node,board,visit);
        dfs(r,c+1,word,node,board,visit);
        dfs(r,c-1,word,node,board,visit);
        visit[r][c] = false;
    }

}

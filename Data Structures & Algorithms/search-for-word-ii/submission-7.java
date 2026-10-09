class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word:words) trie.addWord(word);
        int m = board.length;
        int n = board[0].length;
        boolean visit[][] = new boolean[m][n];
        Set<String> res = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]){
                    dfs(i,j,new StringBuilder(),board,visit,trie.root,res);
                }
            }
        }
        return new ArrayList(res);
    }

    private void dfs(int r, int c, StringBuilder sb, char[][] board, boolean[][] visit, TrieNode node, Set<String> res){
        if(r<0||c<0||r==board.length||c==board[0].length||visit[r][c]||node.children[board[r][c]-'a']==null) return;
        visit[r][c] = true;
        sb.append(board[r][c]);
        if(node.children[board[r][c]-'a'].endOfWord){
            res.add(sb.toString());
        }
        node = node.children[board[r][c]-'a'];
        dfs(r+1, c, sb, board, visit, node, res);
        dfs(r-1, c, sb, board, visit, node, res);
        dfs(r, c+1, sb, board, visit, node, res);
        dfs(r, c-1, sb, board, visit, node, res);
        sb.deleteCharAt(sb.length()-1);
        visit[r][c] = false;
    }
}

class Trie {

    TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public void addWord(String word){
        TrieNode cur = this.root;
        for(char c:word.toCharArray()){
            if(cur.children[c-'a']==null) cur.children[c-'a'] = new TrieNode();
            cur = cur.children[c-'a'];
        }
        cur.endOfWord = true;
    }

    public boolean searchWord(String word){
        TrieNode cur = this.root;
        for(char c:word.toCharArray()){
            if(cur.children[c-'a']==null) return false;
            cur = cur.children[c-'a'];
        }
        return cur.endOfWord;
    }
}

class TrieNode {
    boolean endOfWord;
    TrieNode children[] = new TrieNode[26];
}

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
                    dfs(i, j, board, visit, trie.root, new StringBuilder(), res);
                }
            }
        }
        return res.stream().collect(Collectors.toList());
    }

    private void dfs(int r, int c, char[][] board, boolean visit[][], TrieNode node, StringBuilder sb, Set<String> res){
        if(node.endOfWord>0) {
            res.add(sb.toString());
            //return; //Used this in last attempt which led to avoiding adding overlapping words in res
        }
        if(r<0||c<0||r==board.length||c==board[0].length||visit[r][c]||!node.children.containsKey(board[r][c])) return;
        sb.append(board[r][c]);
        visit[r][c] = true;
        dfs(r+1, c, board, visit, node.children.get(board[r][c]), sb, res);
        dfs(r-1, c, board, visit, node.children.get(board[r][c]), sb, res);
        dfs(r, c+1, board, visit, node.children.get(board[r][c]), sb, res);
        dfs(r, c-1, board, visit, node.children.get(board[r][c]), sb, res);
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
            if(!cur.children.containsKey(c)) cur.children.put(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.endOfWord++;
    }

    public boolean search(String word){
        TrieNode cur = this.root;
        for(char c:word.toCharArray()){
            if(!cur.children.containsKey(c)) return false;
            cur = cur.children.get(c);
        }
        return cur.endOfWord>0;
    }

    public void delete(String word){
        TrieNode cur = this.root;
        for(char c:word.toCharArray()){
            if(!cur.children.containsKey(c)) return;
            cur = cur.children.get(c);
        }
        cur.endOfWord--;
    }
}

class TrieNode {
    int endOfWord = 0;
    Map<Character, TrieNode> children = new HashMap<>();
}

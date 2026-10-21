class Solution {
    public List<String> findWords(char[][] board, String[] words) {
       Set<String> res = new HashSet<>();
       int m = board.length;
       int n = board[0].length;
       boolean visit[][] = new boolean[m][n];
       Trie trie = new Trie();
       for(String word:words){
        trie.insert(word);
       }
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(visit[i][j]) continue;
            dfs(i,j,board,trie.root,visit,new StringBuilder(),res);
        }
       }
       return res.stream().collect(Collectors.toList());
    }

    private void dfs(int r, int c, char[][] board, TrieNode node, boolean[][] visit, StringBuilder sb, Set<String> res){
        if(node.endOfWord){
            res.add(sb.toString());
        }
        if(r<0||c<0||r==board.length||c==board[0].length||visit[r][c]||!node.child.containsKey(board[r][c])) return;
        visit[r][c] = true;
        sb.append(board[r][c]);
        dfs(r+1, c, board, node.child.get(board[r][c]), visit, sb, res);
        dfs(r-1, c, board, node.child.get(board[r][c]), visit, sb, res);
        dfs(r, c+1, board, node.child.get(board[r][c]), visit, sb, res);
        dfs(r, c-1, board, node.child.get(board[r][c]), visit, sb, res);
        sb.deleteCharAt(sb.length()-1);
        visit[r][c] = false;
    }

}

class Trie {

    TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode cur = this.root;
        for(char c:word.toCharArray()){
            if(!cur.child.containsKey(c)) cur.child.put(c, new TrieNode());
            cur = cur.child.get(c);
        }
        cur.endOfWord = true;
    }
}

class TrieNode {
    boolean endOfWord = false;
    Map<Character, TrieNode> child = new HashMap<>();
}

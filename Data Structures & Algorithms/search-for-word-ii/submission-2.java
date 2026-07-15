class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        boolean visit[][] = new boolean[board.length][board[0].length];
        for(String word:words){
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    dfs(i,j,0,word,board,visit,res);
                }
            }
        }
        return new ArrayList(res);
    }

    private void dfs(int r, int c, int k, String word, char[][] board, boolean visit[][], Set<String> res){
        if(k==word.length()){
            res.add(word);
            return;
        }
        if(r<0||c<0||r==board.length||c==board[0].length||visit[r][c]||word.charAt(k)!=board[r][c]) return;
        visit[r][c] = true;
        dfs(r+1, c, k+1, word, board, visit, res);
        dfs(r-1, c, k+1, word, board, visit, res);
        dfs(r, c+1, k+1, word, board, visit, res);
        dfs(r, c-1, k+1, word, board, visit, res);
        visit[r][c] = false;
    }
}

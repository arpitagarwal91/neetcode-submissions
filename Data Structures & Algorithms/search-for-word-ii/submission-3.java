class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        boolean visit[][] = new boolean[board.length][board[0].length];
        for(String word:words){
            boolean flag = false;
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(dfs(i,j,0,word,board,visit,res)) {
                        res.add(word);
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }
        }
        return res;
    }

    private boolean dfs(int r, int c, int k, String word, char[][] board, boolean visit[][], List<String> res){
        if(k==word.length()){
            return true;
        }
        if(r<0||c<0||r==board.length||c==board[0].length||visit[r][c]||word.charAt(k)!=board[r][c]) return false;
        visit[r][c] = true;
        boolean ans = dfs(r+1, c, k+1, word, board, visit, res) ||
        dfs(r-1, c, k+1, word, board, visit, res) ||
        dfs(r, c+1, k+1, word, board, visit, res) ||
        dfs(r, c-1, k+1, word, board, visit, res);
        visit[r][c] = false;
        return ans;
    }
}

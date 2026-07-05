class Solution {
    public boolean exist(char[][] board, String word) {
       boolean visit[][] = new boolean[board.length][board[0].length];
       for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            if(word.charAt(0)==board[i][j] && dfs(i,j,0,board,word,visit)) return true;
        }
       }
       return false; 
    }
    public boolean dfs(int r, int c, int k, char[][] board, String word, boolean visit[][]){
        if(k==word.length()) return true;
        if(r<0||c<0||r==board.length||c==board[0].length||visit[r][c]||board[r][c]!=word.charAt(k)) return false;
        visit[r][c] = true;
        boolean res = dfs(r+1, c, k+1, board, word, visit)||dfs(r-1, c, k+1, board, word, visit)||dfs(r, c+1, k+1, board, word, visit)||dfs(r, c-1, k+1, board, word, visit);
        visit[r][c] = false;
        return res;
    }
}

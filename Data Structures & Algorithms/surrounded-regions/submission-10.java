class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean visit[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(i, 0, board, visit);
            dfs(i, n-1, board, visit);
        }
        for(int i=0;i<n;i++){
            dfs(0, i, board, visit);
            dfs(m-1, i, board, visit);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j] && board[i][j]=='O') board[i][j] = 'X';
            }
        }
    }

    private void dfs(int r, int c, char[][] board, boolean visit[][]){
        if(r<0||c<0||r==board.length||c==board[0].length||visit[r][c]||board[r][c]!='O') return;
        visit[r][c] = true;
        dfs(r+1, c, board, visit);
        dfs(r-1, c, board, visit);
        dfs(r, c+1, board, visit);
        dfs(r, c-1, board, visit);
    }
}

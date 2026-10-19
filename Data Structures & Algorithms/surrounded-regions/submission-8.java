class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean visit[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || i==m-1 || j==0 || j==n-1){
                    dfs(i, j, visit, board);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j] && board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int r, int c, boolean visit[][], char[][] board){
        if(r<0||c<0||r==board.length||c==board[0].length||visit[r][c]||board[r][c]!='O') return;
        visit[r][c] = true;
        dfs(r+1, c, visit, board);
        dfs(r-1, c, visit, board);
        dfs(r, c+1, visit, board);
        dfs(r, c-1, visit, board);
    }

}

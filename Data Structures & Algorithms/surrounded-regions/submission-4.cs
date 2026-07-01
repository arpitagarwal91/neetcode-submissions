public class Solution {
    public void Solve(char[][] board) {
        int ROW = board.Length;
        int COL = board[0].Length;
        for(int i=0;i<ROW;i++) {
            for(int j=0;j<COL;j++){
                if(i==0||j==0||i==ROW-1||j==COL-1){
                    if(board[i][j]=='O') dfs(i,j,board);
                }
            }
        }
        for(int i=0;i<ROW-1;i++){
            for(int j=0;j<COL-1;j++){
                if(board[i][j]=='O') board[i][j] = 'X';
            }
        }
        for(int i=0;i<ROW;i++) {
            for(int j=0;j<COL;j++){
                if(board[i][j]=='T') board[i][j] = 'O';
            }
        }
    }

    public void dfs(int r, int c, char[][] board){
        if(r<0||c<0||r==board.Length||c==board[0].Length||board[r][c]!='O'){
            return;
        }
        board[r][c] = 'T';
        dfs(r+1,c,board);
        dfs(r-1,c,board);
        dfs(r,c+1,board);
        dfs(r,c-1,board);
    }
}

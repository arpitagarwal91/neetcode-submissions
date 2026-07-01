class Solution {
    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0||i==board.length-1||j==0||j==board[0].length-1){
                    if(board[i][j]=='O') capture(i,j,board);
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                if(board[i][j]=='T'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void capture(int r, int c, char board[][]){
        if(r<0||c<0||r==board.length||c==board[0].length||board[r][c]!='O') return;
        board[r][c] = 'T';
        capture(r+1,c,board);
        capture(r-1,c,board);
        capture(r,c+1,board);
        capture(r,c-1,board);
    }
}

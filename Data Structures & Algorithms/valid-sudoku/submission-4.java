class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    char tmp = board[i][j];
                    board[i][j] = '.';
                    if(!isValid(i,j,board,tmp)) return false;
                    board[i][j] = tmp;
                }
            }
        }
        return true;
    }

    private boolean isValid(int r, int c, char[][] board, char ch){
        for(int i=0;i<9;i++){
            if(board[r][i]==ch) return false;
            if(board[i][c]==ch) return false;
            if(board[3*(r/3)+(i/3)][3*(c/3)+(i%3)]==ch) return false;
        }
        return true;
    }
}

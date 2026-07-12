class Solution {

    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        backtrack(0,board,res);
        return res;
    }

    public void backtrack(int r, char[][] board, List<List<String>> res){
        if(r==board.length){
            List<String> ls = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<board[0].length;j++){
                    sb.append(board[i][j]);
                }
                ls.add(sb.toString());
            }
            res.add(ls);
            return;
        }
        for(int c=0;c<board[0].length;c++){
            if(col.contains(c) || posDiag.contains(r+c) || negDiag.contains(r-c)) continue;
            col.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);
            board[r][c] = 'Q';
            backtrack(r+1, board, res);
            col.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
            board[r][c] = '.';
        }
    }
}

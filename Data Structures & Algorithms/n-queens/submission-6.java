class Solution {

    Set<Integer> cols;
    Set<Integer> posDiag;
    Set<Integer> negDiag;

    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        this.cols = new HashSet<>();
        this.posDiag = new HashSet<>();
        this.negDiag = new HashSet<>();
        for(int i=0;i<n;i++) Arrays.fill(board[i], '.');
        List<List<String>> res = new ArrayList<>();
        backtrack(0, board, res);
        return res;
    }

    private void backtrack(int r, char[][] board, List<List<String>> res){
        if(r==board.length){
            List<String> ls = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<board.length;j++) sb.append(board[i][j]);
                ls.add(sb.toString());
            }
            res.add(ls);
            return;
        }
        for(int c=0;c<board.length;c++){
            if(cols.contains(c) || posDiag.contains(r+c) || negDiag.contains(r-c)) continue;
            cols.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);
            board[r][c] = 'Q';
            backtrack(r+1, board, res);
            cols.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
            board[r][c] = '.';
        }
    }
}

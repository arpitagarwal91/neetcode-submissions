class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList();
        String board[][] = new String[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = ".";
            }
        }
        Set<Integer> cols = new HashSet();
        Set<Integer> posDiag = new HashSet(); //r+c
        Set<Integer> negDiag = new HashSet(); //r-c
        backtrack(0, board, cols, posDiag, negDiag, res);
        return res;
    }

    public void backtrack(int r, String board[][], Set<Integer> cols,
     Set<Integer> posDiag, Set<Integer> negDiag, List<List<String>> res){
        if(r>=board.length){
            List<String> ls = new ArrayList();
            for(int j=0;j<board.length;j++){
                StringBuilder sb = new StringBuilder();
                for(int k=0;k<board.length;k++){
                    sb.append(board[j][k]);
                }
                ls.add(sb.toString());
            }
            res.add(ls);
            return;
        }
        for(int c=0;c<board.length;c++){
            if(cols.contains(c)||posDiag.contains(r+c)||negDiag.contains(r-c)) continue;
            cols.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);
            board[r][c] = "Q";
            backtrack(r+1, board, cols, posDiag, negDiag, res);
            cols.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
            board[r][c] = ".";
        }
     }
}

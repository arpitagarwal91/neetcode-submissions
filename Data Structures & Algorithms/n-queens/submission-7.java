class Solution {

    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++) Arrays.fill(board[i], '.');
        backtrack(0, board, res);
        return res;
    }

    private void backtrack(int r, char[][] board, List<List<String>> res){
        int n = board.length;
        if(r==n){
            List<String> ls = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    sb.append(board[i][j]);
                }
                ls.add(sb.toString());
            }
            res.add(ls);
            return;
        }
        for(int c=0;c<n;c++){
            if(col.contains(c) || posDiag.contains(r+c)|| negDiag.contains(r-c)) continue;
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

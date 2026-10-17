class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean visit[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(i, j, board, 0, word, visit)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, char[][] board, int k, String word, boolean visit[][]){
        if(k==word.length()) return true;
        if(r<0||c<0||r==board.length||c==board[0].length||visit[r][c]||board[r][c]!=word.charAt(k)) return false;
        visit[r][c] = true;
        boolean res = dfs(r+1, c, board, k+1, word, visit) ||
                      dfs(r-1, c, board, k+1, word, visit) ||
                      dfs(r, c+1, board, k+1, word, visit) ||
                      dfs(r, c-1, board, k+1, word, visit);
        visit[r][c] = false;
        return res;
    }
}

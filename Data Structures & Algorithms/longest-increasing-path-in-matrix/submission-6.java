class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean visit[][] = new boolean[m][n];
        int dp[][] = new int[m][n];
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]){
                    dp[i][j] = dfs(i, j, matrix, visit, -1, dp);
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    private int dfs(int r, int c, int[][] matrix, boolean visit[][], int prevValue, int dp[][]){
        if(r<0||c<0||r==matrix.length||c==matrix[0].length||matrix[r][c]<=prevValue) return 0;
        if(visit[r][c]) return dp[r][c];
        visit[r][c] = true;
        int up = dfs(r-1, c, matrix, visit, matrix[r][c], dp);
        int below = dfs(r+1, c, matrix, visit, matrix[r][c], dp);
        int left = dfs(r, c-1, matrix, visit, matrix[r][c], dp);
        int right = dfs(r, c+1, matrix, visit, matrix[r][c], dp);
        dp[r][c] = 1+Math.max(Math.max(up, below),Math.max(left, right));
        return dp[r][c];
    }
}

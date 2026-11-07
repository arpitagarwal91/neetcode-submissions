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
                    res = Math.max(res, dfs(i, j, matrix, visit, dp, -1));
                }
            }
        }
        return res;
    }

    private int dfs(int r, int c, int[][] matrix, boolean visit[][], int[][] dp, int prev){
        if(r<0||c<0||r==dp.length||c==dp[0].length||matrix[r][c]<=prev) return 0;
        if(visit[r][c]) return dp[r][c];
        visit[r][c] = true;
        int up = dfs(r-1, c, matrix, visit, dp, matrix[r][c]);
        int down = dfs(r+1, c, matrix, visit, dp, matrix[r][c]);
        int left = dfs(r, c-1, matrix, visit, dp, matrix[r][c]);
        int right = dfs(r, c+1, matrix, visit, dp, matrix[r][c]);
        return dp[r][c] = 1+Math.max(Math.max(up, down), Math.max(left, right));
    }
}

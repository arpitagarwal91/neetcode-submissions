class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        boolean visit[][] = new boolean[m][n];
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]){
                    res = Math.max(res, dfs(i,j,matrix,visit,dp,-1));
                }
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return res;
    }

    private int dfs(int r, int c, int[][] matrix, boolean visit[][], int dp[][], int prev){
        if(r<0||c<0||r==dp.length||c==dp[0].length||matrix[r][c]<=prev) return 0;
        if(visit[r][c]) return dp[r][c];
        visit[r][c] = true;
        prev = matrix[r][c];
        dp[r][c] = 1 + Math.max(Math.max(dfs(r+1, c, matrix, visit, dp, prev)
                    , dfs(r-1, c, matrix, visit, dp, prev)),
                    Math.max(dfs(r, c+1, matrix, visit, dp, prev),
                    + dfs(r, c-1, matrix, visit, dp, prev)));
        return dp[r][c];
    }
}

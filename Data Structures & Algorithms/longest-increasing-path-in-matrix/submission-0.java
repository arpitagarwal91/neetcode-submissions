class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        boolean visit[][] = new boolean[matrix.length][matrix[0].length];
        int res = Integer.MIN_VALUE;
        int prev = res;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                res = Math.max(res, dfs(i,j,matrix,dp,visit,prev));
            }
        }
        return res;
    }

    public int dfs(int r, int c, int matrix[][],
     int dp[][], boolean visit[][], int prev){
        if(r<0||c<0||r==dp.length||c==dp[0].length||matrix[r][c]<=prev) return 0;
        if(visit[r][c]) return dp[r][c];
        visit[r][c] = true;
        dp[r][c] = 1 + Math.max(Math.max(dfs(r+1,c,matrix,dp,visit,matrix[r][c]),
        dfs(r-1,c,matrix,dp,visit,matrix[r][c])),
        Math.max(dfs(r,c+1,matrix,dp,visit,matrix[r][c]),
        dfs(r,c-1,matrix,dp,visit,matrix[r][c])));
        return dp[r][c];
    }
}

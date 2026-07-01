class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visit[][] = new boolean[m][n];
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j] && grid[i][j]==1){
                    res = Math.max(res, dfs(i,j,grid,visit));
                }
            }
        }
        return res;
    }

    public int dfs(int r, int c, int[][] grid, boolean[][] visit){
        if(r<0||c<0||r==grid.length||c==grid[0].length||visit[r][c]||grid[r][c]==0) return 0;
        visit[r][c] = true;
        return 1+dfs(r+1,c,grid,visit)
                +dfs(r-1,c,grid,visit)
                +dfs(r,c+1,grid,visit)
                +dfs(r,c-1,grid,visit);
    }
}

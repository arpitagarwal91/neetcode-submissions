class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        boolean visit[][] = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visit[i][j] && grid[i][j]==1){
                    res = Math.max(res, dfs(i,j,visit,grid));
                }
            }
        }
        return res;
    }

    public int dfs(int r, int c, boolean visit[][], int[][] grid){
        if(r<0||c<0||r==grid.length||c==grid[0].length||visit[r][c]||grid[r][c]==0) return 0;
        visit[r][c] = true;
        return 1+dfs(r+1,c,visit,grid)+dfs(r-1,c,visit,grid)+dfs(r,c+1,visit,grid)+dfs(r,c-1,visit,grid);
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        boolean visit[][] = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                res = Math.max(res, dfs(i, j, grid, visit));
            }
        }
        return res;
    }

    public int dfs(int row, int col, int grid[][], boolean visit[][]){
        if(row<0||col<0||row>grid.length-1||col>grid[0].length-1||visit[row][col]||grid[row][col]==0) return 0;
        visit[row][col] = true;
        return 1+dfs(row+1, col, grid, visit)+dfs(row-1, col, grid, visit)+dfs(row, col-1, grid, visit)+dfs(row, col+1, grid, visit);
    }
}

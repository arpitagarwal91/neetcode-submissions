class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visit[][] = new boolean[m][n];
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j] && grid[i][j]=='1'){
                    dfs(i,j,grid,visit);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int r, int c, char[][] grid, boolean visit[][]){
        if(r<0||c<0||r==grid.length||c==grid[0].length||visit[r][c]||grid[r][c]=='0') return;
        visit[r][c] = true;
        dfs(r+1, c, grid, visit);
        dfs(r-1, c, grid, visit);
        dfs(r, c+1, grid, visit);
        dfs(r, c-1, grid, visit);
    }
}

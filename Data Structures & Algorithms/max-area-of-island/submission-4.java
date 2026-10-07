class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean visit[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]) res = Math.max(res, getArea(i,j,grid,visit));
            }
        }
        return res;
    }

    private int getArea(int r, int c, int[][] grid, boolean visit[][]){
        if(r<0||c<0||r==grid.length||c==grid[0].length||visit[r][c]||grid[r][c]==0) return 0;
        visit[r][c] = true;
        return 1+getArea(r+1, c, grid, visit)
                +getArea(r-1, c, grid, visit)
                +getArea(r, c+1, grid, visit)
                +getArea(r, c-1, grid, visit);
    }
}

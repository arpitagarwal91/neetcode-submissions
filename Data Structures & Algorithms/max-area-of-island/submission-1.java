class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    res = Math.max(res, bfs(i,j,grid));
                }
            }
        }
        return res;
    }
    int dirs[][] = {{-1,0},{1,0},{0,1},{0,-1}};
    public int bfs(int r, int c, int grid[][]){
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{r,c});
        int maxArea = 1;
        grid[r][c] = 0;
        while(q.size()>0){
            int ele[] = q.poll();
            for(int dir[]:dirs){
                int row = ele[0]+dir[0];
                int col = ele[1]+dir[1];
                if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]==1){
                    q.add(new int[]{row, col});
                    grid[row][col] = 0;
                    maxArea++;
                }
            }
        }
        return maxArea;
    }

}

class Solution {
    private int[][] dirs = {{1, 0}, {-1, 0}, 
                                  {0, 1}, {0, -1}};
    int INF = Integer.MAX_VALUE;
    public void islandsAndTreasure(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==INF){
                    grid[i][j] = bfs(i,j,grid);
                }
            }
        }
    }

    public int bfs(int r, int c, int grid[][]){
        boolean visit[][] = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{r,c});
        visit[r][c] = true;
        int steps = 0;
        while(q.size()>0){
            for(int i=q.size();i>0;i--){
                int ele[] = q.poll();
                if(grid[ele[0]][ele[1]]==0) return steps;
                for(int dir[]:dirs){
                    int row = dir[0]+ele[0];
                    int col = dir[1]+ele[1];
                    if(row>=0&&col>=0&&row<grid.length&&col<grid[0].length&&!visit[row][col]&&grid[row][col]!=-1){
                        visit[row][col] = true;
                        q.add(new int[]{row,col});
                    }
                }
            }
            steps++;
        }
        return INF;
    }
}

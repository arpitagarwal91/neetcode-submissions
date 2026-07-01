class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean visit[][] = new boolean[row][col];
        Queue<int[]> q = new LinkedList<int[]>();
        int dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});
                    visit[i][j] = true;
                }
            }
        }

        while(q.size()>0){
            int ele[] = q.poll();
            for(int dir[]:dirs){
                int r = ele[0]+dir[0];
                int c = ele[1]+dir[1];
                if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && !visit[r][c] && grid[r][c]!=-1){
                    grid[r][c] = 1+grid[ele[0]][ele[1]];
                    visit[r][c] = true;
                    q.add(new int[]{r,c}); 
                }
            }
        }
    }
}

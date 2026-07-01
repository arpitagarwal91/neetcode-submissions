class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        LinkedList<Integer[]> rotten = new LinkedList();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2) rotten.add(new Integer[]{i, j});
            }
        }
        return bfs(grid, rotten, fresh, visited);
    }

    public int bfs(int grid[][], LinkedList<Integer[]> rotten, int fresh, boolean visited[][]){
        int t = 0;
        int dirs[][] = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
        while(fresh>0 && rotten.size()>0){
            int len = rotten.size();
            for(int i=0;i<len;i++){
                Integer[] element = rotten.poll();
                for(int dir[]:dirs){
                    int r = element[0]+dir[0];
                    int c = element[1]+dir[1];
                    if(r<0 || r>grid.length-1 || c <0 || c>grid[0].length-1 || visited[r][c] || grid[r][c] != 1) continue;
                    grid[r][c] = 2;
                    visited[r][c] = true;
                    fresh--;
                    rotten.add(new Integer[]{r,c});
                }
            }
            t++;
        }
        return fresh == 0 ? t : -1;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<int[]>();
        int dirs[][] = {{1,0},{0,1},{0,-1},{-1,0}};
        int time = 0;
        int fresh = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1) fresh++;
            }
        }

        while(fresh>0 && q.size()>0){
            int len = q.size();
            for(int i=0;i<len;i++){
                int ele[] = q.poll();
                for(int dir[]:dirs){
                    int r = ele[0]+dir[0];
                    int c = ele[1]+dir[1];
                    if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]==1){
                        grid[r][c] = 2;
                        q.add(new int[]{r,c});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh==0 ? time : -1;
    }
}

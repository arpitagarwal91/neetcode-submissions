class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visit[][] = new boolean[m][n];
        int fresh = 0;
        Queue<int[]> q = new LinkedList<int[]>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j]==2) q.add(new int[]{i,j});
            }
        }
        int t = 0;
        int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty() && fresh>0){
            int len = q.size();
            for(int i=0;i<len;i++){
                int ele[] = q.poll();
                for(int dir[]:dirs){
                    int r = dir[0]+ele[0];
                    int c = dir[1]+ele[1];
                    if(r>=0 && c>=0 && r<m && c<n && !visit[r][c] && grid[r][c]==1){
                        grid[r][c] = 2;
                        visit[r][c] = true;
                        fresh--;
                        q.add(new int[]{r,c});
                    }
                }
            }
            t++;
        }
        return fresh==0 ? t : -1;
    }
}

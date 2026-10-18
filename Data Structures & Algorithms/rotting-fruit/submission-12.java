class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2) q.add(new int[]{i,j});
            }
        }

        int dirs[][] = {{1,0},{0,1},{0,-1},{-1,0}};
        int t = 0;
        while(!q.isEmpty() && fresh>0){
            t++;
            int len = q.size();
            for(int i=0;i<len;i++){
                int ele[] = q.poll();
                for(int dir[]:dirs){
                    int r = ele[0]+dir[0];
                    int c = ele[1]+dir[1];
                    if(r<0||c<0||r==m||c==n||grid[r][c]!=1) continue;
                    grid[r][c] = 2;
                    q.add(new int[]{r,c});
                    fresh--;
                }
            }
        }
        return fresh==0 ? t : -1;
    }
}

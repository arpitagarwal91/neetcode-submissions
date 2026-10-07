class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2) q.add(new int[]{i,j});
            }
        }
        int t = 0;
        int dirs[][] = {{0,1},{1,0},{-1,0},{0,-1}};
        while(fresh>0 && !q.isEmpty()){
            int len = q.size();
            if(fresh==0) return t;
            t++;
            for(int i=0;i<len;i++){
                int ele[] = q.poll();
                for(int dir[]:dirs){
                    int r = ele[0]+dir[0];
                    int c = ele[1]+dir[1];
                    if(r<0||c<0||r==m||c==n||grid[r][c]!=1) continue;
                    grid[r][c] = 2;
                    fresh--;
                    q.add(new int[]{r,c});
                }
            }
        }
        return fresh==0 ? t : -1;
    }
}

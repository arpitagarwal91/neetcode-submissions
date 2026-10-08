class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m  = grid.length;
        int n = grid[0].length;
        boolean visit[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) {
                    q.add(new int[]{i,j});
                    visit[i][j] = true;
                }
            }
        }
        int level = 0;
        int dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int len = q.size();
            level++;
            for(int i=0;i<len;i++){
                int ele[] = q.poll();
                for(int dir[]:dirs){
                    int r = ele[0]+dir[0];
                    int c = ele[1]+dir[1];
                    if(r<0||c<0||r==m||c==n||visit[r][c]||grid[r][c]==-1) continue;
                    grid[r][c] = level;
                    visit[r][c] = true;
                    q.add(new int[]{r,c});
                }
            }
        }
    }
}

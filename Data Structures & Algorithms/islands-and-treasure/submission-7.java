class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visit[][] = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) {
                    q.add(new int[]{i, j, 0});
                    visit[i][j] = true;
                }
            }
        }

        int dirs[][] =  {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int ele[] = q.poll();
            for(int dir[]:dirs){
                int r = dir[0]+ele[0];
                int c = dir[1]+ele[1];
                if(r<0||c<0||r==m||c==n||visit[r][c]||grid[r][c]!=Integer.MAX_VALUE) continue;
                grid[r][c] = 1 + ele[2];
                q.add(new int[]{r, c, grid[r][c]});
                visit[r][c] = true;
            }
        }
    }
}

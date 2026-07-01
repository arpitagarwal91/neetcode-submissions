class Solution {
    public void islandsAndTreasure(int[][] grid) {
        boolean visit[][] = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});
                    visit[i][j] = true;
                }
            }
        }
        int dirs[][] = {{0,-1},{-1,0},{1,0},{0,1}};
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                int ele[] = q.poll();
                for(int dir[]:dirs){
                    int r = dir[0]+ele[0];
                    int c = dir[1]+ele[1];
                    if(r<0||c<0||r==grid.length||c==grid[0].length||grid[r][c]==-1||visit[r][c]) continue;
                    grid[r][c] = Math.min(grid[r][c], 1+grid[ele[0]][ele[1]]);
                    q.add(new int[]{r,c});
                    visit[r][c] = true;
                }
            }
        }
    }
}

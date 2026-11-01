class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean visit[][] = new boolean[n][n];
        int dp[][] = new int[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        pq.add(new int[]{0, 0, grid[0][0]});
        visit[0][0] = true;
        int dirs[][] = {{1,0},{0,1},{-1, 0},{0,-1}};

        while(!pq.isEmpty()){
            int ele[] = pq.poll();
            if(ele[0]==n-1 && ele[1]==n-1) return ele[2];
            for(int dir[]:dirs){
                int r = dir[0]+ele[0];
                int c = dir[1]+ele[1];
                if(r<0||c<0||r==n||c==n||visit[r][c]) continue;
                visit[r][c] = true;
                pq.add(new int[]{r, c, Math.max(ele[2], grid[r][c])});
            }
        }
        return -1;
    }
}

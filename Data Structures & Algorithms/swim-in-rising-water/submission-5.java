class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        pq.add(new int[]{0, 0, grid[0][0]});
        boolean visit[][] = new boolean[n][n];

        int dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!pq.isEmpty()){
            int ele[] = pq.poll();
            if(ele[0]==n-1 && ele[1]==n-1) return ele[2];
            visit[ele[0]][ele[1]] = true;
            for(int dir[]:dirs){
                int r = ele[0]+dir[0];
                int c = ele[1]+dir[1];
                if(r<0||c<0||r==n||c==n||visit[r][c]) continue;
                pq.add(new int[]{r, c, Math.max(grid[r][c], ele[2])});
            }
        }
        return -1;
    }
}

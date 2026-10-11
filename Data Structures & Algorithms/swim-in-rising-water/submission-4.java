class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visit[][] = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        pq.add(new int[]{0, 0, grid[0][0]});
        visit[0][0] = true;
        int res = 0;
        int dirs[][] = {{1,0},{0,1},{0,-1},{-1,0}};
        while(!pq.isEmpty()){
            int ele[] = pq.poll();
            res = ele[2];
            if(ele[0]==m-1 && ele[1]==n-1) return res;
            for(int dir[]:dirs){
                int r = ele[0] + dir[0];
                int c = ele[1] + dir[1];
                if(r<0||c<0||r==grid.length||c==grid[0].length||visit[r][c]) continue;
                pq.add(new int[]{r,c,Math.max(res, grid[r][c])});
                visit[r][c] = true;
            }
        }
        return res;
    }
}

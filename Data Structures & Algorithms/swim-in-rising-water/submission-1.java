class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean visit[][] = new boolean[grid.length][grid[0].length];
        int dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        visit[0][0] = true;
        pq.add(new int[]{grid[0][0], 0, 0});
        int maxHeight = 0;

        while(pq.size()>0){
            int ele[] = pq.poll();
            maxHeight = ele[0];
            if(ele[1]==grid.length-1 && ele[2]==grid[0].length-1) return maxHeight;
            for(int dir[]:dirs){
                int r = ele[1]+dir[0];
                int c = ele[2]+dir[1];
                if(r<0||c<0||r==grid.length||c==grid[0].length||visit[r][c]) continue;
                visit[r][c] = true;
                pq.add(new int[]{Math.max(maxHeight, grid[r][c]),r,c});
            }
        }
        return maxHeight;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        boolean visit[][] = new boolean[grid.length][grid[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.add(new int[]{grid[0][0], 0, 0});
        visit[0][0] = true;
        int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!pq.isEmpty()){
            int ele[] = pq.poll();
            int t = ele[0];
            if(ele[1]==grid.length-1 && ele[2]==grid[0].length-1) return t;
            for(int dir[]:dirs){
                int r = dir[0]+ele[1];
                int c = dir[1]+ele[2];
                if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && !visit[r][c]){
                    visit[r][c] = true;
                    pq.add(new int[]{Math.max(t, grid[r][c]), r, c});
                }
            }
        }
        return grid.length*grid.length;
    }
}

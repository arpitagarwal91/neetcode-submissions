class Solution {
    public int swimInWater(int[][] grid) {
        boolean visit[][] = new boolean[grid.length][grid[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.add(new int[]{grid[0][0],0,0});
        visit[0][0] = true;
        int dirs[][] = {{-1,0},{1,0},{0,1},{0,-1}};
        int maxHeight = 0;

        while(pq.size()>0){
            int ele[] = pq.poll();
            maxHeight = ele[0];
            if(ele[1]==grid.length-1 && ele[2]==grid[0].length-1) return maxHeight;
            for(int dir[]:dirs){
                int row = dir[0]+ele[1];
                int col = dir[1]+ele[2];
                if(row<0||col<0||row==grid.length||col==grid[0].length||visit[row][col]) continue;
                visit[row][col] = true;
                pq.add(new int[]{Math.max(maxHeight, grid[row][col]), row, col});
            }
        }
        return maxHeight;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        boolean visit[][] = new boolean[grid.length][grid[0].length];
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]=='1' && !visit[r][c]){
                    bfs(r, c, visit, grid);
                    res++;
                }
            }
        }
        return res;
    }

    public void bfs(int r, int c, boolean visit[][], char grid[][]){
        Queue<int[]> q = new LinkedList<int[]>();
        visit[r][c] = true;
        q.add(new int[]{r, c});
        int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};

        while(q.size()>0){
            int ele[] = q.poll();
            for(int dir[]:dirs){
                int row = ele[0]+dir[0];
                int col = ele[1]+dir[1];
                if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]=='1' && !visit[row][col]){
                    visit[row][col] = true;
                    q.add(new int[]{row, col});
                }
            }
        }
    }

    
}

class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        boolean visit[][] = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !visit[i][j]){
                    bfs(i, j, grid, visit);
                    res++;
                }
            }
        }
        return res;
    }

    public void bfs(int i, int j, char grid[][], boolean visit[][]){
        LinkedList<Integer[]> q = new LinkedList();
        q.add(new Integer[]{i, j}); 
        visit[i][j] = true;
        while(q.size()>0){
            Integer[] element = q.poll();
            int dirs[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
            for(int dir[]: dirs){
                int r = element[0]+dir[0];
                int c = element[1]+dir[1];
                if(r<0||c<0||r>=grid.length||c>=grid[0].length||visit[r][c]||grid[r][c]=='0') continue;
                q.add(new Integer[]{r, c});
                visit[r][c] = true;
            }
        }
    }
}

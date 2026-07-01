class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Deque<Integer[]> q = new ArrayDeque<Integer[]>();
        boolean visit[][] = new boolean[rows][cols];
        int fresh = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    q.add(new Integer[]{i,j});
                    visit[i][j] = true;
                }
                if(grid[i][j]==1) fresh++;
            }
        }
        int time = 0;
        int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        while(q.size()>0 && fresh>0){
            time++;
            int len = q.size();
            for(int i=0;i<len;i++){
                Integer ele[] = q.pollFirst();
                for(int dir[]:dirs){
                    int r = ele[0]+dir[0];
                    int c = ele[1]+dir[1];
                    if(r<0||c<0||r>=rows||c>=cols||grid[r][c]!=1) continue;
                    q.addLast(new Integer[]{r,c});
                    fresh--;
                    grid[r][c]=2;
                }
            }
        }
        
        return fresh==0 ? time : -1;
    }

    public int bfs(int grid[][], LinkedList<Integer[]> rotten, int fresh, boolean visited[][]){
        int t = 0;
        int dirs[][] = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
        while(fresh>0 && rotten.size()>0){
            for(int i=0;i<rotten.size();i++){
                Integer[] element = rotten.poll();
                for(int dir[]:dirs){
                    int r = element[0]+dir[0];
                    int c = element[1]+dir[1];
                    if(r<0 || r>grid.length-1 || c <0 || c>grid[0].length-1 || visited[r][c] || grid[r][c] != 1) continue;
                    grid[r][c] = 2;
                    visited[r][c] = true;
                    fresh--;
                    rotten.add(new Integer[]{r,c});
                }
            }
            t++;
        }
        return fresh == 0 ? t : -1;
    }
}

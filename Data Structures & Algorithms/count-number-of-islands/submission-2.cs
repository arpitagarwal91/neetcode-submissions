public class Solution {
    public int NumIslands(char[][] grid) {
        int res = 0;
        int row = grid.Length;
        int col = grid[0].Length;
        bool[,] visit = new bool[row,col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!visit[i,j] && grid[i][j]=='1'){
                    bfs(i,j,visit,grid);
                    res++;
                }
            }
        }
        return res;
    }

    public void bfs(int r, int c, bool[,] visit, char[][] grid){
        Queue<int[]> q = new Queue<int[]>();
        q.Enqueue(new int[]{r,c});
        int[][] dirs = new int[][]{new int[]{-1,0},new int[]{1,0},new int[]{0,-1},new int[]{0,1}};
        while(q.Count>0){
            int[] ele = q.Dequeue();
            visit[r,c] = true;
            foreach(int[] dir in dirs){
                int row = ele[0]+dir[0];
                int col = ele[1]+dir[1];
                if(row>=0&&row<grid.Length&&col>=0&&col<grid[0].Length&&!visit[row,col]&&grid[row][col]=='1'){
                    q.Enqueue(new int[]{row,col});
                    visit[row,col] = true;
                }
            }
        }
    }
}

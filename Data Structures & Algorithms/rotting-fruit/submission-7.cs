public class Solution {
    int[][] dirs = { new int[] { 0, 1 }, new int[] { 0, -1 }, new int[] { 1, 0 }, new int[] { -1, 0 } };
    public int OrangesRotting(int[][] grid) {
        int t = 0;
        int fresh = 0;
        Queue<int[]> q = new Queue<int[]>();
        for(int i=0;i<grid.Length;i++){
            for(int j=0;j<grid[0].Length;j++){
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2) q.Enqueue(new int[]{i,j});
            }
        }

        while(fresh>0 && q.Count>0){
            for(int i=q.Count;i>0;i--){
                int []ele = q.Dequeue();
                foreach(int []dir in dirs){
                    int row = ele[0]+dir[0];
                    int col = ele[1]+dir[1];
                    if(row>=0 && col>=0 && row<grid.Length && col<grid[0].Length && grid[row][col]==1){
                        grid[row][col] = 2;
                        fresh--;
                        q.Enqueue(new int[]{row, col});
                    }
                }
            }
            t++;
        }
        return fresh==0?t:-1;
    }
}

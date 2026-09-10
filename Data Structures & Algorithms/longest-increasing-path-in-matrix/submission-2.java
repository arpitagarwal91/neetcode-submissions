class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean visit[][] = new boolean[m][n];
        int path[][] = new int[m][n];
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]) res = Math.max(res, getLongestPath(i,j,-1,matrix,visit,path));
            }
        }
        return res;
    }

    private int getLongestPath(int r, int c, int prev, int[][] grid, boolean[][] visit, int[][] path){
        if(r<0||c<0||r==grid.length||c==grid[0].length||prev>=grid[r][c]) return 0;
        if(visit[r][c]) return path[r][c];
        visit[r][c] = true;
        int top = getLongestPath(r-1, c, grid[r][c], grid, visit, path);
        int bottom = getLongestPath(r+1, c, grid[r][c], grid, visit, path);
        int left = getLongestPath(r, c-1, grid[r][c], grid, visit, path);
        int right = getLongestPath(r, c+1, grid[r][c], grid, visit, path);
        return path[r][c] = 1 + Math.max(Math.max(top, bottom), Math.max(left, right));
    }
}

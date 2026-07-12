class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean visit[][] = new boolean[m][n];
        int path[][] = new int[m][n];
        int res = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]){
                    res = Math.max(res, dfs(i,j,-1,matrix,visit,path));
                }
            }
        }
        return res;
    }

    public int dfs(int r, int c, int prevMax, int[][] matrix, boolean visit[][], int path[][]){
        if(r<0||c<0||r==matrix.length||c==matrix[0].length||matrix[r][c]<=prevMax) return 0;
        if(visit[r][c]) return path[r][c];
        visit[r][c] = true;
        path[r][c] = 1+Math.max(Math.max(
                dfs(r-1,c,matrix[r][c],matrix,visit,path), dfs(r+1,c,matrix[r][c],matrix,visit,path)),
                Math.max(dfs(r,c-1,matrix[r][c],matrix,visit,path), dfs(r,c+1,matrix[r][c],matrix,visit,path)));
        return path[r][c];
    }
}

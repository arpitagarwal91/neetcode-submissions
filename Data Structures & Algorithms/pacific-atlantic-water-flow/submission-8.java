class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean pac[][] = new boolean[m][n];
        boolean atl[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(i, 0, pac, heights, -1);
            dfs(i, n-1, atl, heights, -1);
        }
        for(int j=0;j<n;j++){
            dfs(0, j, pac, heights, -1);
            dfs(m-1, j, atl, heights, -1);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean visit[][], int heights[][], int prevH){
        if(r<0||c<0||r==visit.length||c==visit[0].length||visit[r][c]||heights[r][c]<prevH) return;
        visit[r][c] = true;
        prevH = heights[r][c]; // Forgot to update to latest height before further dfs.
        dfs(r+1, c, visit, heights, prevH);
        dfs(r-1, c, visit, heights, prevH);
        dfs(r, c+1, visit, heights, prevH);
        dfs(r, c-1, visit, heights, prevH);
    }
}

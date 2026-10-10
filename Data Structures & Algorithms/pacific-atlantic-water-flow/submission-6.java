class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean pac[][] = new boolean[m][n];
        boolean atl[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(i, 0, pac, heights, -1);
            dfs(i, n-1, atl, heights, -1);
        }
        for(int i=0;i<n;i++){
            dfs(0, i, pac, heights, -1);
            dfs(m-1, i, atl, heights, -1);
        }
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) if(pac[i][j] && atl[i][j]) res.add(Arrays.asList(i, j));
        return res;
    }

    private void dfs(int r, int c, boolean visit[][], int[][] heights, int prev){
        if(r<0||c<0||r==heights.length||c==heights[0].length||visit[r][c]||heights[r][c]<prev) return;
        visit[r][c] = true;
        dfs(r+1, c, visit, heights, heights[r][c]);
        dfs(r-1, c, visit, heights, heights[r][c]);
        dfs(r, c+1, visit, heights, heights[r][c]);
        dfs(r, c-1, visit, heights, heights[r][c]);
    }
}

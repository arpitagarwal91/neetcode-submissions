class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean pac[][] = new boolean[m][n];
        boolean atl[][] = new boolean[m][n];
        for(int r=0;r<m;r++){
            dfs(r, 0, pac, heights, heights[r][0]);
            dfs(r, n-1, atl, heights, heights[r][n-1]);
        }
        for(int c=0;c<n;c++){
            dfs(0, c, pac, heights, heights[0][c]);
            dfs(m-1, c, atl, heights, heights[m-1][c]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pac[i][j] && atl[i][j]){
                    List<Integer> ls = new ArrayList<>();
                    ls.add(i);
                    ls.add(j);
                    res.add(ls);
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean visit[][], int heights[][], int prevHeight){
        if(r<0||c<0||r==heights.length||c==heights[0].length||prevHeight>heights[r][c]||visit[r][c]){
            return;
        }
        visit[r][c] = true;
        dfs(r+1, c, visit, heights, heights[r][c]);
        dfs(r-1, c, visit, heights, heights[r][c]);
        dfs(r, c+1, visit, heights, heights[r][c]);
        dfs(r, c-1, visit, heights, heights[r][c]);
    }
}

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean pac[][] = new boolean[m][n];
        boolean atl[][] = new boolean[m][n];
        for(int i=0;i<n;i++){
            dfs(0, i, heights[0][i], pac, heights);
            dfs(m-1, i, heights[m-1][i], atl, heights);
        }
        for(int i=0;i<m;i++){
            dfs(i, 0, heights[i][0], pac, heights);
            dfs(i, n-1, heights[i][n-1], atl, heights);
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

    public void dfs(int r, int c, int k, boolean ocean[][], int[][] heights){
        if(r<0||c<0||r==heights.length||c==heights[0].length||ocean[r][c]||heights[r][c]<k) return;
        ocean[r][c] = true;
        dfs(r+1, c, heights[r][c], ocean, heights);
        dfs(r-1, c, heights[r][c], ocean, heights);
        dfs(r, c+1, heights[r][c], ocean, heights);
        dfs(r, c-1, heights[r][c], ocean, heights);
    }
}

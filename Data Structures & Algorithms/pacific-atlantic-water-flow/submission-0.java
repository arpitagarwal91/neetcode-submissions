class Solution {
    List<List<Integer>> res = new ArrayList();
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean pac[][] = new boolean[heights.length][heights[0].length];
        boolean atl[][] = new boolean[heights.length][heights[0].length];
        for(int i=0;i<heights.length;i++){
            dfs(i,0,pac,heights,heights[i][0]);
            dfs(i,heights[0].length-1,atl,heights,heights[i][heights[0].length-1]);
        }
        for(int i=0;i<heights[0].length;i++){
            dfs(0,i,pac,heights,heights[0][i]);
            dfs(heights.length-1,i,atl,heights,heights[heights.length-1][i]);
        }
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pac[i][j] && atl[i][j]){
                    List<Integer> ls = new ArrayList();
                    ls.add(i);
                    ls.add(j);
                    res.add(ls);
                }
            }
        }
        return res;
    }

    public void dfs(int r, int c, boolean visit[][], int heights[][], int prevHeight){
        if(r<0||c<0||r==heights.length||c==heights[0].length||visit[r][c]||heights[r][c]<prevHeight) return;
        visit[r][c] = true;
        dfs(r+1,c,visit,heights,heights[r][c]);
        dfs(r-1,c,visit,heights,heights[r][c]);
        dfs(r,c+1,visit,heights,heights[r][c]);
        dfs(r,c-1,visit,heights,heights[r][c]);
    }
}

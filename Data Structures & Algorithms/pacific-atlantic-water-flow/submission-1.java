class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList();
        boolean pac[][] = new boolean[heights.length][heights[0].length];
        boolean atl[][] = new boolean[heights.length][heights[0].length];
        for(int r=0;r<heights.length;r++){
            dfs(r, 0, pac, heights, heights[r][0]);
            dfs(r, heights[0].length-1, atl, heights, heights[r][heights[0].length-1]);
        }
        for(int c=0;c<heights[0].length;c++){
            dfs(0, c, pac, heights, heights[0][c]);
            dfs(heights.length-1, c, atl, heights, heights[heights.length-1][c]);
        }
        for(int r=0;r<heights.length;r++){
            for(int c=0;c<heights[0].length;c++){
                if(pac[r][c] && atl[r][c]) {
                    List<Integer> ls = new ArrayList<Integer>();
                    ls.add(r);
                    ls.add(c);
                    res.add(ls);
                }
            }
        }
        return res;
    }

    public void dfs(int r, int c, boolean visit[][], int heights[][], int prevHeight){
        if(r<0||c<0||r==heights.length||c==heights[0].length||visit[r][c]||heights[r][c]<prevHeight){
            return;
        }
        visit[r][c] = true;
        dfs(r+1,c,visit,heights, heights[r][c]);
        dfs(r-1,c,visit,heights, heights[r][c]);
        dfs(r,c+1,visit,heights, heights[r][c]);
        dfs(r,c-1,visit,heights, heights[r][c]);
    }
}

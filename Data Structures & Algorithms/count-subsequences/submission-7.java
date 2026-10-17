class Solution {
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length()][t.length()];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i], -1);
        return getDistinctSub(0, 0, s, t, dp);
    }

    private int getDistinctSub(int i, int j, String s, String t, int[][] dp){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j] = getDistinctSub(i+1, j+1, s, t, dp) + getDistinctSub(i+1, j, s, t, dp);
        }

        return dp[i][j] = getDistinctSub(i+1, j, s, t, dp);
    }
}

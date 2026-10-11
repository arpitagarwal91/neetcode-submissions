class Solution {
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length()+1][t.length()+1];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i], -1);
        return getAllWays(0,0,s,t, dp);
    }

    private int getAllWays(int i, int j, String s, String t, int[][] dp){
        if(j==t.length()) return 1;
        if(i==s.length() && j<t.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j] = getAllWays(i+1, j+1, s, t, dp) + getAllWays(i+1, j, s, t, dp);
        }
        else{
            return dp[i][j] = getAllWays(i+1, j, s, t, dp);
        }

    }
}

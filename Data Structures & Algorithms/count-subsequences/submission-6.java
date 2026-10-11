class Solution {
    public int numDistinct(String s, String t) {
        // int dp[][] = new int[s.length()+1][t.length()+1];
        // for(int i=0;i<dp.length;i++) Arrays.fill(dp[i], -1);
        // return getAllWays(0,0,s,t, dp);
        int dp[][] = new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length()+1;i++) dp[i][0] = 1;
        for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<t.length()+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
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

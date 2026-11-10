class Solution {
    public int numDistinct(String s, String t) {
        Integer dp[][] = new Integer[s.length()][t.length()];
        return getAllSub(0, 0, s, t, dp);
    }

    private int getAllSub(int i, int j, String s, String t, Integer dp[][]){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0; //Could not think of both base cases correctly in last attempt.
        if(dp[i][j]!=null) return dp[i][j];
        
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j] = getAllSub(i+1, j+1, s, t, dp) + getAllSub(i+1, j, s, t, dp);
        }

        return dp[i][j] = getAllSub(i+1, j, s, t, dp);
    }
}

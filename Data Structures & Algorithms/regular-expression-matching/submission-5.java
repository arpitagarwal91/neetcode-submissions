class Solution {
    public boolean isMatch(String s, String p) {
        Boolean dp[][] = new Boolean[s.length()+1][p.length()+1];
        return isMatch(0,0,s,p,dp);
    }

    private boolean isMatch(int i, int j, String s1, String s2, Boolean dp[][]){
        if(i>=s1.length() && j>=s2.length()) return true;
        if(j>=s2.length()) return false;
        if(dp[i][j]!=null) return dp[i][j];

        boolean match = (i<s1.length()) && (s1.charAt(i)==s2.charAt(j) || s2.charAt(j)=='.');
        if(j+1<s2.length() && s2.charAt(j+1)=='*'){
            return  dp[i][j] = (match && isMatch(i+1, j, s1, s2, dp)) || isMatch(i, j+2, s1, s2, dp);
        }
        if(match){
            return  dp[i][j] = isMatch(i+1, j+1, s1, s2, dp);
        }
        return  dp[i][j] = false;
    }
}

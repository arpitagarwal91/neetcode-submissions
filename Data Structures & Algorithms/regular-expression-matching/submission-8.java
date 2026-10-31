class Solution {
    public boolean isMatch(String s, String p) {
        Boolean dp[][] = new Boolean[s.length()+1][p.length()+1];
        return isMatch(0, 0, s, p, dp);
    }

    private boolean isMatch(int i, int j, String s, String p, Boolean dp[][]){
        if(i>=s.length() && j>=p.length()) return true;
        // if(i>=s.length()){
        //     for(int k=j;k<p.length();k++){
        //         System.out.println(p.charAt(k));
        //         if(p.charAt(k)!='*') return false;
        //     }
        //     return true;
        // }
        if(j>=p.length()) return false;
        if(dp[i][j]!=null) return dp[i][j];
        boolean match = i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            return dp[i][j] = (match && isMatch(i+1, j, s, p, dp)) || isMatch(i, j+2, s, p, dp);
        }
        if(match){
            return dp[i][j] = isMatch(i+1, j+1, s, p, dp);
        }
        return dp[i][j] = false;
    }
}

class Solution {
    public int numDistinct(String s, String t) {
        Integer dp[][] = new Integer[s.length()][t.length()];
        return countAllSub(0, 0, s, t, dp);
    }

    private int countAllSub(int i, int j, String s1, String s2, Integer dp[][]){
        if(j==s2.length()) return 1;
        if(i==s1.length()) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = countAllSub(i+1, j+1, s1, s2, dp) + countAllSub(i+1, j, s1, s2, dp);
        }
        return dp[i][j] = countAllSub(i+1, j, s1, s2, dp);
    }
}

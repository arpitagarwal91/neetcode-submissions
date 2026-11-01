class Solution {
    public int numDecodings(String s) {
        Integer dp[] = new Integer[s.length()];
        return getAllWays(0, s, dp);
    }

    private int getAllWays(int i, String s, Integer dp[]){
        if(i==s.length()) return 1;
        if(s.charAt(i)=='0') return 0;
        if(dp[i]!=null) return dp[i];

        int total = getAllWays(i+1, s, dp);
        if(i+1<s.length() && (s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<'7')))
        total += getAllWays(i+2, s, dp);
        return dp[i] = total;
    }
}

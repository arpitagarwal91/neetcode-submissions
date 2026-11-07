class Solution {
    public int numDecodings(String s) {
        Integer dp[] = new Integer[s.length()];
        return getAllWays(0, s, dp);
    }

    private int getAllWays(int idx, String s, Integer dp[]){
        if(idx==s.length()) return 1;
        if(s.charAt(idx)=='0') return 0;
        if(dp[idx]!=null) return dp[idx];

        int res = getAllWays(idx+1, s, dp);
        if(idx+1<s.length() && (s.charAt(idx)=='1' ||(s.charAt(idx)=='2' && s.charAt(idx+1)<'7'))){
            res += getAllWays(idx+2, s, dp);
        }
        return dp[idx] = res;
    }
}

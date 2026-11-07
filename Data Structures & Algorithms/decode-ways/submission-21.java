class Solution {
    public int numDecodings(String s) {
        // Integer dp[] = new Integer[s.length()];
        // return getAllWays(0, s, dp);
        if(s.charAt(0)==0) return 0;
        int dp[] = new int[s.length()+1];
        dp[s.length()] = 1;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='0') {
                dp[i] = 0;
                continue;
            }

            int res = dp[i+1];
            if(i+1<s.length() && (s.charAt(i)=='1' ||(s.charAt(i)=='2' && s.charAt(i+1)<'7'))){
                res += dp[i+2];
            }
            dp[i] = res;
        }
        return dp[0];
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

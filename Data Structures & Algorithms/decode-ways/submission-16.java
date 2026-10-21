class Solution {
    public int numDecodings(String s) {
        // int dp[] = new int[s.length()];
        // Arrays.fill(dp, -1);
        // return findAllWays(0, s, dp);
        int dp[] = new int[s.length()+1];
        dp[s.length()] = 1;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='0') {
                dp[i] = 0;
                continue;
            }
            int ways = dp[i+1];
            if(i+1<s.length() && (s.charAt(i)=='1' ||(s.charAt(i)=='2' && s.charAt(i+1)<'7'))){
                ways += dp[i+2];
            }
            dp[i] = ways;
        }
        return dp[0];
    }

    private int findAllWays(int idx, String s, int[] dp){
        if(idx==s.length()) return 1;
        if(s.charAt(idx)=='0') return 0;
        if(dp[idx]!=-1) return dp[idx];

        int ways = findAllWays(idx+1, s, dp);
        if(idx+1<s.length() && (s.charAt(idx)=='1' ||(s.charAt(idx)=='2' && s.charAt(idx+1)<'7'))){
            ways += findAllWays(idx+2, s, dp);
        }
        return dp[idx] = ways;
    }
}

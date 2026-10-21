class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return findAllWays(0, s, dp);
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

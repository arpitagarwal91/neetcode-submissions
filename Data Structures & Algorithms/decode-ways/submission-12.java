class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return getAllWays(0, s, dp);
    }

    private int getAllWays(int idx, String s, int[] dp){
        if(idx==s.length()) return 1;
        if(s.charAt(idx)=='0') return 0;
        if(dp[idx]!=-1) return dp[idx];

        int res = getAllWays(idx+1, s, dp);
        char c = s.charAt(idx);
        if(idx+1<s.length() && (c=='1' ||(c=='2' && s.charAt(idx+1)<'7'))){
            res += getAllWays(idx+2, s, dp);
        }
        return dp[idx] = res;
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> valid = new HashSet<>(wordDict);
        int t = 0;
        for(String word:wordDict) {
            t = Math.max(t, word.length());
        }
        Boolean dp[] = new Boolean[s.length()];
        return getWorkBreakPossible(0, s, valid, dp, t);
    }

    private boolean getWorkBreakPossible(int idx, String s, Set<String> valid, Boolean[] dp, int t){
        if(idx==s.length()) return true;
        if(dp[idx]!=null) return dp[idx];
        for(int i=idx;i<s.length();i++){
            if(valid.contains(s.substring(idx, i+1))){
                if(getWorkBreakPossible(i+1, s, valid, dp, t)) return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
}

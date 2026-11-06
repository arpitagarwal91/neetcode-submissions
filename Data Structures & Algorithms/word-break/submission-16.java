class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean dp[] = new Boolean[s.length()];
        Set<String> valid = new HashSet(wordDict);
        return isWordBreakPossible(0, s, valid, dp);
    }

    private boolean isWordBreakPossible(int idx, String s, Set<String> valid, Boolean dp[]){
        if(idx==s.length()) return true;
        if(dp[idx]!=null) return dp[idx];
        for(int i=idx;i<s.length();i++){
            String str = s.substring(idx, i+1);
            if(valid.contains(str)){
                if(isWordBreakPossible(i+1, s, valid, dp)) return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> valid = new HashSet<>(wordDict);
        Boolean dp[] = new Boolean[s.length()];
        return isPossibleBreak(0, s, valid, dp);
    }

    private boolean isPossibleBreak(int idx, String s, Set<String> valid, Boolean dp[]){
        if(idx==s.length()) return true;
        if(dp[idx]!=null) return dp[idx];

        for(int i=idx;i<s.length();i++){
            if(valid.contains(s.substring(idx, i+1))){
                if(isPossibleBreak(i+1, s, valid, dp)) return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
}

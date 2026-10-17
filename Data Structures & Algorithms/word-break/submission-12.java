class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> valid = new HashSet<>(wordDict);
        Boolean dp[] = new Boolean[s.length()];
        return isPossible(0, s, valid, dp);
    }

    private boolean isPossible(int idx, String s, Set<String> valid, Boolean dp[]){
        if(idx==s.length()) return true;
        if(dp[idx]!=null) return dp[idx];
        for(int i=idx;i<s.length();i++){
            String str = s.substring(idx, i+1);
            if(valid.contains(str)){
                if(isPossible(i+1, s, valid, dp)) return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
}

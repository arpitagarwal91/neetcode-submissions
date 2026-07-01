class Solution {
    public boolean isMatch(String s, String p) {
        Map<String, Boolean> dp = new HashMap();
        return dfs(0,0,s,p,dp);
    }

    public boolean dfs(int i, int j, String s, String p, Map<String, Boolean> dp){
        String key = i+"-"+j;
        if(dp.containsKey(key)) return dp.get(key);
        if(i>=s.length() && j>=p.length()) return true;
        if(j>=p.length()) return false;
        boolean match = i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            dp.put(key, dfs(i,j+2,s,p,dp)||(match && dfs(i+1,j,s,p,dp)));
            return dp.get(key);
        }
        if(match){
            dp.put(key, dfs(i+1,j+1,s,p,dp));
            return dp.get(key);
        }
        dp.put(key, false);
        return dp.get(key);
    }
}

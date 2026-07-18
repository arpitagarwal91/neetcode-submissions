class Solution {
    public boolean isMatch(String s, String p) {
        Map<String, Boolean> cache = new HashMap<>();
        return dfs(0,0,s,p,cache);
    }

    public boolean dfs(int i, int j, String s, String p, Map<String, Boolean> cache){
        if(cache.containsKey(i+"-"+j)) return cache.get(i+"-"+j);
        if(i>=s.length() && j>=p.length()) return true;
        if(j>=p.length()) return false;

        boolean match = (i<s.length()) && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'); //Second most important part.
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            cache.put(i+"-"+j, dfs(i, j+2, s, p, cache) || (match && dfs(i+1, j, s, p, cache))); //Most important part of the Question.
            return cache.get(i+"-"+j);
        }

        if(match){
            cache.put(i+"-"+j, dfs(i+1, j+1, s, p, cache));
            return cache.get(i+"-"+j);
        }
        cache.put(i+"-"+j, false);
        return cache.get(i+"-"+j);
    }
}

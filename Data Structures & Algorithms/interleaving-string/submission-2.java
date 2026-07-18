class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        Map<String, Boolean> cache = new HashMap<>();
        return dfs(0,0,s1,s2,s3,cache);
    }

    private boolean dfs(int i, int j, String s1, String s2, String s3, Map<String, Boolean> cache){
        if(i==s1.length() && j==s2.length()) return true;
        if(cache.containsKey(i+"-"+j)) return cache.get(i+"-"+j);
        if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j) && dfs(i+1, j, s1, s2, s3, cache)){
            return true;
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j) && dfs(i, j+1, s1, s2, s3, cache)){
            return true;
        }
        cache.put(i+"-"+j, false);
        return cache.get(i+"-"+j);
    }
}

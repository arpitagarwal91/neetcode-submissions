class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        Set<Character> visit = new HashSet<>();
        int res = 0;
        while(r<s.length()){
            if(!visit.contains(s.charAt(r))){
                visit.add(s.charAt(r));
                res = Math.max(res, r-l+1);
                r++;
            }
            else{
                visit.remove(s.charAt(l));
                l++;
            }
        }
        return res;
    }
}

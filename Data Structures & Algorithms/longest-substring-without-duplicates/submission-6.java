class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int l = 0, r = 0;
        Set<Character> visit = new HashSet<>();
        while(r<s.length()){
            if(!visit.contains(s.charAt(r))){
                visit.add(s.charAt(r));
                max = Math.max(max, r-l+1);
                r++;
            }
            else {
                visit.remove(s.charAt(l));
                l++;
            }
        }
        return max;
    }
}

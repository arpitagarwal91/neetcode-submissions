class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> visit = new HashSet();
        int i=0;
        int j=0;
        int maxLen = 0;
        while(j<s.length()){
            if(visit.contains(s.charAt(j))){
                visit.remove(s.charAt(i));
                i++;
            }
            else{
                visit.add(s.charAt(j));
                maxLen = Math.max(maxLen, j-i+1);
                j++;
            }
        }
        return maxLen;
    }
}

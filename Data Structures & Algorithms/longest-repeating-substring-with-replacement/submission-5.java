class Solution {
    public int characterReplacement(String s, int k) {
        int maxF = 0;
        int res = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        int l = 0;
        for(int r=0;r<s.length();r++){
            countMap.put(s.charAt(r), countMap.getOrDefault(s.charAt(r), 0)+1);
            maxF = Math.max(maxF, countMap.get(s.charAt(r)));

            while(r-l+1 - maxF > k){
                countMap.put(s.charAt(l), countMap.getOrDefault(s.charAt(l), 0)-1);
                l++;
            }

            res = Math.max(res, r-l+1);
        }
        return res;
    }
}

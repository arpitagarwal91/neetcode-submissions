class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int maxF = 0;
        int l = 0;
        Map<Character, Integer> count = new HashMap<>();
        for(int r=0;r<s.length();r++){
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0)+1);
            maxF = Math.max(maxF, count.get(s.charAt(r)));

            while(r-l+1 - maxF > k){
                count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0)-1);
                l++;
            }

            res = Math.max(res, r-l+1);
        }
        return res;
    }
}

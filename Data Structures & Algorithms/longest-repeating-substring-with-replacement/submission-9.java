class Solution {
    public int characterReplacement(String s, int k) {
        int count[] = new int[26];
        int l = 0, r = 0;
        int res = 0;
        int maxF = 0;
        while(r<s.length()){
            count[s.charAt(r)-'A']++;
            maxF = Math.max(maxF, count[s.charAt(r)-'A']);
            while(r-l+1 - maxF > k){
                count[s.charAt(l)-'A']--;
                l++; //Last attempt could not think of l++ logic. That where to place it.
            }
            res = Math.max(res, r-l+1);
            r++;
        }
        return res;
    }
}

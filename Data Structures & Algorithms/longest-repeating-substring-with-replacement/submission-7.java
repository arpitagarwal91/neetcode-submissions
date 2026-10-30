class Solution {
    public int characterReplacement(String s, int k) {
        int maxF = 0;
        int count[] = new int[26];
        int l = 0, r = 0;
        int res = 0;
        while(r<s.length()){

            char c = s.charAt(r);
            count[c-'A']++;
            maxF = Math.max(maxF, count[c-'A']);

            while(r-l+1-maxF>k){
                c = s.charAt(l);
                count[c-'A']--;
                l++;
            }
            res = Math.max(res, r-l+1);
            r++;
        }
        return res;
    }
}

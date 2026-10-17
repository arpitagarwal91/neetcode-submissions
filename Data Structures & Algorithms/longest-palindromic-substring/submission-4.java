class Solution {
    public String longestPalindrome(String s) {
        int res[] = {-1, -1};
        int maxLen = 0;
        for(int i=0;i<s.length();i++){
            int l = i;
            int r = i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
               if(maxLen<r-l+1){
                    maxLen = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }
                l--;
                r++;
            }
            l = i;
            r = i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
               if(maxLen<r-l+1){
                    maxLen = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }
                l--;
                r++;
            }
        }
        return s.substring(res[0], res[1]+1);
    }
}

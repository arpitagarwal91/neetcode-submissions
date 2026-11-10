class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int res[]  = {-1, -1};
        for(int i=0;i<s.length();i++){
            int l = i;
            int r = i;
            while(l>=0 && r<s.length()){
                if(s.charAt(l)==s.charAt(r)){
                    if(maxLen<r-l+1){
                        maxLen = r-l+1;
                        res[0] = l;
                        res[1] = r;
                    }
                    l--;
                    r++;
                }
                else break;
            }

            l = i;
            r = i+1;
            while(l>=0 && r<s.length()){
                if(s.charAt(l)==s.charAt(r)){
                    if(maxLen<r-l+1){
                        maxLen = r-l+1;
                        res[0] = l;
                        res[1] = r;
                    }
                    l--;
                    r++;
                }
                else break;
            }
        }
        return res[0]==-1 ? "" : s.substring(res[0], res[1]+1);
    }
}

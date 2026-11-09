class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            int l = i;
            int r = i;
            while(l>=0 && r<s.length()){
                if(s.charAt(l)==s.charAt(r)){
                    count++;
                    l--;
                    r++;
                }
                else break;
            }
            l = i;
            r = i+1;
            while(l>=0 && r<s.length()){
                if(s.charAt(l)==s.charAt(r)){
                    count++;
                    l--;
                    r++;
                }
                else break;
            }
        }
        return count;
    }
}

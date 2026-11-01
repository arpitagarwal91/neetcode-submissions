class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while(l<r){
            while(r>=0 && !Character.isLetterOrDigit(s.charAt(r))) r--;
            while(l<s.length() && !Character.isLetterOrDigit(s.charAt(l))) l++;
            if(l<s.length() && r>=0){
                if(Character.toLowerCase(s.charAt(l))==Character.toLowerCase(s.charAt(r))){
                    l++;
                    r--;
                }
                else return false;
            }
        }
        return l>=r;
    }
}

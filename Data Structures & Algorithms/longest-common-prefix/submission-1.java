class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1) return strs[0];
        StringBuilder res = new StringBuilder();
        for(int i=0;i<strs[0].length();i++){
            boolean isPresent = false;
            for(int j=1;j<strs.length;j++){
                if(i<strs[j].length() && strs[0].charAt(i)==strs[j].charAt(i)){
                    isPresent = true;
                }
                else {
                    isPresent = false;
                    break;
                }
            }
            if(isPresent) res.append(strs[0].charAt(i));
            else break;
        }
        return res.toString();
    }
}
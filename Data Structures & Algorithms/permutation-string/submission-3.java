class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> src = new HashMap();
        for(int i=0;i<s1.length();i++){
            src.put(s1.charAt(i), src.getOrDefault(s1.charAt(i), 0)+1);
        }
        for(int i=0;i<s2.length()-s1.length()+1;i++){
            Map<Character, Integer> dest = new HashMap();
            for(int j=i;j<i+s1.length();j++){
                dest.put(s2.charAt(j), dest.getOrDefault(s2.charAt(j), 0)+1);
            }
            if(dest.equals(src)) return true;
        }
        return false;
    }
}

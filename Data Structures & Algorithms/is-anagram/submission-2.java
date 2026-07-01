class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> src = new HashMap();
        Map<Character, Integer> dest = new HashMap();
        for(int i=0;i<s.length();i++){
            src.put(s.charAt(i), src.getOrDefault(s.charAt(i), 0) + 1);
            dest.put(t.charAt(i), dest.getOrDefault(t.charAt(i), 0) + 1);
        }
        return src.equals(dest);
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> src = new HashMap<>();
        for(char c:s1.toCharArray()) src.put(c, src.getOrDefault(c,0)+1);
        for(int i=0;i<=s2.length()-s1.length();i++){
            Map<Character, Integer> dest = new HashMap<>();
            for(int j=i;j<i+s1.length();j++) dest.put(s2.charAt(j), dest.getOrDefault(s2.charAt(j), 0)+1);
            if(src.equals(dest)) return true;
        }
        return false;
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;
        Map<Character, Integer> src = new HashMap<>();
        for(char c:s1.toCharArray()) src.put(c, src.getOrDefault(c, 0)+1);
        Map<Character, Integer> dest = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char c = s2.charAt(i);
            dest.put(c, dest.getOrDefault(c, 0)+1);
        }
        int l = 0, r = s1.length()-1;
        while(r<s2.length()){
            if(src.equals(dest)) return true;
            dest.put(s2.charAt(l), dest.getOrDefault(s2.charAt(l), 0)-1);
            if(dest.get(s2.charAt(l))==0) dest.remove(s2.charAt(l));
            l++;
            r++;
            if(r<s2.length()) dest.put(s2.charAt(r), dest.getOrDefault(s2.charAt(r), 0)+1);
        }
        return false;
    }
}

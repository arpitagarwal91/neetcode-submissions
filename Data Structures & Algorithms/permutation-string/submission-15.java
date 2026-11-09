class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;
        Map<Character, Integer> src = new HashMap<>();
        for(char c:s1.toCharArray()) src.put(c, src.getOrDefault(c, 0)+1);
        Map<Character, Integer> dest = new HashMap<>();
        for(int i=0;i<s1.length();i++) dest.put(s2.charAt(i), dest.getOrDefault(s2.charAt(i), 0)+1);
        int l = 0, r = s1.length()-1;
        System.out.println(src);
        System.out.println(dest);
        while(r<s2.length()){
            System.out.println(src);
            System.out.println(dest);
            if(src.equals(dest)) return true;
            if(dest.get(s2.charAt(l))>1) dest.put(s2.charAt(l), dest.getOrDefault(s2.charAt(l), 0)-1);
            else dest.remove(s2.charAt(l));
            l++;
            r++;
            if(r<s2.length()) dest.put(s2.charAt(r), dest.getOrDefault(s2.charAt(r), 0)+1);
        }
        return false;
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;
        Map<Character, Integer> src = new HashMap<>();
        for(char c: s1.toCharArray()) src.put(c, src.getOrDefault(c, 0)+1);
        // for(int i=0;i<s2.length()-s1.length()+1;i++){
        //     Map<Character, Integer> dest = new HashMap<>();
        //     for(int j=i;j<i+s1.length() && j<s2.length();j++){
        //         dest.put(s2.charAt(j), dest.getOrDefault(s2.charAt(j), 0)+1);
        //     }
        //     if(src.equals(dest)) return true;
        // }
        // return false;
        int l = 0, r = s1.length()-1;
        Map<Character, Integer> dest = new HashMap<>();
        for(int i=l;i<=r;i++) {
            dest.put(s2.charAt(i), dest.getOrDefault(s2.charAt(i), 0)+1);
        }
        while(r<s2.length()){
            if(src.equals(dest)) return true;
            dest.put(s2.charAt(l), dest.getOrDefault(s2.charAt(l), 0)-1);
            if(dest.getOrDefault(s2.charAt(l), 0)==0) dest.remove(s2.charAt(l));
            l++;
            r++;
            if(r<s2.length()) dest.put(s2.charAt(r), dest.getOrDefault(s2.charAt(r), 0)+1);
        }
        return false;
    }
}

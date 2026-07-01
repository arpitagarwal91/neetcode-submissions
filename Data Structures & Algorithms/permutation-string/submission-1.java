class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> src = new HashMap();
        for(int i=0;i<s1.length();i++){
            src.put(s1.charAt(i), src.getOrDefault(s1.charAt(i), 0)+1);
        }
        int k=0;
        while(k<s2.length()-s1.length()+1){
            Map<Character, Integer> dest = new HashMap();
            for(int j=k;j<k+s1.length();j++){
                dest.put(s2.charAt(j), dest.getOrDefault(s2.charAt(j), 0)+1);
            }
            if(src.equals(dest)) return true;
            k++;
        }
        return false;
    }
}

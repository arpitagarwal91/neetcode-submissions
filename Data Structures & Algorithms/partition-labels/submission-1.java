class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> idxMap = new HashMap<>();
        for(int i=0;i<s.length();i++) idxMap.put(s.charAt(i), i);
        List<Integer> res = new ArrayList<>();

        int l = 0, r = 0;
        while(r<s.length()){
            r = l;
            int partEnd = idxMap.get(s.charAt(r));
            while(r<partEnd){
                partEnd = Math.max(partEnd, idxMap.get(s.charAt(r)));
                r++;
            }
            res.add(r-l+1);
            l = r+1;
            if(l==s.length()) break;
        }
        return res;
    }
}

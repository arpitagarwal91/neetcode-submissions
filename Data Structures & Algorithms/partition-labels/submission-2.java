class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> idxMap = new HashMap<>();
        for(int i=0;i<s.length();i++) idxMap.put(s.charAt(i), i);
        
        List<Integer> res = new ArrayList<>();
        int l = 0, r = 0;
        while(r<s.length()){
            int maxIdx = -1;
            for(int i=l;i<=r;i++){
                maxIdx = Math.max(maxIdx, idxMap.get(s.charAt(i)));
                r = maxIdx;
            }
            res.add(r-l+1);
            l = r+1;
            r = l;
        }
        return res;
    }
}

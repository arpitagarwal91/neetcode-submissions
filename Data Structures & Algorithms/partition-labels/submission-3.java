class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> idxMap = new HashMap<>();
        for(int i=0;i<s.length();i++) idxMap.put(s.charAt(i), i);
        int l = 0, r = 0;
        List<Integer> res = new ArrayList<>();
        while(r<s.length()){
            for(int i=l;i<=r;i++){
                r = Math.max(r, idxMap.get(s.charAt(i)));
            }
            res.add(r-l+1);
            r++;
            l = r;
        }
        return res;
    }
}

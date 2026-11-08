class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> idx = new HashMap<>();
        for(int i=0;i<s.length();i++){
            idx.put(s.charAt(i), i);
        }
        int l = 0, r = 0, maxIdx = -1;
        List<Integer> res = new ArrayList<>();
        while(r<s.length()){
            for(int i=l;i<=r;i++){
                maxIdx = Math.max(maxIdx, idx.get(s.charAt(i)));
                r = maxIdx;
            }
            res.add(r-l+1);
            l = r+1;
            r = l;
        }
        return res;
    }
}

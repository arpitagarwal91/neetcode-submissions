class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num:nums){
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        List<Integer> ls[] = new ArrayList[nums.length+1];
        for(int i=0;i<nums.length+1;i++) ls[i] = new ArrayList<>();
        for(int key:count.keySet()){
            int idx = count.get(key);
            ls[idx].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=nums.length;i>=0;i--){
            if(ls[i].size()>0 && k>0){
                res.addAll(ls[i]);
                k-=ls[i].size();
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

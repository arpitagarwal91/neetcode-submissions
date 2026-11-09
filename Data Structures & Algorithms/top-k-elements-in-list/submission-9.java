class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num:nums) count.put(num, count.getOrDefault(num, 0)+1);
        List<Integer> freq[] = new ArrayList[nums.length+1];
        for(int i=0;i<nums.length+1;i++) freq[i] = new ArrayList<>();
        for(int key:count.keySet()) freq[count.get(key)].add(key);
        int res[] = new int[k];
        for(int i=nums.length;i>=0;i--){
            if(k>0){
                if(freq[i].size()>0) for(int ele:freq[i]) res[--k] = ele; 
            }
            else break;
        }
        return res;
    }
}

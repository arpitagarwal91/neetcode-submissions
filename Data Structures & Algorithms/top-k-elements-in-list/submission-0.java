class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap();
        for(int i=0;i<nums.length;i++){
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        for(Integer num:countMap.keySet()){
            pq.add(new Integer[]{countMap.get(num), num});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = pq.poll()[1];
        }
        return res;
    }
}

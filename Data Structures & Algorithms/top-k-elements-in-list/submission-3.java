class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++) mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for(int ele:mp.keySet()){
            pq.add(new int[]{ele, mp.get(ele)});
            if(pq.size()>k) pq.poll();
        }
        int res[] = new int[k];
        int c = 0;
        while(!pq.isEmpty()){
            res[c++] = pq.poll()[0];
        }
        return res;
    }
}

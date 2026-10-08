class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Map<Integer, Integer> map = new HashMap<>();
        // for(int num:nums) map.put(num, map.getOrDefault(num, 0)+1);
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        // for(int key:map.keySet()){
        //     pq.add(new int[]{key, map.get(key)});
        //     if(pq.size()>k) pq.poll();
        // }
        // return pq.peek()[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums){
            pq.add(num);
            if(pq.size()>k) pq.poll();
        }
        return pq.peek();
    }
}

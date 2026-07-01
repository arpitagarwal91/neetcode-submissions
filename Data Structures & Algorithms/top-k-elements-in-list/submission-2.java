class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num:nums) count.put(num, count.getOrDefault(num, 0)+1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        for(int key:count.keySet()){
            pq.add(new int[]{key, count.get(key)});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int res[] = new int[k];
        int p = 0;
        while(!pq.isEmpty()) res[p++] = pq.poll()[0];
        return res;
    }
}

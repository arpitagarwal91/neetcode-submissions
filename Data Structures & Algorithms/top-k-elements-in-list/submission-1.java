class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap();
        for(int num:nums){
            count.put(num, count.getOrDefault(num, 0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[0]-b[0]);
        Set<Integer> countSet = count.keySet();
        for(int ele:countSet){
            pq.add(new int[]{count.get(ele), ele});
            if(pq.size()>k) pq.poll();
        }

        int res[] = new int[k];
        for(int i=0;i<k;i++){
            res[i] = pq.poll()[1];
        }
        return res;
    }
}

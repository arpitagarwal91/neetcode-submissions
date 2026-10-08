class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num:nums) countMap.put(num, countMap.getOrDefault(num, 0)+1);
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        // for(int key:countMap.keySet()) {
        //     pq.add(new int[]{ key, countMap.get(key)});
        //     if(pq.size()>k) pq.poll();
        // }
        // int p = 0;
        // while(!pq.isEmpty()){
        //     res[p++] = pq.poll()[0];
        // }
        // return res;
        List<Integer> freq[] = new ArrayList[nums.length+1];
        for(int i=0;i<freq.length;i++) freq[i] = new ArrayList<Integer>();
        for(int key:countMap.keySet()) freq[countMap.get(key)].add(key);
        int p = 0;
        for(int i=freq.length-1;i>=0;i--){
            if(freq[i].size()>0){
                for(int ele:freq[i]) {
                    res[p++] = ele;
                    if(p==k) break;
                }
                if(p==k) break;
            }
        }
        return res;
    }
}

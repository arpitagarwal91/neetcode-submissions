class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        // for(int i=0;i<queries.length;i++){
        //     idxMap.put(queries[i], i);
        // }
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        int i = 0;
        for(int q:Arrays.stream(queries).sorted().toArray()){
            while(i<intervals.length && intervals[i][0]<=q){
                int start = intervals[i][0];
                int end = intervals[i][1];
                pq.add(new int[]{start, end, end-start+1});
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[1]<q) pq.poll();
            if(!pq.isEmpty()){
                idxMap.put(q, pq.isEmpty() ? -1 : pq.peek()[2]);
            }
        }
        int res[] = new int[queries.length];
        for(int k=0;k<queries.length;k++){
            res[k] = idxMap.getOrDefault(queries[k], -1);
        }
        return res;
    }
}

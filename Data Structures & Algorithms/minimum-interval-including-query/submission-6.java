class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Map<Integer, Integer> queryIdxMap = new HashMap<>();
        int res[] = new int[queries.length];
        
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        int i = 0;
        for(int q:Arrays.stream(queries).sorted().toArray()){
            while(i<intervals.length && intervals[i][0]<=q) {
                pq.add(new int[]{intervals[i][0], intervals[i][1], intervals[i][1]-intervals[i][0]+1});
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[1]<q) pq.poll();
            if(!pq.isEmpty()) System.out.println(queryIdxMap.get(q)+"--"+pq.peek()[0]+"--"+pq.peek()[1]);
            queryIdxMap.put(q, pq.isEmpty() ? -1 : pq.peek()[2]);
        }
        for(int j=0;j<queries.length;j++){
            res[j] = queryIdxMap.get(queries[j]);
        }
        return res;
    }
}

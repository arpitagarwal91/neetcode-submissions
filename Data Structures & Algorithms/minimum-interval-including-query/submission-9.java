class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int res[] = new int[n];
        Map<Integer, Integer> idx = new HashMap<>();
        //for(int i=0;i<queries.length;i++) idx.put(queries[i], i);
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<Integer> qs = Arrays.stream(queries).sorted().boxed().collect(Collectors.toList());
        int i = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        for(int q:qs){
            while(i<intervals.length && intervals[i][0]<=q) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                pq.add(new int[]{l, r, r-l+1});
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[1]<q) pq.poll();
            if(!pq.isEmpty()) idx.put(q, pq.peek()[2]);
        }
        for(int k=0;k<n;k++){
            res[k] = idx.getOrDefault(queries[k], -1);
        }
        return res;
    }
}

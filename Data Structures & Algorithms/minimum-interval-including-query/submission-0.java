class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        Map<Integer, Integer> res = new HashMap<>();

        int qCopy[] = Arrays.copyOfRange(queries, 0, queries.length);
        Arrays.sort(qCopy);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int i = 0;
        for(int q: qCopy){
            while(i<intervals.length && intervals[i][0]<=q){
                int l = intervals[i][0], r = intervals[i][1]; 
                pq.add(new int[]{r-l+1, r});
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[1]<q){
                pq.poll();
            }
            res.put(q, !pq.isEmpty() ? pq.peek()[0] : -1);
        }
        int ans[] = new int[queries.length];
        for(int j=0;j<queries.length;j++){
            int q = queries[j];
            ans[j] = res.get(q);
        }
        return ans;
    }
}

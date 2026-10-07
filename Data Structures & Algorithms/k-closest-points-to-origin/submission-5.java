class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[2]-a[2]);
        for(int p[]:points){
            pq.add(new int[]{p[0],p[1],(p[0]*p[0])+(p[1]*p[1])});
            if(pq.size()>k) pq.poll();
        }
        int res[][] = new int[k][2];
        int p = 0;
        while(!pq.isEmpty()) {
            int ele[] = pq.poll();
            res[p][0] = ele[0];
            res[p][1] = ele[1];
            p++;
        }
        return res;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[2]-a[2]);
        for(int[] point:points){
            pq.add(new int[]{point[0],point[1], Math.abs(point[0]*point[0])+Math.abs(point[1]*point[1])});
            if(pq.size()>k) pq.poll();
        }
        int res[][] = new int[k][2];
        int p = 0;
        while(!pq.isEmpty()) {
            int ele[] = pq.poll();
            res[p++] = new int[]{ele[0], ele[1]};
        }
        return res;
    }
}

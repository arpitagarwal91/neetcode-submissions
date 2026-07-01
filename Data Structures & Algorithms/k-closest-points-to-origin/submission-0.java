class Solution {
    PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>((a,b)-> b[2]-a[2]);
    int k;
    public int[][] kClosest(int[][] points, int k) {
        this.k = k;
        for(int point[]:points){
            int x = point[0]*point[0];
            int y = point[1]*point[1];
            add(new Integer[]{point[0], point[1], x+y});
        }
        int res[][] = new int[k][2];
        for(int i=0;i<k;i++){
            Integer point[] = pq.poll();
            res[i][0] = point[0];
            res[i][1] = point[1];
        }
        return res;
    }

    public void add(Integer[] val){
        if(pq.size()<k) pq.add(val);
        else if(val[2]<pq.peek()[2]){
            pq.poll();
            pq.add(val);
        }
    }
}

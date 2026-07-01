class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        for(int interval[]:intervals) pq.add(interval);
        List<int[]> res = new ArrayList<>();
        while(!pq.isEmpty() && pq.size()>1){
            int ele1[] = pq.poll();
            int ele2[] = pq.poll();
            if(ele1[1]>=ele2[0]){
                int ele[] = new int[]{Math.min(ele1[0],ele2[0]),Math.max(ele1[1],ele2[1])};
                pq.add(ele);
            }
            else{
                res.add(ele1);
                pq.add(ele2);
                //res.add(ele2);
            }
        }
        if(pq.size()==1) res.add(pq.poll());
        int ans[][] = new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}

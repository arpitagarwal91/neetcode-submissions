class Solution {
    public int[] getOrder(int[][] tasks) {
        int res[] = new int[tasks.length];
        for(int i=0;i<tasks.length;i++){
            int tmp[] = new int[3];
            tmp[0] = tasks[i][0];
            tmp[1] = tasks[i][1];
            tmp[2] = i;
            tasks[i] = tmp;
        }

        Arrays.sort(tasks, (a,b)-> a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int i = 0, time = tasks[0][0], resIdx = 0;
        while(!pq.isEmpty() || i<tasks.length){
            while(i<tasks.length && time>=tasks[i][0]){
                int ele[] = tasks[i];
                pq.add(new int[]{ele[1],ele[2]});
                i++;
            }
            if(pq.isEmpty()){
                time = tasks[i][0];
            }
            else{
                int ele[] = pq.poll();
                time+=ele[0];
                res[resIdx++] = ele[1];
            }
        }
        return res;
    }
}
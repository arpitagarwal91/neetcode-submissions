class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int count[] = new int[n];
        Arrays.sort(meetings, (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for(int i=0;i<n;i++) available.add(i);
        PriorityQueue<int[]> used = new PriorityQueue<>((a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        for(int meet[]:meetings){
            int start = meet[0];
            int end = meet[1];
            while(!used.isEmpty() && start>=used.peek()[0]){
               int room = used.poll()[1];
               available.add(room);
            }
            if(available.isEmpty()){
                int endAndRoomNo[] = used.poll();
                int room = endAndRoomNo[1];
                available.add(room);
                end = endAndRoomNo[0] + (end-start);
            }
            int room = available.poll();
            used.add(new int[]{end, room});
            count[room]++;
        }
        int res = 0;
        for(int i=1;i<n;i++){
            if(count[res]<count[i])
            res = i;
        }
        return res;
    }
}
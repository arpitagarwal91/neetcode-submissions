class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int stone:stones){
            pq.add(stone);
        }
        while(pq.size()>=2){
            int x = pq.poll();
            int y = pq.poll();
            System.out.println(x+"--"+y);
            if(x!=y){
                pq.add(Math.abs(x-y));
            }
        }
        return !pq.isEmpty() ? pq.peek() : 0;
    }
}

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;
        Map<Integer, Integer> count = new HashMap<>();
        for(int c:hand) count.put(c, count.getOrDefault(c, 0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int key:count.keySet()) pq.add(key);

        while(!pq.isEmpty()){
            int start = pq.peek();
            for(int i=start;i<start+groupSize;i++){
                if(!count.containsKey(i)) return false;
                count.put(i, count.getOrDefault(i, 0)-1);
                if(count.get(i)==0){
                    if(pq.peek()!=i) return false; //Forgot the rational of having this line.
                    pq.poll();
                }
            }
        }
        return true;
    }
}

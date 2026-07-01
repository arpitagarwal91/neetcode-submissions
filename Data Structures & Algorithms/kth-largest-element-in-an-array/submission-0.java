class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue();
    int k;
    public int findKthLargest(int[] nums, int k) {
        this.k = k;
        for(int num: nums) add(num);
        return pq.peek();
    }

    public void add(int n){
        if(pq.size()<k) pq.add(n);
        else if(n > pq.peek()){
            pq.poll();
            pq.add(n);
        }
    }
}

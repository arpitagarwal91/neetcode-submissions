public class KthLargest {
    PriorityQueue<int, int> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<int, int>();
        foreach(int num in nums){
            Add(num);
        }
    }
    
    public int Add(int val) {
        this.pq.Enqueue(val,val);
        if(pq.Count>k) pq.Dequeue();
        return pq.Peek();
    }
}

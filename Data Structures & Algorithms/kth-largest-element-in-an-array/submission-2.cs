public class Solution {
    public int FindKthLargest(int[] nums, int k) {
        PriorityQueue<int, int> pq = new PriorityQueue<int, int>();
        foreach(int num in nums){
            pq.Enqueue(num, num);
            if(pq.Count>k) pq.Dequeue();
        }
        return pq.Peek();
    }
}

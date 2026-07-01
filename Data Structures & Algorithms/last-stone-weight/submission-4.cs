public class Solution {
    public int LastStoneWeight(int[] stones) {
        PriorityQueue<int, int> pq = new PriorityQueue<int, int>();
        foreach(int stone in stones){
            pq.Enqueue(-stone, -stone);
        }
        while(pq.Count>1){
            int first = pq.Dequeue();
            int second = pq.Dequeue();
            pq.Enqueue(first-second, first-second);
        }
        return Math.Abs(pq.Peek());
    }
}

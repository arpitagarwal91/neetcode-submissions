class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int l = 0;
        int res[] = new int[nums.length-k+1];
        int p = 0;
        for(int r=0;r<nums.length;r++){
            while(!q.isEmpty() && nums[q.getLast()]<=nums[r]){
                q.removeLast();
            }
            q.addLast(r);
            if(l>q.getFirst()) {
                q.removeFirst(); //did l++ here instead of updating l at the time of res[l++].
            }
            if(r-l+1>=k){
                res[l++] = nums[q.getFirst()]; //used p++ instead of l++ here
            }
        }
        return res;
    }
}

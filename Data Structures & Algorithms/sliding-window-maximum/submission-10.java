class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n-k+1];
        Deque<Integer> q = new LinkedList<>();
        int l = 0;
        for(int r=0;r<nums.length;r++){
            while(!q.isEmpty() && nums[q.getLast()]<nums[r]){
                q.removeLast();
            }
            q.add(r);
            if(l>q.getFirst()) q.removeFirst();
            if(r-l+1>=k){
                res[l++] = nums[q.getFirst()];
            }
        }
        return res;
    }
}

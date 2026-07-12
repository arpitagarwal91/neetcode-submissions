class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int res[] = new int[nums.length-k+1];
        int p = 0;
        int l = 0, r = 0;
        while(r<nums.length){
            while(!q.isEmpty() && nums[r]>nums[q.getLast()]){
                q.removeLast();
            }
            q.addLast(r);
            if(l>q.getFirst()) q.removeFirst();
            if(!q.isEmpty() && r>=k-1){
                res[l++] = nums[q.getFirst()];
            }
            r++;
        }
        return res;
    }
}

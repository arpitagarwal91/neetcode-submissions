class Solution {
    public int maxCoins(int[] nums) {
        Map<String, Integer> cache = new HashMap<>();
        int nums1[] = new int[nums.length+2];
        nums1[0] = 1;
        nums1[nums1.length-1] = 1;
        for(int i=1;i<nums.length+1;i++){
            nums1[i] = nums[i-1];
        }
        return getMaxCoins(1, nums1.length-2, nums1, cache);
    }

    private int getMaxCoins(int start, int end, int nums[], Map<String, Integer> cache){
        String key = start+"-"+end;
        if(end<start) return 0;
        // if(end<=0) return 1;
        // if(start>=nums.length-1) return 1;
        if(cache.containsKey(key)) return cache.get(key);

        int res = 0;
        for(int i=start;i<=end;i++){
            int balloons = nums[start-1]*nums[i]*nums[end+1];
            balloons += getMaxCoins(start, i-1, nums, cache) + getMaxCoins(i+1, end, nums, cache);
            res = Math.max(res, balloons);
        }
        cache.put(key, res);
        return cache.get(key);
    }
}

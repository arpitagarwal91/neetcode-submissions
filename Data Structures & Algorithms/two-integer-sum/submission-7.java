class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idx = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(idx.containsKey(target-nums[i])) return new int[]{idx.get(target-nums[i]), i};
            idx.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}

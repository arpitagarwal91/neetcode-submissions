class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visit = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(visit.containsKey(target-nums[i])) return new int[]{visit.get(target-nums[i]), i};
            visit.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}

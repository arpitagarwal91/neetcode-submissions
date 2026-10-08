class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(idxMap.containsKey(target-nums[i])) return new int[]{idxMap.get(target-nums[i]), i};
            idxMap.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}

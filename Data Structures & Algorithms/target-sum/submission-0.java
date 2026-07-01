class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap();
        mp.put(0, 1);
        for(int num:nums){
            Map<Integer, Integer> next = new HashMap();
            for (int sum : mp.keySet()) {
                int count = mp.get(sum);
                next.put(sum + num, next.getOrDefault(sum + num, 0) + count);
                next.put(sum - num, next.getOrDefault(sum - num, 0) + count);
            }
            mp = next;
        }
        return mp.getOrDefault(target, 0);
    }
}
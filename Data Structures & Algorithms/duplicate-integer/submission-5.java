class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> visit = new HashSet<>();
        for(int num:nums) {
            if(visit.contains(num)) return true;
            visit.add(num);
        }
        return false;
    }
}
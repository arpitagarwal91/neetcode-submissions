class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> visit = new HashSet<>();
        for(int t[]:triplets){
            if(t[0]>target[0] || t[1]>target[1]|| t[2]>target[2]) continue;
            if(t[0]==target[0]) visit.add(0);
            if(t[1]==target[1]) visit.add(1);
            if(t[2]==target[2]) visit.add(2);
        }
        return visit.size()==3;
    }
}

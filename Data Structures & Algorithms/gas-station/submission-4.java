class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalG = 0;
        int totalC = 0;
        int start = 0;
        int diff = 0;
        for(int i=0;i<gas.length;i++){
            totalG += gas[i];
            totalC += cost[i];
            diff += (gas[i]-cost[i]);
            if(diff<0){
                start = i+1;
                diff = 0;
            }
        }
        if(totalC>totalG) return -1;
        return start;
    }
}

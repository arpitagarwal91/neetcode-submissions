class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalC = 0, totalG = 0;
        int diff = 0;
        int start = 0;
        for(int i=0;i<n;i++){
            totalC+=cost[i];
            totalG+=gas[i];
            diff += (gas[i]-cost[i]);
            if(diff<0){
                start = i+1;
                diff = 0;
            }
        }
        return totalG<totalC ? -1 : start;
    }
}

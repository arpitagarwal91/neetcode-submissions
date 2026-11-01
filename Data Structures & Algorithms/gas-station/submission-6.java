class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int diff = 0;
        int n = gas.length;
        int res = 0;
        for(int i=0;i<n;i++){
            gasSum+=gas[i];
            costSum+=cost[i];

            diff += (gas[i]-cost[i]);
            if(diff<0){
                res = i+1;
                diff = 0;
            }
        }
        if(gasSum<costSum) return -1;
        return res;

    }
}

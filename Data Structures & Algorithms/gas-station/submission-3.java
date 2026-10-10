class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalG = 0, totalC = 0, start = 0, sum = 0;
        for(int i=0;i<cost.length;i++){
            totalG+=gas[i];
            totalC+=cost[i];
            sum += (gas[i]-cost[i]);
            if(sum<0){
                sum = 0;
                start = i+1;
            }
        }
        if(totalG<totalC) return -1;
        return start;
        
    }
}

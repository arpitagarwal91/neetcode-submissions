class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!=0) return false;
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for(int h:hand){
            count.put(h, count.getOrDefault(h, 0)+1);
        }
        int groups = n/groupSize;
        for(int i=0;i<groups;i++){
            int k = 0;
            for(int key:count.keySet()){
                int groupStart = count.get(key) > 0 ? key : -1;
                if(groupStart==-1) continue;
                while(k<groupSize){
                    if(count.getOrDefault(groupStart+k, 0)>0){
                        count.put(groupStart+k, count.getOrDefault(groupStart+k, 0)-1);
                        k++;
                    }
                    else return false;
                }
            }
            if(k<groupSize) return false;
        }
        return true;
    }
}

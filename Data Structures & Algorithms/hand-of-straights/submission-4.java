class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;
        Map<Integer, Integer> countMap = new TreeMap<>();
        for(int h:hand) countMap.put(h, countMap.getOrDefault(h, 0)+1);

        for(int i=0;i<(hand.length/groupSize);i++){
            int k = 0;
            for(int key:countMap.keySet()){
                int groupStart = countMap.get(key)>0 ? key : -1;
                if(groupStart==-1) continue;
                while(k<groupSize){
                    if(countMap.getOrDefault(key+k, 0)>0){
                        countMap.put(key+k, countMap.getOrDefault(key+k, 0)-1);
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

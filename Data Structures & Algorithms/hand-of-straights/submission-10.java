class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!=0) return false;
        TreeMap<Integer, Integer> count = new TreeMap<>();
        int cnt = 0;
        for(int h:hand) count.put(h, count.getOrDefault(h, 0)+1);
        for(int i=0;i<(n/groupSize);i++){
            int k = 0;
            for(int key:count.keySet()){
                if(count.get(key)==0) continue;
                int groupStart = key;
                while(k<groupSize){
                    if(!count.containsKey(groupStart+k)) return false;
                    if(count.get(groupStart+k)>0) {
                        count.put(groupStart+k, count.get(groupStart+k)-1);
                        k++;
                    }
                    else return false;
                }
            }
        }
        return true;
    }
}

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!=0) return false;
        Map<Integer, Integer> count = new TreeMap<>();
        for(int h:hand) count.put(h, count.getOrDefault(h, 0)+1);
        int groups = n/groupSize;
        for(int i=0;i<groups;i++){
            int k = 0;
            for(int key:count.keySet()){
                if(count.get(key)==0) continue;
                int start = key;
                while(k<groupSize){
                    int card = start+k;
                    if(!count.containsKey(card)) return false;
                    if(count.get(card)>0){
                        count.put(card, count.get(card)-1);
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

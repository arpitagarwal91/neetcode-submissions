class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int bill:bills){
            if(bill==5) {
                mp.put(5, mp.getOrDefault(5, 0)+1);
                continue;
            }
            else if(bill==10 && mp.getOrDefault(5, 0)>0){
                mp.put(5, mp.get(5)-1);
                mp.put(10, mp.getOrDefault(10, 0)+1);
                continue;
            }
            else if(bill==20 && ((mp.getOrDefault(5,0)>=1 && mp.getOrDefault(10, 0)>=1) || mp.getOrDefault(5, 0)>=3)){
                if(mp.getOrDefault(10, 0)>=1){
                    mp.put(10, mp.get(10)-1);
                    mp.put(5, mp.get(5)-1);
                }
                else {
                    mp.put(5, mp.get(5)-3);
                }
                continue;
            }
            return false;
        }
        return true;
    }
}
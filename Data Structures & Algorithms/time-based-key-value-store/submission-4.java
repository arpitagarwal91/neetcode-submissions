class TimeMap {

    Map<String, List<Pair<String, Integer>>> cache;

    public TimeMap() {
        this.cache = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.cache.computeIfAbsent(key, k->new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!this.cache.containsKey(key)) return "";
        List<Pair<String, Integer>> ls = this.cache.get(key);
        int l = 0, r = ls.size()-1;
        int res = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(ls.get(mid).getValue()==timestamp) return ls.get(mid).getKey();
            if(ls.get(mid).getValue()<timestamp){
                res = mid;
                l = mid+1;
            }
            else r = mid-1;
        }
        return res==-1 ? "" : ls.get(res).getKey();
    }
}

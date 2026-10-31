class TimeMap {

    Map<String, List<Pair<Integer, String>>> cache;

    public TimeMap() {
        this.cache = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.cache.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!this.cache.containsKey(key)) return "";
        List<Pair<Integer, String>> ls = this.cache.get(key);
        int l = 0, r = ls.size()-1;
        String res = "";
        while(l<=r){
            int mid = (l+r)/2;
            if(ls.get(mid).getKey()<=timestamp){
                res = ls.get(mid).getValue();
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return res;
    }
}

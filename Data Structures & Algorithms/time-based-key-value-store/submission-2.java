class TimeMap {

    Map<String, List<String[]>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.map.computeIfAbsent(key, k->new ArrayList<String[]>()).add(new String[]{value, timestamp+""});
    }
    
    public String get(String key, int timestamp) {
        if(this.map.containsKey(key)){
            List<String[]> ls = this.map.get(key);
            int l = 0;
            int r = ls.size()-1;
            String res = "";
            while(l<=r){
                int mid = (l+r)/2;
                int time = Integer.parseInt(ls.get(mid)[1]);
                if(time<=timestamp){
                    res = ls.get(mid)[0];
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
            }
            return res;
        }
        return "";
    }
}

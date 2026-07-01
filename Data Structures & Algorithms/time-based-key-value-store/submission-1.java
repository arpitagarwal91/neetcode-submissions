class TimeMap {

    Map<String, List<String[]>> mp;

    public TimeMap() {
        this.mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!mp.containsKey(key)) mp.put(key, new ArrayList<String[]>());
        mp.get(key).add(new String[]{value,timestamp+""});
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key) || mp.get(key).size()==0) return "";
        List<String[]> ls = mp.get(key);
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
}

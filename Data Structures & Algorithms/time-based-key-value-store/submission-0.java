class TimeMap {

    Map<String, List<Pair<String, Integer>>> keystore;

    public TimeMap() {
        this.keystore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<String, Integer>> vals = this.keystore.getOrDefault(key, new ArrayList<>());
        vals.add(new Pair(value, timestamp));
        this.keystore.put(key, vals);
    }
    
    public String get(String key, int timestamp) {
        List<Pair<String, Integer>> vals = this.keystore.getOrDefault(key, new ArrayList<>());
        int l=0;
        int r=vals.size()-1;
        String res = "";
        while(l<=r){
            int m = l+(r-l)/2;
            if(vals.get(m).getValue()<=timestamp){
                res = vals.get(m).getKey();
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        return res;
    }

    class Pair<K,V>{

        private K key;
        private V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return this.key;
        }

        public V getValue(){
            return this.value;
        }

        public void setKey(K key){
            this.key = key;
        }

        public void setValue(V value){
            this.value = value;
        }
    }
}

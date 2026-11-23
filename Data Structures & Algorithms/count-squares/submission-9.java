class CountSquares {

    Map<String, Integer> count;
    List<String> ls;

    public CountSquares() {
        this.ls = new ArrayList<>();
        this.count = new HashMap<>();
    }
    
    public void add(int[] point) {
        String pt = point[0]+":"+point[1];
        this.ls.add(pt);
        this.count.put(pt, this.count.getOrDefault(pt, 0)+1);
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int cnt = 0;
        for(String pt:ls){
            int px = Integer.parseInt(pt.split(":")[0]);
            int py = Integer.parseInt(pt.split(":")[1]);
            if(!this.count.containsKey(x+":"+py) || !this.count.containsKey(px+":"+y) || x==px || y==py) continue;
            cnt += (this.count.get(x+":"+py)*this.count.get(px+":"+y));
        }
        return cnt;
    }
}

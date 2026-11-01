class CountSquares {

    Map<String, Integer> count;
    List<String> ls;

    public CountSquares() {
        this.count = new HashMap<>();
        this.ls = new ArrayList<>();
    }
    
    public void add(int[] point) {
        String p = point[0]+"-"+point[1];
        this.count.put(p, this.count.getOrDefault(p, 0)+1);
        this.ls.add(p);
    }
    
    public int count(int[] point) {
        int res = 0;
        for(String p:ls){
            int px = Integer.parseInt(p.split("-")[0]);
            int py = Integer.parseInt(p.split("-")[1]);
            if(Math.abs(point[0]-px)!=Math.abs(point[1]-py) || point[0]==px || point[1]==py) continue;
            res+= this.count.getOrDefault(px+"-"+point[1], 0)*this.count.getOrDefault(point[0]+"-"+py, 0);
        }
        return res;
    }
}

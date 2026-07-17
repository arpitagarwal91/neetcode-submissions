class CountSquares {

    Map<String, Integer> count;
    List<String> ls;

    public CountSquares() {
        this.count = new HashMap<>();
        this.ls = new ArrayList<>();
    }
    
    public void add(int[] point) {
        this.count.put(point[0]+"-"+point[1], this.count.getOrDefault(point[0]+"-"+point[1], 0)+1);
        this.ls.add(point[0]+"-"+point[1]);
    }
    
    public int count(int[] point) {
        int res = 0;
        for(String str:ls){
            int px = Integer.parseInt(str.split("-")[0]);
            int py = Integer.parseInt(str.split("-")[1]);
            if(Math.abs(point[0]-px)!=Math.abs(point[1]-py) || point[0]==px ||point[1]==py) continue;
            res += this.count.getOrDefault(px+"-"+point[1],0)*this.count.getOrDefault(point[0]+"-"+py, 0);
        }
        return res;
    }
}

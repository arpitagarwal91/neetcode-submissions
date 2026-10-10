class Solution {
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for(int edge[]:edges) if(!dsu.union(edge[0], edge[1])) return false;
        Set<Integer> visit = new HashSet<>();
        for(int val:dsu.parent) {
            System.out.print(val+" ");
            visit.add(val);
        }
        return dsu.comps==1;
    }
}

class DSU {
    int parent[];
    int size[];
    int comps;

    public DSU(int n){
        this.comps = n;
        this.parent = new int[n];
        this.size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public boolean union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1==p2) {
            System.out.println(p1+"  "+p2);
            return false;
        }
        this.comps--;
        if(size[p1]>size[p2]){
            size[p1]+=size[p2];
            parent[p2] = p1;
        }
        else{
            size[p2]+=size[p1];
            parent[p1] = p2;
        }
        return true;
    }

    public int find(int n1){
        while(n1!=parent[n1]){
            parent[n1] = parent[parent[n1]];
            n1 = parent[n1];
        }
        return parent[n1];
    }
}

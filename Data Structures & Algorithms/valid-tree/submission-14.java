class Solution {
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for(int edge[]:edges){
            if(!dsu.union(edge[0], edge[1])) return false;
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
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public int find(int n){
        while(n!=parent[n]){
            parent[n] = parent[parent[n]];
            n = parent[n];
        }
        return parent[n];
    }

    public boolean union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1==p2) return false;
        this.comps--;
        if(size[p1]>size[p2]){
            parent[p2] = p1;
            size[p1]+=size[p2];
        }
        else{
            parent[p1] = p2;
            size[p2]+=size[p1];
        }
        return true;
    }
}

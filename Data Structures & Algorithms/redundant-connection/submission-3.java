class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;
        DSU dsu = new DSU(n);
        for(int edge[]:edges){
            if(!dsu.union(edge[0], edge[1])) return edge;
        }
        return new int[]{-1, -1};
    }
}

class DSU {
    int parent[];
    int size[];

    public DSU(int n){
        this.parent = new int[n];
        this.size = new int[n];
        for(int i=0;i<n;i++){
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    private int find(int n1){
        while(n1!=parent[n1]){
            parent[n1] = parent[parent[n1]];
            n1 = parent[n1];
        }
        return parent[n1];
    }

    private boolean union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1==p2) return false;
        if(size[p1]>=size[p2]){
            size[p1]+=size[p2];
            parent[p2] = p1;
        }
        else{
            size[p2]+=size[p1];
            parent[p1] = p2;
        }
        return true;
    }
}

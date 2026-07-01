class Solution {
    private int comps;
    public boolean validTree(int n, int[][] edges) {
        comps = n;
        int parent[] = new int[n+1];
        int rank[] = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int edge[]:edges){
            if(!union(edge[0],edge[1],parent,rank)) return false;
        }
        return comps==1;
    }

    public boolean union(int n1, int n2, int parent[], int rank[]){
        int p1 = find(n1, parent);
        int p2 = find(n2, parent);
        if(p1==p2) return false;
        if(rank[p1]>=rank[p2]){
            parent[p2] = p1;
            rank[p1]+=rank[p2];
        }
        else{
            parent[p1] = p2;
            rank[p2]+=rank[p1];
        }
        comps--;
        return true;
    }

    public int find(int p, int parent[]){
        int cur = p;
        if(parent[cur]!=cur){
            parent[cur] = find(parent[cur], parent);
        }
        return parent[cur];
    }
}

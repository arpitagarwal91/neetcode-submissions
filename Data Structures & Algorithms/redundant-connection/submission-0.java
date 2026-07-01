class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;
        int par[] = new int[n];
        int rank[] = new int[n];
        for(int i=0;i<n;i++){
            par[i] = i;
            rank[i] = 1;
        }
        for(int edge[]:edges){
            if(!union(edge[0],edge[1],par,rank)) return edge;
        }
        return new int[]{-1,-1};
    }

    public int find(int n1, int par[], int rank[]){
        int cur = n1;
        while(cur!=par[cur]){
            par[cur] = par[par[cur]];
            cur = par[cur];
        }
        return cur;
    }

    public boolean union(int n1, int n2, int par[], int rank[]){
        int p1 = find(n1,par,rank);
        int p2 = find(n2,par,rank);
        if(p1==p2) return false;
        if(rank[p1]>rank[p2]){
            par[p2] = p1;
            rank[p1]+=rank[p2];
        }
        else{
            par[p1] = p2;
            rank[p2]+=rank[p1];
        }
        return true;
    }
}

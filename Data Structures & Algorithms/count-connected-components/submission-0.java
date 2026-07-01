class Solution {
    public int countComponents(int n, int[][] edges) {
        int par[] = new int[n];
        int rank[] = new int[n];
        for(int i=0;i<n;i++){
            par[i] = i;
            rank[i] = 1;
        }
        int res = n;
        for(int edge[]:edges){
            res-= union(edge[0],edge[1],par,rank);
        }
        return res;
    }

    public int find(int node, int par[], int rank[]){
        int cur = node;
        while(cur!=par[cur]){
            par[cur] = par[par[cur]];
            cur = par[cur];
        }
        return cur;
    }

    public int union(int n1, int n2, int par[], int rank[]){
        int p1 = find(n1, par, rank);
        int p2 = find(n2, par, rank);
        if(p1==p2) return 0;
        if(rank[p1]>rank[p2]){
            par[p2] = p1;
            rank[p1]+=rank[p2];
        }
        else{
            par[p1] = p2;
            rank[p2]+=rank[p1];
        }
        return 1;
    }
}

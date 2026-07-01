class Solution {
    private int comps;
    public int countComponents(int n, int[][] edges) {
        comps = n;
        int parent[] = new int[n+1];
        int rank[] = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int edge[]:edges){
            union(edge[0],edge[1], parent, rank);
        }
        return comps;
    }

    public void union(int n1, int n2, int parent[], int rank[]){
        int p1 = find(n1, parent);
        int p2 = find(n2, parent);
        if(p1==p2) return;
        if(rank[p1]>=rank[p2]){
            parent[p2] = p1;
            rank[p1]+=rank[p2];
        }
        else{
            parent[p1] = p2;
            rank[p2]+=rank[p1];
        }
        comps--;
    }

    public int find(int p, int parent[]){
        int cur = p;
        while(cur!=parent[cur]){
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }
        return parent[cur];
    }
}

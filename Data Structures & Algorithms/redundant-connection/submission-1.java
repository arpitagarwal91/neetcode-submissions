class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;
        int parent[] = new int[n];
        int rank[] = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int edge[]:edges){
            if(union(edge[0],edge[1],parent,rank)) return edge;
        }
        return new int[]{-1,-1};
    }

    public boolean union(int n1, int n2, int parent[], int rank[]){
        int p1 = find(n1, parent);
        int p2 = find(n2, parent);
        if(p1==p2) return true;
        if(rank[p1]>rank[p2]){
            rank[p1]+=rank[p2];
            parent[p2] = p1;
        }
        else{
            rank[p2]+=rank[p1];
            parent[p1] = p2;
        }
        return false;
    }

    public int find(int n, int parent[]){
        int cur = n;
        while(cur!=parent[cur]){
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }
        return cur;
    }
}

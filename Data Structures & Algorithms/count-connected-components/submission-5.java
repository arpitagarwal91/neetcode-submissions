class Solution {
    public int countComponents(int n, int[][] edges) {
        int parent[] = new int[n+1];
        int rank[] = new int[n+1];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int[] edge:edges){
            if(union(edge[0], edge[1], parent, rank)) n--;
        }
        
        return n;
    }

    public boolean union(int n1, int n2, int parent[], int rank[]){
        int p1 = find(n1, parent);
        int p2 = find(n2, parent);
        if(p1==p2) return false;
        if(rank[p1]>rank[p2]){
            parent[p2] = p1;
            rank[p1]+=rank[p2];
        }
        else{
            parent[p1] = p2;
            rank[p2]+=rank[p1];
        }
        return true;
    }
    public int find(int n1, int parent[]){
        while(n1!=parent[n1]){
            parent[n1] = parent[parent[n1]];
            n1 = parent[n1];
        }
        return parent[n1];
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int rank[] = new int[edges.length+1];
        int parent[] = new int[edges.length+1];
        for(int i=0;i<edges.length+1;i++){
            rank[i] = 1;
            parent[i] = i;
        }
        for(int[] edge:edges){
            if(union(edge[0], edge[1], parent, rank)) return edge;
        }
        return new int[]{-1,-1};
    }

    public boolean union(int n1, int n2, int parent[], int rank[]){
        int p1 = find(n1, parent);
        int p2 = find(n2, parent);
        if(p1!=p2){
            if(rank[p1]>rank[p2]){
                parent[p2] = p1;
                rank[p1]+=rank[p2]; 
            }
            else{
                parent[p1] = p2;
                rank[p2]+=rank[p1];
            }
            return false;
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

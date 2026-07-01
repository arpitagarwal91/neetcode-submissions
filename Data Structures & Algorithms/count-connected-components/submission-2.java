class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = n;
        int parent[] = new int[n];
        int rank[] = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int edge[]:edges){
            count-=union(edge[0],edge[1],parent,rank);
        }
        return count;
    }

    public int union(int n1, int n2, int parent[], int rank[]){
        int p1 = find(n1, parent);
        int p2 = find(n2, parent);
        if(p1!=p2){
            if(rank[p1]>rank[p2]){
                rank[p1]+=rank[p2];
                parent[p2] = p1;
            }
            else{
                rank[p2]+=rank[p1];
                parent[p1] = p2;
            }
            return 1;
        }
        return 0;
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

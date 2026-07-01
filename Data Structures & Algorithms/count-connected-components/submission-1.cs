public class Solution {
    private int[] parent;
    private int[] rank;
    public int CountComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        int res = n;
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        foreach(int[] edge in edges){
            if(union(edge[0],edge[1])) res--;
        }
        return res;
    }

    public int find(int node){
        int cur = node;
        while(cur!=parent[cur]){
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }
        return cur;
    }

    public bool union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
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
}

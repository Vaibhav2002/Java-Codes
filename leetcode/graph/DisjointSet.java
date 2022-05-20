package leetcode.graph;

public class DisjointSet {

    int[] parent, rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;
    }

    public int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
    public void union(int u, int v){
        u = find(u);
        v = find(v);
        if(u == v) return;
        if(rank[u] == rank[v]){
            parent[u] = v;
            rank[v]++;
        }
        else if(rank[u]<rank[v]) parent[u] = v;
        else parent[v] = u;
    }
}

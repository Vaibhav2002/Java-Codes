package data_structures.dsu;

import java.util.Arrays;

public class DisjointSet {

    private final int[] parent, rank;
    private final int size;

    public DisjointSet(int n) {
        size = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public void union(int node1, int node2) {
        int parent1 = findParent(node1), parent2 = findParent(node2);
        if(parent1 == parent2) return;
        if (rank[parent1] == rank[parent2]) {
            parent[parent2] = parent1;
            rank[parent1]++;
        } else if (rank[parent1] > rank[parent2])
            parent[parent2] = parent1;
        else parent[parent1] = parent2;
    }

    public boolean inSameComponent(int node1, int node2) {
        return findParent(node1) == findParent(node2);
    }

    public int findParent(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }
}

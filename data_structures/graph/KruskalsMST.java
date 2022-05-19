package data_structures.graph;

import data_structures.dsu.DisjointSet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KruskalsMST {

    DisjointSet set;

    KruskalsMST(int n) {
        set = new DisjointSet(n);
    }

    private static class Node {
        int weight, u, v;

        public Node(int weight, int u, int v) {
            this.weight = weight;
            this.u = u;
            this.v = v;
        }
    }

    public ArrayList<Node> getMSt(ArrayList<Node> adj, int n) {
        adj.sort(Comparator.comparingInt((Node node) -> node.weight));
        ArrayList<Node> mst = new ArrayList<>();
        for (Node node : adj) {
            if (set.inSameComponent(node.u, node.v)) continue;
            set.union(node.u, node.v);
            mst.add(node);
        }
        return mst;
    }
}

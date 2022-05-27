package data_structures.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgorithm {

    private static class Node{
        int source, dest, weight;

        public Node(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public int getMinPathSum(int source, int dest, ArrayList<Node> edges, int n){
        int dist[] = getDistToAllNodes(source, edges, n);
        return dist[dest];
    }
    public boolean doesNegativeCycleExist(ArrayList<Node> edges, int n){
        var dist = getDistToAllNodes(0, edges, n);
        for(Node node:edges){
            if(dist[node.source]+ node.weight < dist[node.dest]) return true;
        }
        return false;
    }

    private int[] getDistToAllNodes(int source, ArrayList<Node> edges, int n){
        var dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        for(int i=0;i<n-1;i++){
            for(Node edge:edges){
                int len = dist[edge.source] + edge.weight;
                if(len < dist[edge.dest]){
                    dist[edge.dest] = len;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int n = 6;
        ArrayList<Node> adj = new ArrayList<>();
        adj.add(new Node(3, 2, 6));
        adj.add(new Node(5, 3, 1));
        adj.add(new Node(0, 1, 5));
        adj.add(new Node(1, 5, -3));
        adj.add(new Node(1, 2, -2));
        adj.add(new Node(3, 4, -2));
        adj.add(new Node(2, 4, 3));
        BellmanFordAlgorithm ob = new BellmanFordAlgorithm();
        System.out.println(Arrays.toString(ob.getDistToAllNodes(0, adj, n)));
        System.out.println(ob.doesNegativeCycleExist(adj, n));
    }
}

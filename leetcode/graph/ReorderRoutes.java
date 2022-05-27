package leetcode.graph;

import java.util.ArrayList;

public class ReorderRoutes {
//    public int minReorder(int n, int[][] connections) {
//    }
    private ArrayList<ArrayList<Integer>> getAdj(int[][] graph, int n){
        var adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] i:graph) adj.get(i[0]).add(i[1]);
        return adj;
    }
}

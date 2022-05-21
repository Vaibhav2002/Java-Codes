package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RedundantConnection {


    public int[] findRedundantConnection(int[][] edges) {
        int n = findNoOfNodes(edges);
        DisjointSet ob = new DisjointSet(n);
        for(int[] i:edges){
            if(ob.find(i[0]) == ob.find(i[1])) return i;
            ob.union(i[0], i[1]);
        }
        return new int[2];
    }

    private int findNoOfNodes(int[][] edges){
        int n = 0;
        for(int[] i:edges){
            n = Math.max(n, Math.max(i[0], i[1]));
        }
        return n;
    }
}

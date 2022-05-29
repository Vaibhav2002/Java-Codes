package gfg.graph;

import data_structures.dsu.DisjointSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberOfPairs {

    public static long numberOfPairs(int[] a, int[][] pairs) {
        int n = a[0];
        DisjointSet ob = new DisjointSet(n);
        for (int[] pair : pairs)
            ob.union(pair[0], pair[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = ob.findParent(i);
            map.merge(parent, 1, Integer::sum);
        }
        var keys = new ArrayList<Integer>(map.values());
        long sum = 0, sqSum = 0;
        for(Integer key:keys){
            sum+=key;
            sqSum+= (long) key * key;
        }
        return ((sum*sum) - sqSum)/2;
    }

}

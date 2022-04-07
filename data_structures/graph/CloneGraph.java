package data_structures.graph;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph {
    public ArrayList<ArrayList<Integer>> cloneAdjList(int V, ArrayList<ArrayList<Integer>> adj) {
        return new ArrayList<>(adj);
    }
}

package data_structures.graph;

import java.util.ArrayList;

public class adjacencyList {
    ArrayList<ArrayList<Integer>> ar;

    public adjacencyList(int v) {
        ar = new ArrayList<>(v);
        for (int i = 0; i < v; i++)
            ar.add(new ArrayList<>());
    }

    void add(int u, int v) {
        this.ar.get(u).add(v);
        this.ar.get(v).add(u);
    }

    void display() {
        for (int i = 0; i < ar.size(); i++) {
            System.out.print("Head : " + i + "-->");
            for (int j = 0; j < ar.get(i).size(); j++)
                System.out.print(ar.get(i).get(j) + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int v = 5;
        adjacencyList ob = new adjacencyList(v);
    }
}

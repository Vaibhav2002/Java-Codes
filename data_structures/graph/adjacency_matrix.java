package data_structures.graph;

import java.util.Arrays;

public class adjacency_matrix {
    int[][] a;
    //constructor
    adjacency_matrix(int v) {
        a = new int[v][v];
    }
    //function to add edge
    void add(int u, int v) {
        a[u][v] = a[v][u] = 1;
    }
    //utility function to display adjacency matrix
    void display() {
        for (int i = 0; i < a.length; i++) {
            System.out.print("Vertex: " + i + "-->");
            for (int j = 0; j < a[0].length; j++)
                if (a[i][j] == 1)
                    System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int v = 5; //no.of vertex
        adjacency_matrix ob = new adjacency_matrix(v);
        //adding edges
        ob.add(0, 1);
        ob.add(0, 4);
        ob.add(1, 2);
        ob.add(1, 3);
        ob.add(1, 4);
        ob.add(2, 3);
        ob.add(3, 4);
        //adding edges
        ob.display();
    }
}

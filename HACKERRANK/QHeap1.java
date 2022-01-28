package HACKERRANK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class QHeap1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        PriorityQueue<Integer> ob = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String y = br.readLine().trim();
            int x = Integer.parseInt(y.substring(0, 1));
            if (x == 1) {
                int v = Integer.parseInt(y.substring(2));
                ob.add(v);
            } else if (x == 2) {
                int z = Integer.parseInt(y.substring(2));
                ob.remove(z);
            } else if (x == 3) {
                System.out.println(ob.peek());
            }
        }
    }
}

package arraycodes;

import java.util.HashMap;

public class symmetricPair {
    void find(int[][] a) {
        HashMap<Integer, Integer> ob = new HashMap<>();
        for (int[] ints : a) {
            int x = ints[0], y = ints[1];
            if (ob.containsKey(y) && x == ob.get(y))
                System.out.println("Pair : (" + x + "," + y + ")");
            ob.put(x, y);
        }
    }

    public static void main(String[] args) {
        symmetricPair ob = new symmetricPair();
        int[][] a = {{11, 20}, {30, 40}, {5, 10}, {40, 30}, {10, 5}};
        ob.find(a);
    }
}

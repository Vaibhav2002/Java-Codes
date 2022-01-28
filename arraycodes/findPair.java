package arraycodes;

import java.util.HashMap;

public class findPair {
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    boolean find(int[] a) {
        HashMap<Integer, Pair> ob = new HashMap<>();
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int sum = a[i] + a[j];
                if (ob.containsKey(sum)) {
                    Pair p = ob.get(sum);
                    System.out.println("(" + p.x + "," + p.y + ") and (" + a[i] + "," + a[j] + ")");
                    return true;
                } else
                    ob.put(sum, new Pair(a[i], a[j]));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        findPair ob = new findPair();
        int[] a = {3, 5, 70, 1, 10, 9};
        if (!ob.find(a))
            System.out.println("No pairs found");
    }
}

package data_structures.graph;

import java.util.*;

public class SortByFreq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> hash = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int input = sc.nextInt();
                hash.merge(input, 1, Integer::sum);
            }
            List<Map.Entry<Integer, Integer>> l = new ArrayList<>(hash.entrySet());
            l.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
            for (Map.Entry<Integer, Integer> i : l)
                System.out.print(i.getKey() + " ");
            System.out.println();
        }
    }
}


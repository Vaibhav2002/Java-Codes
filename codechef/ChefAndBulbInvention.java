package codechef;

import java.util.*;
import java.util.stream.Collectors;

public class ChefAndBulbInvention {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt(), p = sc.nextInt(), k = sc.nextInt();
        TreeMap<Integer, HashSet<Integer>> ar = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int index = i % k;
            ar.computeIfAbsent(index, k1 -> new HashSet<>());
            ar.get(index).add(i);
        }
        int count = 0;
        for(Integer index:ar.keySet()){
            boolean contains = ar.get(index).contains(p);
            if(!contains) count+=ar.get(index).size();
            else {
                List<Integer> l = ar.get(index).stream().collect(Collectors.toList());
                Collections.sort(l);
                int pos = l.indexOf(p);
                count+=pos;
                break;
            }
        }
        System.out.println(count);
    }
}

package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class QueriesInArray {

    public static void main(String arge[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]), q = Integer.parseInt(s[1]);
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        var values = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < n; i++) {
            int val = values.get(i);
            map.computeIfAbsent(val, integer -> new ArrayList<>());
            map.get(val).add(i);
        }
        for (int i = 0; i < q; i++) {
            s = br.readLine().split(" ");
            int l = Integer.parseInt(s[0]), r = Integer.parseInt(s[1]), x = Integer.parseInt(s[2]);
            int count = 0;
            for (int j : map.keySet()) {
                if (j < x) continue;
                for (int k : map.get(j)) if (k >= l - 1 && k <= r - 1) count++;
            }
            System.out.println(count);
        }
    }
}

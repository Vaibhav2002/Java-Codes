package HACKERRANK;

import java.util.*;

public class ActiveTraders {
    public static List<String> mostActive(List<String> customers) {
        HashMap<String, Integer> hash = new HashMap<>();
        for (String s : customers) {
            hash.merge(s, 1, Integer::sum);
        }
        List<String> ans = new ArrayList<>();
        for (String s : hash.keySet()) {
            double trade_percent = (double) hash.get(s) / customers.size() * 100;
            if (trade_percent >= 5.0)
                ans.add(s);
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> s = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            s.add(sc.next());
        System.out.println(mostActive(s));
    }
}

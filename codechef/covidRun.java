package codechef;

import java.util.HashSet;
import java.util.Scanner;

public class covidRun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
            HashSet<Integer> ob = new HashSet<>();
            while (!ob.contains(x)) {
                if (x == y) {
                    System.out.println("YES");
                    break;
                }
                ob.add(x);
                x = (x + k) % n;
            }
            if (ob.contains(x))
                System.out.println("NO");
        }
    }
}

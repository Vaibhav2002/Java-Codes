package codechef;

import java.util.HashSet;
import java.util.Scanner;

public class TheOneWithTheLottery {

    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashSet<String> hash = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String x = sc.nextLine();
            hash.add(x);
        }
        System.out.println(hash.size());
    }
}

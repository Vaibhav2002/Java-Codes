package codechef;

import java.util.HashSet;
import java.util.Scanner;

public class HelpSanta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Integer x = sc.nextInt();
            hash.add(x);
        }
        for (Integer integer : hash) {
            System.out.print(integer + " ");
        }
    }
}

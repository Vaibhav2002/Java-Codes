package codechef;

import java.util.Scanner;

public class panagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int ob[] = new int[26];
            for (int i = 0; i < 26; i++) {
                ob[i] = sc.nextInt();
            }
            String s = sc.next().toLowerCase();
            for (int i = 0; i < s.length(); i++) {
                ob[s.charAt(i) - 'a'] = 0;
            }
            int sum = 0;
            for (int i : ob)
                sum += i;
            System.out.println(sum);
        }
    }
}
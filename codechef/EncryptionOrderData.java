package codechef;

import java.util.*;

public class EncryptionOrderData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            String[] words = s.split(" ");
            for (int i = 0; i < words.length; i++) {
                Map<Character, Integer> hash = new TreeMap<>();
                char[] c = words[i].toCharArray();
                for (int j = 0; j < c.length; j++) {
                    hash.put(c[i], i + 1);
                }
                for (char ch : hash.keySet())
                    System.out.print(ch);
                System.out.print(" ");
            }
        }
    }
}

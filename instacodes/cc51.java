package instacodes;

import java.util.HashMap;
import java.util.Scanner;

public class cc51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(), s1 = "";
        HashMap<Character, Boolean> ob = new HashMap<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isUpperCase(s.charAt(i))) {
                System.out.println("Uppercase not allowed");
                System.exit(0);
            }
            if (!ob.containsKey(s.charAt(i))) {
                s1 = s.charAt(i) + s1;
                ob.put(s.charAt(i), true);
            }
        }
        System.out.println(s1);
    }
}
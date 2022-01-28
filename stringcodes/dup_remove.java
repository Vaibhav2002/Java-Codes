package stringcodes;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class dup_remove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string");
        String s = sc.nextLine();
        StringBuilder s1 = new StringBuilder();
        Set<Character> ob = new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            ob.add(s.charAt(i));
        }
        System.out.println("Original string : " + s);
        for (char i : ob) {
            s1.append(i);
        }
        System.out.println("String after removing dupes : " + s1);
    }
}
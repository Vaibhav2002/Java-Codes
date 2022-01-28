package instacodes;

import java.util.Scanner;

public class cc47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string");
        String s = sc.next();
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            s1 += (Character.isUpperCase(ch))?(char)('Z' - ch + 'A'):(char)('z' - ch + 'a');
        }
        System.out.println(s1);
    }
}

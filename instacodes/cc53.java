package instacodes;

import java.util.Scanner;

public class cc53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(), s1 = "";
        int[] a = new int[26],b=new int[26];
        for (int i = 0; i < s.length(); i++)
            if (Character.isUpperCase(s.charAt(i)))
                a[s.charAt(i) - 65]++;
            else b[s.charAt(i) - 97]++;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))&&a[s.charAt(i)-65]==1)
                s1+=s.charAt(i)+""+s.charAt(i);
            else if (Character.isLowerCase(s.charAt(i))&&b[s.charAt(i)-97]==1)
                s1+=s.charAt(i)+""+s.charAt(i);
            else s1+=s.charAt(i);
        }
        System.out.println(s1);
    }
}

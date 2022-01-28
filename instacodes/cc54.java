package instacodes;

import java.util.Scanner;

public class cc54 {
    void count(String[] a) {
        int count = 0, total_length = 0;
        for (String s : a) {
            total_length+=s.length();
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isLetter(s.charAt(i))) {
                    System.out.println("Only Alpha Allowed");
                    return;
                } else if (Character.isUpperCase(s.charAt(i)))
                    count++;
            }
        }
        System.out.println((total_length==count)?"ALL":count);
    }

    public static void main(String[] args) {
        cc54 ob=new cc54();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter length");
        String[] a =new String[sc.nextInt()];
        for (int i = 0; i < a.length; i++)
            a[i]=sc.next();
        ob.count(a);
    }
}

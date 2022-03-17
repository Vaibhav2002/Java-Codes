package college;

import java.util.Scanner;

public class GDSCCP4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        int count = 0;
        char c[] = s.toCharArray();
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < len; j++) {
                sb.append(c[j]);
                if (sb.length() > 1 && isPalin(sb.toString()))
                    count++;
            }
        }
        System.out.println(count);

    }

    public static boolean isPalin(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) return false;
        }
        return true;
    }
}

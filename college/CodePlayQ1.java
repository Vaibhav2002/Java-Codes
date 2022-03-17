package college;

import java.util.Scanner;

public class CodePlayQ1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            char[] s = sc.nextLine().toCharArray();
            StringBuilder sb = new StringBuilder();
            sb.append(s[0]);
            for (int i = 1; i < s.length; i++) {
                int val = Integer.parseInt(s[i] + "");
                val = (val * val) % 10;
                sb.append(val);
            }
            int Integer = 0;
            System.out.println(Integer);
        }
    }
}

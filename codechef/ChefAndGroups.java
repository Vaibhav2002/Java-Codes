package codechef;

import java.util.Scanner;

public class ChefAndGroups {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int count = 0;
            int c = 0;
            String s = sc.next();
            for (char ch : s.toCharArray()) {
                if (c == 0) {
                    if (ch == '1')
                        c++;
                } else {
                    if (ch == '0') {
                        c = 0;
                        count++;
                    }
                }
            }
            if (c == 1)
                count++;
            System.out.println(count);
        }
    }
}

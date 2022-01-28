package codechef;

import java.util.Scanner;

public class EncodedString {

    static char findChar(String s) {
        int l = 97, r = 112;
        for (int i = 0; i < 3; i++) {
            int mid = (l + r) / 2;
            if (s.charAt(i) == '1')
                l = mid + 1;
            else
                r = mid;
        }
        if (s.charAt(3) == '1')
            return (char) r;
        else
            return (char) l;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i += 4) {
                ans.append(findChar(s.substring(i, i + 4)));
            }
            System.out.println(ans);
        }
    }
}

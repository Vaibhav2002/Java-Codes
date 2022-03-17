package college;

import java.util.HashSet;
import java.util.Scanner;

public class GDSCCP1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0) {
            n++;
            if (isDistinct(n)) {
                System.out.println(n);
                break;
            }

        }

    }

    public static boolean isDistinct(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while (n > 0) {
            int r = n % 10;
            n /= 10;
            if (set.contains(r)) return false;
            set.add(r);
        }
        return true;
    }
}

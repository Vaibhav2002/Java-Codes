package college;

import java.util.Scanner;

public class GDSCCP5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), h = sc.nextInt();
        int width = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x > h) width++;
            width++;
        }
        System.out.println(width);
    }
}

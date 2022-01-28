package rcctechz;

import java.util.Scanner;

public class IsoscelesTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        s = s.replace(" ", "");
        for (int i = 0; i < n; i++) {
            for (int j = n-i; j > 1; j--)
                System.out.print(" ");
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print(s.charAt(j % s.length()));
            }
            System.out.println();
        }
    }
}

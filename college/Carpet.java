package college;

import java.util.Scanner;

public class Carpet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(), column = sc.nextInt();
        Carpet ob = new Carpet();
        ob.carpet2(row, column);
//        for (int i = 0; i < row / 2; i++) {
//            int start = 3 * (row / 2 - i);
//            for (int j = 0; j < start; j++)
//                System.out.print('-');
//            for (int j = 0; j < 2 * i + 1; j++)
//                System.out.print(".|.");
//            for (int j = 0; j < start; j++)
//                System.out.print('-');
//            System.out.println();
//        }
//        int mid = column - 7;
//        for (int i = 0; i < mid / 2; i++)
//            System.out.print('-');
//        System.out.print("WELCOME");
//        for (int i = 0; i < mid / 2; i++)
//            System.out.print('-');
//        System.out.println();
//        for (int i = row / 2 - 1; i >= 0; i--) {
//            int start = 3 * (row / 2 - i);
//            for (int j = 0; j < start; j++)
//                System.out.print('-');
//            for (int j = 0; j < 2 * i + 1; j++)
//                System.out.print(".|.");
//            for (int j = 0; j < start; j++)
//                System.out.print('-');
//            System.out.println();
//        }

    }

    public void carpet2(int n, int m) {
        for (int i = 0; i < n / 2; i++) {
            int middle = 2 * i + 1;
            int left = (m - 3 * (2 * i + 1)) / 2;
            int right = m - 3 * middle - left;
            for (int j = 0; j < left; j++) {
                System.out.print('-');
            }
            for (int j = 0; j < middle; j++) {
                System.out.print(".|.");
            }
            for (int j = 0; j < right; j++) {
                System.out.print('-');
            }
            System.out.println();
        }
        for (int i = 0; i < (m - 7) / 2; i++)
            System.out.print("-");
        System.out.print("WELCOME");
        for (int i = 0; i < (m - 7) / 2; i++)
            System.out.print("-");
        System.out.println();
        for (int i = n / 2 - 1; i >= 0; i--) {
            int middle = 2 * i + 1;
            int left = (m - 3 * (2 * i + 1)) / 2;
            int right = m - 3 * middle - left;
            for (int j = 0; j < left; j++) {
                System.out.print('-');
            }
            for (int j = 0; j < middle; j++) {
                System.out.print(".|.");
            }
            for (int j = 0; j < right; j++) {
                System.out.print('-');
            }
            System.out.println();
        }
    }

}

package codeJam;

import java.util.Arrays;
import java.util.Scanner;

public class Printing3D {
    private static Scanner sc = new Scanner(System.in);

    private static int[][] takeColorInput() {
        int[][] colors = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                colors[i][j] = sc.nextInt();
            }
        }
        return colors;
    }

    private static int[] getMinColors(int[][] colors) {
        int mins[] = new int[4];
        Arrays.fill(mins, Integer.MAX_VALUE);
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++) mins[j] = Math.min(mins[j], colors[i][j]);
        }
        return mins;
    }

    private static void printAns(int[] ans, int testCase) {
        System.out.print("Case #" + testCase + ": ");
        for (int an : ans) System.out.print(an + " ");
        System.out.println();
    }

    private static int countNonZero(int[] a){
        int count = 0;
        for(int i:a) if(i!=0) count++;
        return count;
    }

    private static void solve(int testCase) {
        int total = 1000000;
        int[][] colors = takeColorInput();
        int[] mins = getMinColors(colors);
        int[] ans = new int[4];
        if (mins[0] + mins[1] + mins[2] + mins[3] < total) {
            System.out.println("Case #" + testCase + ": " + "IMPOSSIBLE");
            return;
        }
        while (total > 0) {
            int bef = total;
            int eq = total / countNonZero(mins);
            for (int i = 0; i < 4; i++) {
                if (mins[i] < eq) {
                    ans[i] += mins[i];
                    total -= mins[i];
                    mins[i] = 0;
                } else {
                    ans[i] += eq;
                    total -= eq;
                    mins[i] -= eq;
                }
            }
            if (total == bef) break;
        }
        if (total == 0) {
            printAns(ans, testCase);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (mins[i] < total) {
                ans[i] += mins[i];
                total -= mins[i];
                mins[i] = 0;
            } else {
                ans[i] += total;
                total -= total;
                mins[i] -= total;
                break;
            }
        }
        if (total == 0) printAns(ans, testCase);
        else System.out.println("Case #" + testCase + ": " + "IMPOSSIBLE");
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++)
            solve(i);
    }
}

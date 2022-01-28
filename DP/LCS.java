package DP;

import java.util.Scanner;

//this program finds the longest common subsequence using Dynamic Programming
public class LCS {
    static String s2 = "";

    static int LCS(char[] s, char[] s1, int n, int m) { //to return length of LCS
        int[][] d = new int[n + 1][m + 1]; //create a 2-D matrix of size of both strings + 1
        int max = 0; //to store length
        for (int i = 1; i < n + 1; i++) {  //leave 1st row and column as it is with value 0
            for (int j = 1; j < m + 1; j++) {
                if (s[i - 1] == s1[j - 1]) { //if characters are same value of that cell is 1 + value of cell diagonally above it
                    d[i][j] = 1 + d[i - 1][j - 1];
                } else //if characters are not same the value is max of its left cell and the cell just above it
                    d[i][j] = Math.max(d[i][j - 1], d[i - 1][j]);
                if (d[i][j] > max)  //if value increases save in max
                    max = d[i][j];
            }
        }
        return max;
    }

    static int LCSubstring(char[] s, char[] s1, int n, int m) { //to return length of LCS
        int d[][] = new int[n + 1][m + 1]; //create a 2-D matrix of size of both strings + 1
        int max = 0; //to store length
        for (int i = 1; i < n + 1; i++) {  //leave 1st row and column as it is with value 0
            for (int j = 1; j < m + 1; j++) {
                if (s[i - 1] == s1[j - 1]) { //if characters are same value of that cell is 1 + value of cell diagnolly above it
                    d[i][j] = 1 + d[i - 1][j - 1];
                } else //if characters are not same the value is max of its left cell and the cell just above it
                    d[i][j] = 0;
                if (d[i][j] > max)
                    max = d[i][j];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = LCS(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());

        System.out.println(result);
        System.out.println(s2);

        scanner.close();
    }
}



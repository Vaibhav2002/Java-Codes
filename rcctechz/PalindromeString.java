package rcctechz;

import java.util.Scanner;

public class PalindromeString {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int pointA = 0, pointB = 0;
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine(), s2 = sc.nextLine();
            if (isPalindrome(s1)) pointA++;
            if (isPalindrome(s2)) pointB++;
        }
        if (pointA == pointB)
            System.out.println("The game is drawn.");
        else {
            String winnerName = (pointA > pointB) ? "Ramesh" : "Suresh";
            System.out.println(winnerName + " won the game.");
        }
    }
}

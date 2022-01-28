package HACKERRANK;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class palindromeIndex {

    // Complete the palindromeIndex function below.
    static int palindromeindex(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                if (palin(s.substring(i + 1, s.length() - i)))
                    return i;
                else
                    return s.length() - i - 1;
            }
        }
        return -1;
    }

    private static boolean palin(String substring) {
        for (int i = 0; i < substring.length() / 2; i++)
            if (substring.charAt(i) != substring.charAt(substring.length() - 1 - i))
                return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();
            int result = palindromeindex(s);
            System.out.println(result);
        }


        scanner.close();
    }
}


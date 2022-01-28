package HACKERRANK;

import java.util.Scanner;

public class TimeInWords {
    static String timeInWords(int h, int m) {
        String[] digit = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",};
        String[] tens = {"", "ten", "twenty"};
        if (m == 0)
            return digit[h] + " o' clock";
        if (m == 15)
            return "quarter past " + digit[h];
        if (m == 30)
            return "half past " + digit[h];
        if (m == 45)
            return "quarter to " + digit[h + 1];
        if (m < 30) {
            if (m == 1)
                return "one minute past " + digit[h];
            else if (m < 20) {
                return digit[m] + " minutes past " + digit[h];
            } else
                return tens[m / 10] + " " + digit[m % 10] + " minutes past " + digit[h];
        } else {
            if (60 - m == 1)
                return "1 minute to " + digit[h + 1];
            if (60 - m < 20) {
                return digit[60 - m] + " minutes to " + digit[h + 1];
            } else
                return tens[(60 - m) / 10] + " " + digit[(60 - m) % 10] + " minutes to " + digit[h + 1];
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(), m = sc.nextInt();
        System.out.println(timeInWords(h, m));
    }
}

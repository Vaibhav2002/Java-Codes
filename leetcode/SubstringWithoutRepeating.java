package leetcode;

import java.util.Scanner;

public class SubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder s1 = new StringBuilder();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s1.toString().indexOf(s.charAt(i)) != -1) {
                s1 = new StringBuilder(s1.substring(s1.toString().indexOf(s.charAt(i)) + 1));
            }
            s1.append(s.charAt(i));
            max = Math.max(max, s1.length());
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(new SubstringWithoutRepeating().lengthOfLongestSubstring(s));
    }
}

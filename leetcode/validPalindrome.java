package leetcode;

public class validPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (!Character.isLetter(s.charAt(l)) && !Character.isDigit(s.charAt(l)))
                l++;
            else if (!Character.isLetter(s.charAt(r)) && !Character.isDigit(s.charAt(r)))
                r--;
            else {
                if (s.charAt(l) != s.charAt(r))
                    return false;
                else {
                    l++;
                    r--;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "race a car";
        validPalindrome ob = new validPalindrome();
        System.out.println(ob.isPalindrome(s) ? "Palindrome" : "Not palindrome");
    }
}

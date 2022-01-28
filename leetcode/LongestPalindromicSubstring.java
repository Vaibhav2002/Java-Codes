package leetcode;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        StringBuilder newS = new StringBuilder("$");
        for (char c : s.toCharArray())
            newS.append(c).append("#");
        newS.deleteCharAt(newS.length() - 1);
        newS.append("$");
        String st = newS.toString();
        int[] val = new int[st.length()];
        int R = 0, C = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (ch == '$')
                continue;
            int mir = 2 * C - 1;
            if (val[i] + i < R)
                val[i] = Math.min(val[mir], val[R-i]);
            int j = i - val[i], k = i + val[i];
            while (k < st.length() && j >= 0 && st.charAt(j) == st.charAt(k)) {
                j--;
                k++;
                R++;
            }
        }
        return "";
    }
}


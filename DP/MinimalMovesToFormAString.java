package DP;

public class MinimalMovesToFormAString {
    int minSteps(String S) {
        return calc(0, "", S);
    }

    int calc(int i, String formed, String left) {
        if (i >= left.length()) return 0;
        int ans = calc(i + 1, formed+left.charAt(i), left);
        if (i!=0 && left.substring(i, i * 2).equals(formed))
            ans = Math.min(ans, calc(i*2, formed+formed, left));
        return 1 + ans;
    }
}
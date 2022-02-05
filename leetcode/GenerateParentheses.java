package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        var ans = new ArrayList<String>();
        form(n, "", 0, 0, ans);
        return ans;
    }

    public void form(int n, String formed, int openingCount, int closingCount, List<String> s) {
        if (formed.length() == 2*n) {
            if (closingCount == openingCount)
                s.add(formed);
            return;
        }
        form(n, formed + '(', openingCount + 1, closingCount, s);
        if (!formed.isEmpty() && openingCount > closingCount)
            form(n, formed + ')', openingCount, closingCount + 1, s);
    }
}

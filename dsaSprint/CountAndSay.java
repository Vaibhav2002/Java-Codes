package dsaSprint;

public class CountAndSay {

    String say(String s) {
        char c[] = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            int count = 1, j = i + 1;
            while (j < c.length && c[j] == c[i]) {
                count++;
                j++;
            }
            ans.append(count).append(c[i]);
            i = j - 1;
        }
        return ans.toString();
    }

    public String countAndSay(int n) {
        String ans = "1";
        for (int i = 2; i <= n; i++) {
            ans = say(ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        CountAndSay ob = new CountAndSay();
        System.out.println(ob.countAndSay(5));
    }
}

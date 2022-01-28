package foobar;

import java.math.BigInteger;

public class BombBaby {

    public static String solution(String x, String y) {
        if (x.equals("1") && y.equals("1")) return "0";
        BigInteger a = new BigInteger(x), b = new BigInteger(y);
        return check(a, b);
    }

    public static String check(BigInteger a, BigInteger b) {
        BigInteger ans = BigInteger.ZERO;
        BigInteger max = a.compareTo(b) > 0 ? a : b;
        BigInteger min = a.compareTo(b) < 0 ? a : b;
        while (min.compareTo(BigInteger.ZERO) > 0) {
            ans = ans.add(max.divide(min));
            BigInteger temp = BigInteger.valueOf(min.longValue());
            min = max.mod(min);
            max = temp;
        }
        if (!max.equals(BigInteger.ONE)) return "impossible";
        ans = ans.subtract(BigInteger.ONE);
        char x = 'a';
        int val = x;
        System.out.println(val);
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("4", "7"));
    }

}

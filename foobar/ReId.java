package foobar;

public class ReId {

    public static boolean checkPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    public static String formPrimeString() {
        String s = "";
        for (int i = 2; s.length() <= 100005; i++)
            if (checkPrime(i)) s += i;
        return s;
    }

    public static String solution(int i) {
        String s = formPrimeString();
        return s.substring(i, i + 5);
    }

    public static void main(String[] args) {
        System.out.println(solution(10000));
    }
}

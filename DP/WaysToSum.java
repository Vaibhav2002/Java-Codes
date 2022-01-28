package DP;

public class WaysToSum {

    int count;
    int limit;

    boolean calcCount(int n) {
        if (n < 0) return false;
        if (n == 0) {
            count++;
            return true;
        }
        boolean found = false;
        for (int i = 1; i <limit; i++) {
            if (calcCount(n - i))
                found = true;
        }
        return found;
    }

    int countWays(int n) {
        count = 0;
        limit = n;
        calcCount(n);
        return count;
    }

    public static void main(String[] args) {
        WaysToSum ob = new WaysToSum();
        System.out.println(ob.countWays(3));
    }

}

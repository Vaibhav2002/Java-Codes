package codechef;

import java.math.BigInteger;
import java.util.Scanner;

public class TeamStrength {
    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            BigInteger x = new BigInteger(sc.next()), y = new BigInteger(sc.next());
            BigInteger n = x.divide(y).abs();
            BigInteger ans = n.divide(BigInteger.TWO);
            ans=ans.multiply((y.multiply(BigInteger.TWO)).add((n.subtract(BigInteger.ONE)).multiply(y)));
            System.out.println(ans);
        }
    }
}

package codechef;

import java.util.Scanner;

public class BuyChocolates {
    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long x = sc.nextLong(), y = sc.nextLong(), z = sc.nextLong();
            long countChoco = x / z + y / z, countMoney = 0;
            long xRem = x % z, yRem = y % z;
            if (xRem == 0 && yRem == 0)
                System.out.println(countChoco+" "+countMoney);
            else {
                if (xRem < yRem && y >= xRem) {
                    countMoney = xRem;
                    countChoco++;
                } else if (yRem < xRem && x >= yRem) {
                    countMoney = yRem;
                    countChoco++;
                }
                System.out.println(countChoco+" "+countMoney);
            }
        }
    }
}


package codechef;

import java.util.Scanner;

public class SheldonVsKripke {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mH = sc.nextInt(), mS = sc.nextInt();
        int kH = sc.nextInt(), kS = sc.nextInt();
        int timesTakenForM = kH / mS;
        if (kH % mS > 0) timesTakenForM++;
        int timesTakenForK = mH / kS;
        if (mH % kS > 0) timesTakenForK++;
        System.out.println((timesTakenForM <= timesTakenForK) ? "YES" : "NO");
    }
}

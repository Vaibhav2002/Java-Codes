package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TurnIT {
    public static void main(String arge[]) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int t = sc.read();
        while (t-- > 0) {
            int u=sc.read();
            int v=sc.read();
            int a=sc.read();
            int s=sc.read();
            long ans=u*u+ (2*a*s);
            ans=(int)Math.sqrt(ans);
            System.out.println(ans<=v?"Yes":"No");
        }
    }

}

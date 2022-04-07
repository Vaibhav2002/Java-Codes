package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * <a href = "https://www.codechef.com/problems/ODDSUM">CodeChef Link</a>
 */
public class OddSum {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int ans =1;
        if(n>1) ans+=2*(n-2);
        System.out.println(ans);
    }
}


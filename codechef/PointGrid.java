package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PointGrid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long a[] = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                a[i] = Long.parseLong(st.nextToken());
            long ans = a[0];
            for (int i = 1; i < n; i++) {
                if (a[i - 1] < a[i])
                    ans += a[i] - a[i - 1];
                else
                    ans++;
            }
            System.out.println(ans);
        }
    }
}

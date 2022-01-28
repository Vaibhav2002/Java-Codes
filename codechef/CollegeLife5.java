package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CollegeLife5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n, m;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            TreeMap<Long, Boolean> map = new TreeMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                long fi = Long.parseLong(st.nextToken());
                map.put(fi, true);
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                long ci = Long.parseLong(st.nextToken());
                map.put(ci, false);
            }
            boolean isFootball = true;
            long ans = 0;
            for (long key : map.keySet()) {
                if (map.get(key) != isFootball) {
                    ans++;
                    isFootball = !isFootball;
                }
            }
            System.out.println(ans);
        }
    }
}

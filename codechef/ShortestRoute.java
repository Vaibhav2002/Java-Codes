package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ShortestRoute {

    public static void main(String arge[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            int[] trains = new int[n], destination = new int[m];
            st = new StringTokenizer(br.readLine());
            int c = 0;
            while (st.hasMoreTokens())
                trains[c++] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            c = 0;
            while (st.hasMoreTokens())
                destination[c++] = Integer.parseInt(st.nextToken());
            int[] stationBefore = new int[n + 1], stationAfter = new int[n + 1];
            stationBefore[1] = -1;
            stationAfter[n] = -1;
            for (int i = 1; i < n; i++) {
                if (trains[i - 1] == 1) {
                    stationBefore[i + 1] = i;
                } else
                    stationBefore[i + 1] = stationBefore[i];
                if (trains[n - 1] == 2) {
                    stationAfter[n - i] = n - i + 1;
                } else {
                    stationAfter[n - i] = stationAfter[n - i + 1];
                }
            }
            for (int i : destination) {
                int ans;
                if (i == 1)
                    ans = 0;
                else {
                    if (stationAfter[i] == -1 && stationBefore[i] == -1)
                        ans = -1;
                    else if (stationAfter[i] != -1)
                        ans = stationAfter[i] - i;
                    else if(stationBefore[i]!=-1)
                        ans = i - stationBefore[i];
                    else
                        ans =Math.min(stationAfter[i] - i, i - stationBefore[i]);

                }
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }
}

package HACKERRANK;

import java.math.BigInteger;
import java.util.Scanner;

public class acm_icpc {
    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        BigInteger b[] = new BigInteger[topic.length];
        for (int i = 0; i < topic.length; i++)
            b[i] = new BigInteger(topic[i],2);
        int res[] = new int[2];
        int max = 0;
        for (int i = 0; i < b.length - 1; i++) {
            for (int j = i + 1; j < b.length; j++) {
                BigInteger bin = b[i].or(b[j]);
                int val = bin.bitCount();
                if (val > max) {
                    max = val;
                    res[0] = val;
                    res[1] = 1;
                }
                if (val == max)
                    res[1]++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            System.out.println(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.println();
            }
        }

        scanner.close();
    }
}




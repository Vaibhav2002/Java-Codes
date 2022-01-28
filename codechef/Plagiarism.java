package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Plagiarism {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] values = br.readLine().split(" ");
            HashSet<Integer> hash = new HashSet<>();
            TreeSet<Integer> users = new TreeSet<>();
            String[] l = br.readLine().split(" ");
            for (String s : l) {
                int lValue = Integer.parseInt(s);
                if (lValue <= Integer.parseInt(values[0])) {
                    if (hash.contains(lValue))
                        users.add(lValue);
                    hash.add(lValue);
                }
            }
            System.out.print(users.size() + " ");
            for (int i : users)
                System.out.print(i + " ");
            System.out.println();
        }

    }
}

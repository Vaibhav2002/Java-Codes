package HACKERRANK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class leaderboard {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> res = new ArrayList<>();
        // Write your code here
        int c = 1;
        List<Integer> rank = new ArrayList<>();
        rank.add(1);
        for (int i = 1; i < ranked.size(); i++) {
            if (ranked.get(i) == ranked.get(i - 1))
                rank.add(c);
            else
                rank.add(++c);
        }
        for (int i : player) {
            if (i < ranked.get(ranked.size() - 1))
                res.add(c + 1);
            else if (i > ranked.get(0))
                res.add(1);
            else {
                int pos = getPos(ranked,i);
                res.add(rank.get(pos));
            }
        }
        return res;
    }

    static int getPos(List<Integer> r, int i) {
        int l = 0, u = r.size() - 1;
        while (l < u) {
            int mid = l + (u - l) / 2;
            if(r.get(mid)==i)
                return mid;
            if (r.get(mid) < i && r.get(mid - 1) > i)
                return mid;
            else if (r.get(mid) > i && r.get(mid + 1) <= i)
                return mid + 1;
            else if (r.get(mid) > i)
                l = mid + 1;
            else
                u = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> board =new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            board.add(sc.nextInt());
        int m=sc.nextInt();
        List<Integer> score =new ArrayList<>(m);
        for (int i = 0; i < m; i++)
            score.add(sc.nextInt());
        List<Integer> ans=climbingLeaderboard(board,score);
        System.out.println(ans.toString());

    }
}

package codechef;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class KnightToCell {

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean isSame(Pair dest) {
            return this.x == dest.x && this.y == dest.y;
        }

        Pair nextMoveToX() {
            return new Pair(x + 2, y + 1);
        }

        Pair nextMoveToY() {
            return new Pair(x + 1, y + 2);
        }
    }

    private final static long MOD = (long) Math.pow(10, 9) + 7;

    public static long solution(int a, int b) {
        HashMap<Pair, Long> map = new HashMap<>();
        return find(new Pair(0, 0), new Pair(a, b), map);
    }

    public static long find(Pair cord, Pair dest, HashMap<Pair, Long> map) {
        if (cord.isSame(dest)) return 1;
        if (cord.x >= dest.x || cord.y >= dest.y) return 0;
        if (map.containsKey(cord)) return map.get(cord);
        long move1 = find(cord.nextMoveToX(), dest, map);
        long move2 = find(cord.nextMoveToY(), dest, map);
        map.put(cord, (move1 + move2) % MOD);
        return map.get(cord);
    }

    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.println(solution(a, b));
    }


}

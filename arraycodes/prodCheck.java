package arraycodes;

import java.util.HashSet;

public class prodCheck {
    boolean count(int a[], int k) {
        if(a.length<2)
            return false;
        HashSet<Integer> ob = new HashSet<>();
        for (int i : a) {
            if (i == 0) {
                if (k == 0)
                    return true;
                else
                    continue;
            }
            if (k % i == 0 && ob.contains(k / i))
                return true;
            ob.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        prodCheck ob = new prodCheck();
        int[] a = {0};
        int x = 0;
        System.out.println(ob.count(a, x));
    }
}

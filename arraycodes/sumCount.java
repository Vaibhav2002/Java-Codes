package arraycodes;

import java.util.HashSet;

public class sumCount {
    int count(int a[], int x) {
        int count = 0;
        HashSet<Integer> ob = new HashSet<>();
        for (int i : a) {
            if (ob.contains(x - i))
                count++;
            else
                ob.add(i);
        }
        return count;
    }

    public static void main(String[] args) {
        sumCount ob=new sumCount();
        int a[]={1,1,1,1};
        int x=2;
        System.out.println(ob.count(a,x));
    }
}

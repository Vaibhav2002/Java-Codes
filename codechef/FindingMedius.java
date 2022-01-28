package codechef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindingMedius {

    static void findMedian(List<Integer> a) {
        List<Integer> b = new ArrayList<>(a);
        Collections.sort(b);
        if (b.size() % 2 != 0)
            System.out.print(b.get(b.size() / 2) + " ");
        else
            System.out.print((b.get(b.size() / 2) + (double) b.get(b.size() / 2 - 1)) / 2 + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        List<Integer> list = new ArrayList<>(k);
        for (int i = 0; i < k; i++)
            list.add(a[i]);
        findMedian(list);
        for (int i = k; i < n; i++) {
            list.remove(0);
            list.add(a[i]);
            findMedian(list);
        }
    }
}

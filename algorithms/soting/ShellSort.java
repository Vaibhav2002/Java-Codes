package algorithms.soting;

import java.util.Arrays;
import java.util.Scanner;

public class ShellSort {
    public void sort(int[] a) {
        int gap = (int)Math.ceil(a.length/2.0);
        while(gap!=0){
            sort(a, gap);
            gap/=2;
        }
    }

    private void sort(int[] a, int gap) {
        for (int i = gap; i < a.length; i++)
            if (a[i - gap] > a[i]) swap(a, i - gap, i);
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++) a[i] = sc.nextInt();
        new ShellSort().sort(a);
        System.out.println(Arrays.toString(a));
    }
}

package dsaSprint;

import java.util.Arrays;

public class TripletSum {

    public static boolean find3Numbers(int a[], int n, int x) {

        Arrays.sort(a);
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n-1;
            while(j<k){
                if(a[i]+a[j]+a[k] == x)
                    return true;
                if(a[i]+a[j]+a[k]<x)
                    j++;
                else
                    k--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int a[] = {1,4,45,6,10,8};
        int x =13;
        System.out.println(find3Numbers(a, a.length, x));
    }
}

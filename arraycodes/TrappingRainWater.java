package arraycodes;

import java.util.Scanner;

public class TrappingRainWater {
    static int trappingWater(int a[], int n) {
        int maxArea=Integer.MIN_VALUE;
        int i=0,j=n-1;
        while(i<j){
            maxArea=Math.max(maxArea,(Math.min(a[i],a[j])*(j-i+1)));
            if(a[i]<a[j])
                i++;
            else
                j--;
        }
    return maxArea;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(trappingWater(a, n));
    }
}

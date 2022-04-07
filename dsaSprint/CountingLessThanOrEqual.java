package dsaSprint;

import java.util.ArrayList;

public class CountingLessThanOrEqual {
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
        var ans = new ArrayList<Integer>();
        for(int i:arr1){
            ans.add(find(arr2, i, n)+1);
        }
        return ans;
    }

    private static int find(int arr[], int k, int n){
        int l = 0, u = n, mid = 0;
        while(l<u){
            mid = l+(u-l)/2;
            if(arr[mid] <= k) {
                if(mid<n-1 && arr[mid+1]>k) return mid;
                l = mid+1;
            }
            else u = mid;
        }
        return mid;
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 1, 2, 4};
        System.out.println(find(arr, 3, arr.length));
    }
}

package dsaSprint;

public class FarthestNumber {
    static int[] farNumber(int n, int a[])
    {
        int[] ans = new int[n];
        int[] sufMin = new int[n];
        sufMin[n-1] = a[n-1];
        for(int i=n-2;i>=0;i--)
            sufMin[i] = Math.min(a[i], sufMin[i+1]);
        for(int i=0;i<n;i++){
            int farthestMin = findFarthestMin(i+1, n-1, sufMin, a[i]);
            ans[i] = farthestMin;
        }
        return ans;
    }

    private static int findFarthestMin(int l, int u, int a[], int k){
        int ans = -1;
        while(l<=u){
            int mid = l+(u-l)/2;
            if(a[mid]<k){
                ans = mid;
                l = mid+1;
            }
            else u = mid-1;
        }
        return ans;
    }
}

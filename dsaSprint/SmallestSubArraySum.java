package dsaSprint;

/**
 * Problem is to solve the smallest sub array with a sum that is greater than a given value k
 * Time - O(N)
 * Space - O(1)
 */
public class SmallestSubArraySum {

    public static long sb(long a[], long n, long x) {
        if(a[0]>=x)
            return 1;
        for(int i=1;i<n;i++){
            if(a[i]>=x)
                return 1;
            a[i]+=a[i-1];
        }
        for(int i=1;i<n;i++){
            if(a[i]==x)
                return i+1;
        }
        return 1;
    }

}

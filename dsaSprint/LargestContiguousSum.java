package dsaSprint;

public class LargestContiguousSum {

    public static void getSum(int[] a, int n){
        int sum = a[0];
        int ans = a[0];
        for(int i=1;i<n;i++){
            sum = Math.max(sum+a[i],a[i]);
            ans = Math.max(ans,sum);

        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        getSum(new int[]{1,2,3,-2,5}, 5);
    }
}

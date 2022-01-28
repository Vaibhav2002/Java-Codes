package arraycodes;

import java.util.Arrays;

public class EquilibriumPoint {
    public static int equilibriumPoint(long arr[], int n) {
        long[] prefixSum=new long[n],postfixSum=new long[n];
        int prefix=0,postfix=0;
        for(int i=0;i<n;i++){
            prefix+=arr[i];
            postfix+=arr[n-i-1];
            prefixSum[i]=prefix;
            postfixSum[n-i-1]=postfix;
        }
        for(int i=0;i<n;i++)
            if(postfixSum[i]==prefixSum[i])
                return i+1;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(equilibriumPoint(new long[]{1,3,5,2,2},5));
    }
}

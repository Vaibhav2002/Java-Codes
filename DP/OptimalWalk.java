package DP;

public class OptimalWalk {
    static long optimalWalk(long N, long A, long B)
    {
        return find(0, N, A, B);
    }

    static long find(long i, long N, long A, long B){
        if(i == N) return 0;
        long ans = A+find(i+1, N, A, B);
        ans = Math.min(ans, A+find(i-1, N, A, B));
        ans = Math.min(ans, B+find(i*2, N, A, B));
        return ans;
    }
}

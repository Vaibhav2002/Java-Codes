package dsaSprint;

import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistributionProblem {

    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        Collections.sort(a);
        long ans = Long.MAX_VALUE;
        int start = 0,end = (int)m-1;
        while(end<a.size()){
            ans = Math.min(ans, a.get(end++)- a.get(start++));
        }
        return ans;
    }
}

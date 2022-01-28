package dsaSprint;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;

public class LargeFactorial {

    static ArrayList<Integer> factorial(int N){
        BigInteger f = BigInteger.ONE;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=1;i<=N;i++){
            f = f.multiply(BigInteger.valueOf(i));
        }
        String s = f.toString();
        for(char c:s.toCharArray()){
            ans.add(Integer.valueOf(c + ""));
        }
        return ans;
    }
}

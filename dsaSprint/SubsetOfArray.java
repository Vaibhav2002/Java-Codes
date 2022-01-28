package dsaSprint;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class SubsetOfArray {

    public String isSubset( long a1[], long a2[], long n, long m) {
        HashSet<Long> set = new HashSet<>();
        for(long i:a1)
            set.add(i);
        boolean isSubset = true;
        for(long i:a2){
            if(!set.contains(i)){
                isSubset = false;
                break;
            }
        }
        return isSubset ? "Yes":"No";
    }

    public static void main(String[] args) {
        long a[] = {11, 1, 13, 21, 3, 7};
        long a2[] = {11, 3, 7, 1};
        SubsetOfArray ob = new SubsetOfArray();
        System.out.println(ob.isSubset(a,a2,a.length,a2.length));
    }

}

package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Sum4 {


    public ArrayList<ArrayList<Integer>> fourSum(int[] a, int target) {
        var ans = new ArrayList<ArrayList<Integer>>();
        if(a.length<4)
            return ans;
        Arrays.sort(a);
        for(int i=0;i<=a.length-4;i++){
            for(int j=i+1;j<=a.length-3;j++){
                int sum = target-a[i]-a[j];
                HashSet<Integer> hash = new HashSet<>();
                for(int k=j+1;k<a.length;k++){
                    if(hash.contains(Math.abs(sum - a[k])))
                        ans.add(new ArrayList<>(Arrays.asList(a[i], a[j], Math.abs(sum - a[k]), a[k])));
                    hash.add(a[k]);
                }
                while(j<a.length-1&& a[j+1] == a[j]) j++;
            }
            while(i<a.length-1&& a[i+1] == a[i]) i++;
        }

        ans.sort((o1, o2) -> {
            var first = o1.get(0).compareTo(o2.get(0));
            var second = o1.get(1).compareTo(o2.get(1));
            var third = o1.get(2).compareTo(o2.get(2));
            var last = o1.get(3).compareTo(o2.get(3));
            if(first!=0)
                return first;
            if(second!=0)
                return second;
            if(third!=0)
                return third;
            else return last;
        });
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sum4 ob = new Sum4();
        int n = sc.nextInt();
        int k = sc.nextInt();
        var a = new int[n];
        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();
        System.out.println(ob.fourSum(a, k).toString());
    }
}

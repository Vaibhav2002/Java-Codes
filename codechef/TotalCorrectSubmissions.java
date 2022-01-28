package codechef;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TotalCorrectSubmissions {

    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            HashMap<String, Long> hash  = new HashMap<>();
            for(int i=0;i<n*3;i++){
                String code = sc.next();
                long submissions = sc.nextLong();
                hash.merge(code, submissions, Long::sum);
            }
            var subList = hash.values().stream().sorted().collect(Collectors.toList());
            for(Long value : subList){
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }
}

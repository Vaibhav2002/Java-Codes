package codechef;

import java.util.HashMap;
import java.util.Scanner;

public class DivideStudentsIntoClasses {
    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<n;i++)
                map.merge(sc.nextInt(), 1, Integer::sum);
            if(map.size()>12) System.out.println("No");
            else if(map.size() == 12) System.out.println("Yes");
            else{
                int left = 12-map.size();
                boolean possible = false;
                for(int i:map.keySet()){
                    if(map.get(i) == 1) continue;
                    int rem = map.get(i) - 1;
                    left-=rem;
                    if(left<=0) {
                        possible = true;
                        break;
                    }
                }
                System.out.println(possible?"Yes":"No");
            }
        }
    }
}

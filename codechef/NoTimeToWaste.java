package codechef;

import java.util.Scanner;

public class NoTimeToWaste {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),h=sc.nextInt(),x=sc.nextInt();
        boolean canBeDone=false;
        for (int i = 0; i <n ; i++) {
            int zone=sc.nextInt();
            if(x+zone>=h)
                canBeDone=true;
        }
        System.out.println(canBeDone?"YES":"NO");
    }
}

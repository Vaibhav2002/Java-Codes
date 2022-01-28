package codechef;

import java.util.Scanner;

public class AshishgupAndInterviews {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n=sc.nextInt(),k=sc.nextInt();
            int a[]=new int[n];
            boolean rejected=false,bot=false,tooslow=false;
            int solved=0;
            for (int i = 0; i < n; i++) {
                a[i]=sc.nextInt();
                if(a[i]!=-1)
                    solved++;
                if(a[i]!=-1&&a[i]>k)
                    tooslow=true;
            }
            if(solved<(int)Math.ceil((double)n/2))
                System.out.println("Rejected");
            else if(tooslow){
                System.out.println("Too slow");
            }
            else if(solved==n&&!tooslow){
                System.out.println("Bot");
            }
            else{
                System.out.println("Accepted");
            }
        }
    }
}


package codechef;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Cybalphabit {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        HashMap<Long,Integer> hash=new HashMap<>();
        for(int i=0;i<=25;i++){
            hash.put((long)(Math.pow(2,i)),i);
        }
        while(t-->0){
            int n=sc.nextInt();
            long k=sc.nextLong();
            char ans[]=new char[n];
            long totalval=n-k;
            Arrays.fill(ans,'a');
            for(int i=n-1;i>=0;i--){
                if (totalval>(long)Math.pow(2,25)){
                    ans[i]='z';
                    totalval=totalval-(long)(Math.pow(2,25))+1;
                }
                if(totalval==Math.pow(2,25)){
                    ans[i] = (char) (ans[i] + 'y');
                    totalval = 1;
                }
                else if(totalval > 0){
                    ans[i] = (char) (ans[i] + hash.get(totalval));
                    totalval = 0;
                }
                if(totalval == 0)
                    break;
            }
            System.out.println(Arrays.toString(ans));
        }
    }
}

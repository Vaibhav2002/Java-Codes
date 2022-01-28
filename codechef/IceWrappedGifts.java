package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class IceWrappedGifts {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] a =new int[2*n-1][2*n-1];
        for(int i=0 ;i<n;i++){
            for(int j=i;j<a.length-i;j++){
                for(int k=i;k<a.length-i;k++){
                    a[j][k]=n-i;
                }
            }
        }
        for(int[] i:a){
            for(int j:i)
                System.out.print(j+" ");
            System.out.println();
        }

    }
}

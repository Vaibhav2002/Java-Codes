package codeJam;

import java.util.Scanner;

public class PunchedCards {

    private static Scanner sc = new Scanner(System.in);

    private static void print(int testCase) {
        int r = sc.nextInt(), c = sc.nextInt();
        System.out.println("Case #"+testCase+":");
        for (int i = 0; i < 2 * c + 1; i++) {
            if (i <= 1) System.out.print(".");
            else System.out.print((i%2==0)?"+":"-");
        }
        System.out.println();
        for(int i=0;i<r;i++){
            for(int j =0;j<2*c+1;j++){
                if (i == 0 && j <= 1) System.out.print(".");
                else System.out.print((j%2==0)?"|":".");
            }
            System.out.println();
            for (int j = 0; j < 2 * c + 1; j++) {
                System.out.print((j%2==0)?"+":"-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-->0){
            print(t+1);
        }
    }
}

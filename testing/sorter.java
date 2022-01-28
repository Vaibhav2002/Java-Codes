package testing;

import java.util.Scanner;

public class sorter {
    int a[];
    Scanner sc=new Scanner(System.in);
    sorter(){
        a=new int[100];
    }
    void readlist(){
        for (int i = 0; i < 100; i++)
            a[i]=sc.nextInt();
    }
    void displaylist(){
        selectionsort();
        for (int i = 0; i < 100; i++) {
            System.out.print(a[i]+" ");
        }
    }
    int indexofmin(int startindex){
        int min=startindex+1;
        for (int i = startindex+1; i < 99; i++) {
            if(a[min]>a[i])
                min=i;
        }
        return min;
    }
    private void selectionsort() {
        for(int i=0;i<99;i++){
            int min=i;
            for (int j = i+1; j < 100; j++) {
                if(a[j]<a[min])
                    min=j;
            }
            int temp=a[min];
            a[min]=a[i];
            a[i]=temp;
        }
    }
}

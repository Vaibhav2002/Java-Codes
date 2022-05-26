package gfg.tree;

public class HeightUsingParentArray {
    static int findHeight(int n, int arr[]){
        int maxIndex = findMax(arr);
        int height = 0;
        while (arr[maxIndex]!=-1){
            height++;
            maxIndex = arr[maxIndex];
        }
        return height;
    }

    static int findMax(int arr[]){
        int max = 0;
        for(int i=0;i<arr.length;i++) if(arr[i]>arr[max]) max = i;
        return max;
    }
}

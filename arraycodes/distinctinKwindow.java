package arraycodes;

import java.util.HashMap;
import java.util.Scanner;

public class distinctinKwindow {
    void count(int a[], int k) {
        int count = 0;
        HashMap<Integer, Integer> ob = new HashMap<>();
        for (int i = 0; i < k; i++) //add elements of 1st window in the map
            if (ob.containsKey(a[i])) //if lready exists inc. its count
                ob.put(a[i], ob.get(a[i]) + 1);
            else
                ob.put(a[i], 1); //else add it
        count = ob.size(); //save count of distinct elements
        System.out.print(count+" "); //print count of 1st window
        for (int i = k; i < a.length; i++) {
            //remove 1st element of prev window
            if (ob.get(a[i - k]) == 1) { //if exists only once, remove and decrease count by 1
                ob.remove(a[i - k]);
                count--;
            } else
                ob.put(a[i - k], ob.get(a[i - k]) - 1); //if exists morethan once decrease its count
            //add new element to window
            if (ob.containsKey(a[i])) //if it already contains the value , increase its freq
                ob.put(a[i], ob.get(a[i]) + 1);
            else {
                ob.put(a[i], 1); //else add that element and increase count by 1
                count++;
            }
            System.out.print(count+" "); //print count of distinct of every window
        }
    }

    public static void main(String[] args) {
        distinctinKwindow ob=new distinctinKwindow();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of array elements");
        int a[] = new int[sc.nextInt()];
        System.out.println("Enter array elements");
        for (int i = 0; i < a.length; i++)
            a[i] = sc.nextInt();
        System.out.println("Enter value of k");
        ob.count(a,sc.nextInt());
    }
}

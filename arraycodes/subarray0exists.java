package arraycodes;

import java.util.HashSet;
import java.util.Scanner;

public class subarray0exists {
    boolean exist(int a[]) {
        HashSet<Integer> ob = new HashSet<>();
        int sum = 0;
        for (int i : a) {
            sum += i;
            //check if the current value is 0
            //check if sum till now is 0
            //check if the set already contains sum
            //if any of the above is true then subarray is found
            if (i == 0 || sum == 0 || ob.contains(sum))
                return true;
            ob.add(sum); //add the sum value to the set
        }
        return false;
    }

    public static void main(String[] args) {
        subarray0exists ob = new subarray0exists();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of array elements");
        int a[] = new int[sc.nextInt()];
        System.out.println("Enter array elements");
        for (int i = 0; i < a.length; i++)
            a[i] = sc.nextInt();
        System.out.println(ob.exist(a) ? "Exists" : "Does not exist");
    }
}

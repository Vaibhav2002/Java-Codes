package dsaSprint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class CommonElements {

    int getIndex(int a[], int index) {
        while (index < a.length - 1 && a[index + 1] == a[index]) {
            index++;
        }
        return index + 1;
    }
    /**
     * Time complexity - O(n1+n2+n3)
     * Space Complexity - O(1)
     * Result will be in sorted order already
     */
    ArrayList<Integer> commonElements(int a[], int b[], int c[], int n1, int n2, int n3) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2 && k < n3) {
            if (a[i] == b[j] && b[j] == c[k]) {
                ans.add(a[i]);
                i = getIndex(a, i);
                j = getIndex(b, j);
                k = getIndex(c, k);
            } else if (a[i] < b[j])
                i = getIndex(a, i);
            else if (b[j] < c[k])
                j = getIndex(b, j);
            else
                k = getIndex(c, k);
        }
        return ans;
    }

    /**
     * Time complexity - O(n1+n2+n3)
     * Space Complexity - O(n1+n2+n3)
     * To want result in sorted order time complexity increases by O(log(n1+n2+n3))
     */
    ArrayList<Integer> commonElementsUsingSet(int a[], int b[], int c[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        var set1 = Arrays.stream(a).boxed().collect(Collectors.toSet());
        var set2 = Arrays.stream(b).boxed().collect(Collectors.toSet());
        var set3 = Arrays.stream(c).boxed().collect(Collectors.toSet());
        for (Integer i : set1) {
            if (set2.contains(i) && set3.contains(i))
                ans.add(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        int a[] = {1, 5, 10, 20, 40, 80};
        int b[] = {6, 7, 20, 80, 100};
        int c[] = {3, 4, 15, 20, 30, 70, 80, 120};
        CommonElements ob = new CommonElements();
        ArrayList<Integer> ans = ob.commonElements(a, b, c, a.length, b.length, c.length);
        System.out.println(ans);
    }
}
